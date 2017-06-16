/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2017-03-12 22:29 创建
 *
 */
package com.jvv.openapi.common.exception;

/**
 * @author turalyon@jinvovo.com
 */
public class CommonException extends RuntimeException {
	public CommonException() {
		super();
	}

	public CommonException(String message) {
		super(message);
	}

	public CommonException(String message, Throwable cause) {
		super(message, cause);
	}

	public CommonException(Throwable cause) {
		super(cause);
	}

	protected CommonException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
