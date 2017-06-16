/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.response.topic;

import com.jvv.openapi.core.service.entity.AbstractResponseData;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author lxb
 * @date 2017/5/17
 * @time 13:29
 */
public class UserPraiseCountResponseData extends AbstractResponseData {
	private String userId;
	
	private Integer count;
	
	public String getUserId () {
		return userId;
	}
	
	public void setUserId (String userId) {
		this.userId = userId;
	}
	
	public Integer getCount () {
		return count;
	}
	
	public void setCount (Integer count) {
		this.count = count;
	}
	
	
	
}
