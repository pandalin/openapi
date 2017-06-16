/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-28 23:00 创建
 *
 */

package com.jvv.openapi.common.exception;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/28 23:00
 */

public class OpenApiBizException extends OpenApiException{
	public OpenApiBizException (ResultCode resultCode) {
		super (resultCode);
	}

	public OpenApiBizException (ResultCode resultCode, String message) {
		super (resultCode, message);
	}

	public OpenApiBizException (String message) {
		super (message);
	}

	public OpenApiBizException (String message, Throwable cause) {
		super (message, cause);
	}

	public OpenApiBizException (ResultCode resultCode, Throwable cause) {
		super (resultCode, cause);
	}

	public OpenApiBizException (Throwable cause) {
		super (cause);
	}
}
