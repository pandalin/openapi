/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-24 20:24 创建
 *
 */
package com.jvv.openapi.core.service;

import com.jvv.openapi.common.exception.ResultCode;
import com.jvv.openapi.core.service.base.ApiServiceResultCode;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/24 20:24
 */

public class ParamFormatException extends ApiServiceException {
	private String requiredTypeOrFormat;

	public ParamFormatException (ResultCode resultCode, String message) {
		super (resultCode, message);
	}

	/**
	 *
	 * @param paramName 参数名
	 * @param paramValue 参数值
	 * @param requiredTypeOrFormat 期望的类型.
	 */
	public ParamFormatException(String paramName, Object paramValue, String requiredTypeOrFormat) {
		super(ApiServiceResultCode.PARAM_FORMAT_ERROR, "参数" + paramName + "=" + paramValue
														+ ",格式错误,需要的:" + requiredTypeOrFormat);
		this.requiredTypeOrFormat = requiredTypeOrFormat;
	}
	
	public String getRequiredTypeOrFormat() {
		return requiredTypeOrFormat;
	}
	
	public void setRequiredTypeOrFormat(String requiredTypeOrFormat) {
		this.requiredTypeOrFormat = requiredTypeOrFormat;
	}
}
