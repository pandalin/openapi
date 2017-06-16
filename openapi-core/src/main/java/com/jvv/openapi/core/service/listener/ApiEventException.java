/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-23 20:39 创建
 *
 */
package com.jvv.openapi.core.service.listener;

import com.jvv.openapi.core.exception.FrameworkException;
import com.jvv.openapi.common.exception.ResultCode;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/23 20:39
 */

public class ApiEventException extends FrameworkException {
	public ApiEventException () {
		super ();
	}

	public ApiEventException (ResultCode resultCode) {
		super (resultCode);
	}

	public ApiEventException (ResultCode resultCode, String message) {
		super (resultCode, message);
	}

	public ApiEventException (String message) {
		super (message);
	}

	public ApiEventException (String message, Throwable cause) {
		super (message, cause);
	}

	public ApiEventException (Throwable cause) {
		super (cause);
	}
}
