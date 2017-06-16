/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.common.exception;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author linxm
 * @date 2017/3/20
 * @time 19:35
 */
public class TokenNotExistException extends OpenApiBizException {
	{
		setResultCode (ResultCode.INVALID_ARGUMENTS);
	}
	public TokenNotExistException (String message) {
		super (message);
	}
	
	public TokenNotExistException (String message, Throwable cause) {
		super (message, cause);
	}
	
	public TokenNotExistException (Throwable cause) {
		super (cause);
	}
	
	
}
