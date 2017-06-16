/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-24 20:52 创建
 *
 */
package com.jvv.openapi.core.exception.handler;

import com.jvv.openapi.core.exception.FrameworkException;
import com.jvv.openapi.core.service.ApiServiceException;
import com.jvv.openapi.core.service.base.ApiServiceResultCode;
import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.facade.constants.enums.Status;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/24 20:52
 */
@Service
public class UnifiedApiServiceExceptionHandler implements ApiServiceExceptionHandler {
	/**
	 * 日志
	 */
	private static final Logger logger = LoggerFactory
		.getLogger(UnifiedApiServiceExceptionHandler.class);
	
	@Override
	public void handle(ApiRequest apiRequest, ApiResponse apiResponse, Throwable e) {
		
		if (ApiServiceException.class.isAssignableFrom(e.getClass())) {
			handle(apiResponse, (ApiServiceException) e);
		} else {
			handleInternalException(apiResponse, e);
		}
	}
	
	/**
	 * 服务异常处理
	 * @param apiResponse
	 * @param ase
	 */
	protected void handle(ApiResponse apiResponse, ApiServiceException ase) {
		logger.error("服务异常,message={}",ase.getMessage ());

		String resultCode = ase.getResultCode().getCode();
		String resultMessage = marshallResultMessage(ase.getResultCode().getMessage(),
			ase.getDetail());
		String detailMessage = ase.getMessage();
		
		String code = resultCode;
		
		if (ApiServiceResultCode.INVALID_ARGUMENTS.getCode().equals(code)) {
			// 下层服务的参数错误,则直接使用下层抛出的description
			resultMessage = marshallResultMessage(
				ApiServiceResultCode.INVALID_ARGUMENTS.getMessage(), ase.getDetail());
		} else {
			// 业务错误,查询远程错误码系统
			String businessMessage = doQueryUnifiedErrorMessage(code, ase.getDetail());
			if (StringUtils.isNotBlank(businessMessage)) {
				apiResponse.setMessage(businessMessage);
			}
		}
		apiResponse.setStatus(Status.FAIL.getCode());
		apiResponse.setCode(resultCode);
		apiResponse.setMessage(resultMessage);
		apiResponse.setDetailMessage(detailMessage);
	}
	
	private String marshallResultMessage(String message, String detail) {
		message = StringUtils.trimToEmpty(message);
		detail = StringUtils.trimToEmpty(detail);
		if (StringUtils.isNotBlank(message) && StringUtils.isNotBlank(detail)) {
			return message + ":" + detail;
		} else {
			return message + detail;
		}
	}
	
	/**
	 * 系统异常处理
	 * @param apiResponse
	 */
	protected void handleInternalException(ApiResponse apiResponse, Throwable e) {
		FrameworkException frameworkException = null;
		
		if (e instanceof FrameworkException) {
			frameworkException = (FrameworkException) e;
		}
		if (frameworkException != null && frameworkException.getResultCode() != null) {
			apiResponse.setCode(frameworkException.getResultCode().getCode());
			apiResponse.setMessage(frameworkException.getResultCode().getMessage());
			logger.error("服务异常,message={}",e.getMessage ());
		} else {
			apiResponse.setCode(ApiServiceResultCode.INTERNAL_ERROR.getCode());
			apiResponse.setMessage(ApiServiceResultCode.INTERNAL_ERROR.getMessage());
			logger.error("服务执行内部错误", e.getMessage());
		}
		apiResponse.setDetailMessage(e.getMessage());
	}
	
	/**
	 * 通过远本地组件链接远程错误码系统查询错误消息
	 *
	 * @param code
	 * @return
	 */
	protected String doQueryUnifiedErrorMessage(String code, String description) {
		return null;
		//				try {
		//					return interpretation.getInterpretationD(code,)
		//				} catch (Exception ex) {
		//					logger.warn("错误码系统查询业务错误消息失败,errorCode:{}, exception:{}", errorCode, ex.getMessage());
		//					return null;
		//				}
	}
}
