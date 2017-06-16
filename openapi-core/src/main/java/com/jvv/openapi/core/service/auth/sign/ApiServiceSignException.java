/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-23 22:01 创建
 *
 */
package com.jvv.openapi.core.service.auth.sign;

import com.jvv.openapi.common.exception.ResultCode;
import com.jvv.openapi.core.service.auth.ApiServiceAuthException;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/23 22:01
 */

public class ApiServiceSignException extends ApiServiceAuthException {
	public ApiServiceSignException () {
		super ();
	}

	public ApiServiceSignException (ResultCode resultCode) {
		super (resultCode);
	}

	public ApiServiceSignException (ResultCode resultCode, String message) {
		super (resultCode, message);
	}

	public ApiServiceSignException (String message) {
		super (message);
	}

	public ApiServiceSignException (String message, Throwable cause) {
		super (message, cause);
	}

	public ApiServiceSignException (Throwable cause) {
		super (cause);
	}
}
