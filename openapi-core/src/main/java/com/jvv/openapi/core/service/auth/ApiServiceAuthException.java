/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-22 22:01 创建
 *
 */
package com.jvv.openapi.core.service.auth;

import com.jvv.openapi.core.exception.FrameworkException;
import com.jvv.openapi.common.exception.ResultCode;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/22 22:01
 */

public class ApiServiceAuthException extends FrameworkException {
	public ApiServiceAuthException () {
		super ();
	}

	public ApiServiceAuthException (ResultCode resultCode) {
		super (resultCode);
	}

	public ApiServiceAuthException (ResultCode resultCode, String message) {
		super (resultCode, message);
	}

	public ApiServiceAuthException (String message) {
		super (message);
	}

	public ApiServiceAuthException (String message, Throwable cause) {
		super (message, cause);
	}

	public ApiServiceAuthException (Throwable cause) {
		super (cause);
	}
}
