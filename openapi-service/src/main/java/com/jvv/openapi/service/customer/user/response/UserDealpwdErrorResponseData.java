/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.response;

import com.jvv.openapi.core.service.entity.AbstractResponseData;

import java.util.Date;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date
 * @time
 */
public class UserDealpwdErrorResponseData extends AbstractResponseData{
	private String userId;
	
	private Long errCount;
	
	private Date updateTime;
	
	public String getUserId () {
		return userId;
	}
	
	public void setUserId (String userId) {
		this.userId = userId;
	}
	
	public Long getErrCount () {
		return errCount;
	}
	
	public void setErrCount (Long errCount) {
		this.errCount = errCount;
	}
	
	public Date getUpdateTime () {
		return updateTime;
	}
	
	public void setUpdateTime (Date updateTime) {
		this.updateTime = updateTime;
	}
}
