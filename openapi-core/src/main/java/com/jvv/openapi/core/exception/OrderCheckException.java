/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-23 21:27 创建
 *
 */
package com.jvv.openapi.core.exception;

import com.jvv.openapi.common.exception.ResultCode;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/23 21:27
 */

public class OrderCheckException extends FrameworkException {
	public OrderCheckException () {
		super ();
	}

	public OrderCheckException (ResultCode resultCode) {
		super (resultCode);
	}

	public OrderCheckException (ResultCode resultCode, String message) {
		super (resultCode, message);
	}

	public OrderCheckException (String message) {
		super (message);
	}

	public OrderCheckException (String message, Throwable cause) {
		super (message, cause);
	}

	public OrderCheckException (Throwable cause) {
		super (cause);
	}
}
