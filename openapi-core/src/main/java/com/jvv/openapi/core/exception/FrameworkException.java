/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-22 19:50 创建
 *
 */
package com.jvv.openapi.core.exception;


import com.jvv.openapi.common.exception.OpenApiException;
import com.jvv.openapi.common.exception.ResultCode;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/22 19:50
 */

public class FrameworkException extends OpenApiException {
	public FrameworkException () {
		super();
	}
	
	public FrameworkException (ResultCode resultCode) {
		super (resultCode);
	}
	
	public FrameworkException (ResultCode resultCode, String message) {
		super (resultCode, message);
	}
	
	public FrameworkException (String message) {
		super (message);
	}
	
	public FrameworkException (String message, Throwable cause) {
		super (message, cause);
	}
	
	public FrameworkException (Throwable cause) {
		super (cause);
	}
}
