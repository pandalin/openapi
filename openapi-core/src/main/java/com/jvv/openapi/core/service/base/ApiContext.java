/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-22 22:38 创建
 *
 */
package com.jvv.openapi.core.service.base;

import com.jvv.openapi.common.util.GidGenerater;
import com.jvv.openapi.core.service.ApiConstants;
import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;

import java.util.Map;

/**
 * Api服务当前线程会话上线文对象
 *
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/22 22:38
 */

public class ApiContext {
	private String gid;
	
	private OpenApiService openApiService;
	
	Map<String, String> requestData;
	
	private String redirectUrl;
	
	private String serviceName;
	
	@SuppressWarnings("rawtypes")
	private ApiService apiService;
	
	private ApiRequest request;
	
	private ApiResponse response;
	
	private String userAgent;

	/**
	 * 商户信息
	 */
	private MerchantInfo merchantInfo;

	/** 覆盖ApiService上定义的响应方式 */
	private ResponseTypeEnum overrideResponseType;


	private boolean repeated = false;

	public String getGid() {
		return gid;
	}
	
	public void setGid(String gid) {
		this.gid = gid;
	}
	
	public void initGid() {
		gid = GidGenerater.generateGid(ApiConstants.GID_BIZ_CODE);
	}
	
	public OpenApiService getOpenApiService() {
		return openApiService;
	}
	
	public void setOpenApiService(OpenApiService openApiService) {
		this.openApiService = openApiService;
		setServiceName(openApiService.name());
	}
	
	public Map<String, String> getRequestData() {
		return requestData;
	}
	
	public void setRequestData(Map<String, String> requestData) {
		this.requestData = requestData;
	}
	
	/**
	 * 响应类型是否是重定向
	 *
	 * @return
	 */
	public boolean isRedirect() {
		
		if (getOverrideResponseType() != null
			&& getOverrideResponseType() == ResponseTypeEnum.REDIRECT) {
			return true;
		}
		
		if (openApiService == null) {
			return false;
		}
		return openApiService.responseType() == ResponseTypeEnum.REDIRECT;
	}
	
	public String getRedirectUrl() {
		return redirectUrl;
	}
	
	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}
	
	public String getServiceName() {
		return serviceName;
	}
	
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	
	public ApiService getApiService() {
		return apiService;
	}
	
	public void setApiService(ApiService apiService) {
		this.apiService = apiService;
	}
	
	public void init(Map<String, String> requestData, ApiService apiService) {
		this.setOpenApiService(apiService.getClass().getAnnotation(OpenApiService.class));
		this.setRequestData(requestData);
		this.setApiService(apiService);
	}
	
	public ResponseTypeEnum getOverrideResponseType() {
		return overrideResponseType;
	}
	
	public void setOverrideResponseType(ResponseTypeEnum overrideResponseType) {
		this.overrideResponseType = overrideResponseType;
	}
	
	public String getUserAgent() {
		return userAgent;
	}
	
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}
	
	public ApiRequest getRequest() {
		return this.request;
	}
	
	public void setRequest(ApiRequest request) {
		this.request = request;
	}
	
	public ApiResponse getResponse() {
		return this.response;
	}
	
	public void setResponse(ApiResponse response) {
		this.response = response;
	}

	public MerchantInfo getMerchantInfo() {
		return merchantInfo;
	}

	public void setMerchantInfo(MerchantInfo merchantInfo) {
		this.merchantInfo = merchantInfo;
	}

	public boolean isRepeated() {
		return repeated;
	}

	public void setRepeated() {
		this.repeated = true;
	}
}
