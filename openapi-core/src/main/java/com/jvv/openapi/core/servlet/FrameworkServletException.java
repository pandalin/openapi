/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-22 19:51 创建
 *
 */
package com.jvv.openapi.core.servlet;

import com.jvv.openapi.core.exception.FrameworkException;
import com.jvv.openapi.common.exception.ResultCode;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/22 19:51
 */

public class FrameworkServletException extends FrameworkException {
	
	public FrameworkServletException() {
		super();
	}
	
	public FrameworkServletException(ResultCode resultCode) {
		super(resultCode.getMessage());
	}
	
	public FrameworkServletException(String message) {
		super(message);
	}
	
	public FrameworkServletException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public FrameworkServletException(Throwable cause) {
		super(cause);
	}
}
