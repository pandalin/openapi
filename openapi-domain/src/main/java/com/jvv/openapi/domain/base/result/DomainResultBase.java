/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-20 09:44 创建
 *
 */
package com.jvv.openapi.domain.base.result;

import com.jvv.openapi.common.exception.ResultCode;
import com.jvv.openapi.facade.constants.enums.Status;

import java.io.Serializable;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/20 9:44
 */

public abstract class DomainResultBase implements Serializable {
	private Status status;
	private ResultCode resultCode;
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public ResultCode getResultCode() {
		return resultCode;
	}
	
	public void setResultCode(ResultCode resultCode) {
		this.resultCode = resultCode;
	}
}
