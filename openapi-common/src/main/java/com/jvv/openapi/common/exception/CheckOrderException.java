/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-28 22:59 创建
 *
 */

package com.jvv.openapi.common.exception;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/28 22:59
 */

public class CheckOrderException extends OpenApiBizException {
	{
		setResultCode (ResultCode.INVALID_ARGUMENTS);
	}
	public CheckOrderException (String message) {
		super (message);
	}

	public CheckOrderException (String message, Throwable cause) {
		super (message, cause);
	}

	public CheckOrderException (Throwable cause) {
		super (cause);
	}
}
