/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-27 10:22 创建
 *
 */
package com.jvv.openapi.core.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/27 10:22
 */
@Component
public class ServiceConfigs {
	/** 服务默认的签约类型 */
	@Value("${service.default.sign.type}")
	private String defaultSignType;
	
	/** 返回是否签名 */
	@Value("${service.response.sign}")
	private String responseSign;

	/** 签约形式 */
	@Value("${service.sign.context.type}")
	private String signContextType;



	public String getDefaultSignType() {
		return defaultSignType;
	}
	
	public void setDefaultSignType(String defaultSignType) {
		this.defaultSignType = defaultSignType;
	}
	
	public String getResponseSign() {
		return responseSign;
	}
	
	/** 服务响应是否需要签名 */
	public boolean isResponseSign() {
		return toBoolean(responseSign);
	}
	
	public void setResponseSign(String responseSign) {
		this.responseSign = responseSign;
	}

	public String getSignContextType () {
		return signContextType;
	}

	public void setSignContextType (String signContextType) {
		this.signContextType = signContextType;
	}

	public static boolean toBoolean(String str) {
		if (null == str) {
			return false;
		}
		return "1".equals(str) || str.startsWith("t") || str.startsWith("T") || str.startsWith("y")
			   || str.startsWith("Y");
	}
}
