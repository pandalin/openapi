/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-23 21:28 创建
 *
 */
package com.jvv.openapi.core.service;

import com.jvv.openapi.core.exception.FrameworkException;
import com.jvv.openapi.common.exception.ResultCode;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/23 21:28
 */

public class ApiServiceException extends FrameworkException {
	public ApiServiceException () {
		super ();
	}

	public ApiServiceException (ResultCode resultCode) {
		super (resultCode);
	}

	public ApiServiceException (ResultCode resultCode, String message) {
		super (resultCode, message);
	}

	public ApiServiceException (String message) {
		super (message);
	}

	public ApiServiceException (String message, Throwable cause) {
		super (message, cause);
	}

	public ApiServiceException (Throwable cause) {
		super (cause);
	}
}
