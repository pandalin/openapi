/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-24 19:48 创建
 *
 */
package com.jvv.openapi.core.service.marshall;

import com.google.common.base.Strings;
import com.jvv.openapi.core.service.ApiConstants;
import com.jvv.openapi.core.service.ServiceConfigs;
import com.jvv.openapi.core.service.auth.ApiAuthentication;
import com.jvv.openapi.core.service.auth.sign.SignerFactory;
import com.jvv.openapi.core.service.base.ApiService;
import com.jvv.openapi.core.service.base.ApiServiceResultCode;
import com.jvv.openapi.core.service.base.InternalApiContextHolder;
import com.jvv.openapi.core.service.entity.ApiNotify;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.entity.ApiReturn;
import com.jvv.openapi.core.service.entity.ISign;
import com.jvv.openapi.core.service.listener.event.BeforeResponseEvent;
import com.jvv.openapi.core.service.listener.multicaster.EventPublisher;
import com.jvv.openapi.core.service.marshall.crypt.ApiMarshallCryptService;
import com.jvv.openapi.core.service.meta.OpenApiField;
import com.jvv.openapi.core.support.LoggerHandler;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.Map;

/**
 * API返回报文抽象实现
 *
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/24 19:48
 */

public abstract class AbstractResponseMarshall<T> implements ApiResponseMarshall<T> {
	
	@Resource
	protected LoggerHandler systemLoggerHandler;
	@Resource
	protected ServiceConfigs serviceConfigs;
	
	@Resource
	protected ApiAuthentication apiAuthentication;
	@Resource
	protected SignerFactory<Map<String, String>> signerFactory;
	@Resource
	private EventPublisher eventPublisher;
	
	@Resource
	private ApiMarshallCryptService apiMarshallCryptService;
	
	@Override
	public T marshall(Object response) {
		ApiResponse apiResponse = (ApiResponse) response;
		ObjectAccessor objectAccessor = ObjectAccessor.of(apiResponse);
		
		//输出
		
		// 签名数据
		Map<String, String> signData = perSignData(apiResponse, objectAccessor);
		// 输出数据
		Map<String, Object> responseData = perMarshallData(apiResponse, objectAccessor);
		responseData.put(ApiConstants.SIGN, signData.get(ApiConstants.SIGN));
		
		doPublishBeforeResponseEvent(InternalApiContextHolder.getApiContext().getApiService(),
			responseData);
		doLogger(apiResponse, signData);
		return doMarshall(responseData);
	}
	
	protected Map<String, Object> perMarshallData(ApiResponse apiResponse,
													ObjectAccessor objectAccessor) {
		Map<String, Object> responseData = objectAccessor
			.getAllDataExcludeTransientForJsonProcess();
		doBeforeMarshall(apiResponse, responseData);
		doEncrypt(apiResponse, responseData);
		return responseData;
	}
	
	protected Map<String, String> perSignData(ApiResponse apiResponse, ObjectAccessor objectAccessor) {
		Map<String, String> signData = objectAccessor.getAllDataExcludeTransient();
		doBeforeMarshall(apiResponse, signData);
		doSign(apiResponse, signData);
		return signData;
	}
	
	protected abstract T doMarshall(Map<String, Object> responseData);
	
	/**
	 * 发布事件
	 * @param apiService
	 * @param responseData
	 */
	protected void doPublishBeforeResponseEvent(ApiService apiService,
												Map<String, Object> responseData) {
		if (eventPublisher.canPublishEvent(apiService)) {
			eventPublisher.publishEvent(new BeforeResponseEvent(responseData), apiService);
		}
	}
	
	/**
	 * 日志
	 * @param apiResponse
	 * @param responseData
	 */
	protected void doLogger(ApiResponse apiResponse, Map<String, String> responseData) {
		systemLoggerHandler.log(getLogLabel(apiResponse), responseData);
	}
	
	protected String getLogLabel(ApiResponse apiResponse) {
		String labelPostfix = (StringUtils.isNotBlank(apiResponse.getService()) ? "["
																				  + apiResponse
																						.getService()
																				  + "]:"
			: ":");
		if (ApiNotify.class.isAssignableFrom(apiResponse.getClass())) {
			return "异步通知" + labelPostfix;
		} else if (ApiReturn.class.isAssignableFrom(apiResponse.getClass())) {
			return "服务跳转" + labelPostfix;
		} else {
			return "服务响应" + labelPostfix;
		}
	}
	
	/**
	 * 加密
	 * @param apiResponse
	 * @param responseData
	 */
	protected void doEncrypt(ApiResponse apiResponse, Map<String, Object> responseData) {
		String partnerId = apiResponse.getPartnerId();
		
		if (Strings.isNullOrEmpty(partnerId)) {
			return;
		}
		String key = null;
		Object value = null;
		for (Map.Entry<String, Object> entry : responseData.entrySet()) {
			key = entry.getKey();
			value = entry.getValue();
			if (value instanceof String && !Strings.isNullOrEmpty((String) value)
				&& isSecurityField(apiResponse, key)) {
				responseData.put(key,
					apiMarshallCryptService.encrypt(key, (String) value, partnerId));
			}
		}
	}
	
	private boolean isSecurityField(ApiResponse apiResponse, String propertyName) {
		try {
			Field field = apiResponse.getClass().getDeclaredField(propertyName);
			if (field == null) {
				return false;
			}
			OpenApiField openApiField = field.getAnnotation(OpenApiField.class);
			return openApiField != null && openApiField.security();
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * 签名
	 * @param signData
	 */
	protected void doSign(ApiResponse apiResponse, Map<String, String> signData) {
		if (!serviceConfigs.isResponseSign()) {
			return;
		}
		
		if (apiResponse instanceof ISign) {
			ISign signObject = (ISign) apiResponse;
			String signType = signObject.getSignType();
			String partnerId = apiResponse.getPartnerId();
			
			String resultCode = apiResponse.getCode();
			doBeforeMarshall(apiResponse, signData);
			if (Strings.isNullOrEmpty(signType) || Strings.isNullOrEmpty(partnerId)) {
				return;
			}
			// 服务认证失败
			if (resultCode != null
				&& resultCode.equals(ApiServiceResultCode.UN_AUTHENTICATED_ERROR.getCode())) {
				return;
			}
			// 授权失败
			if (resultCode != null
				&& resultCode.equals(ApiServiceResultCode.UN_AUTHORIZED_ERROR.getCode())) {
				return;
			}
			apiAuthentication.signature(signData, partnerId, signType);
		}
	}
	
	protected void doBeforeMarshall(ApiResponse apiResponse, Map<String, ?> data) {
		
	}
	
}
