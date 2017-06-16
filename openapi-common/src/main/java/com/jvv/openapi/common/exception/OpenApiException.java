/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-26 16:05 创建
 *
 */
package com.jvv.openapi.common.exception;


/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/26 16:05
 */

public class OpenApiException extends CommonException {
	private ResultCode resultCode;
	
	private String detail;
	
	public OpenApiException() {
		super();
	}
	
	public OpenApiException(ResultCode resultCode) {
		super(resultCode.getMessage());
		this.resultCode = resultCode;
	}
	
	public OpenApiException(ResultCode resultCode, String message) {
		this(message);
		this.resultCode = resultCode;
	}
	
	public OpenApiException(String message) {
		super(message);
	}
	
	public OpenApiException(String message, Throwable cause) {
		super(message, cause);
	}
	public OpenApiException(ResultCode resultCode,Throwable cause) {
		super(resultCode.getMessage (), cause);
		setResultCode (resultCode);
	}

	public OpenApiException(Throwable cause) {
		super(cause);
	}
	
	public ResultCode getResultCode() {
		return resultCode;
	}
	
	public void setResultCode(ResultCode resultCode) {
		this.resultCode = resultCode;
	}
	
	public String getDetail() {
		return detail;
	}
	
	public void setDetail(String detail) {
		this.detail = detail;
	}
}
