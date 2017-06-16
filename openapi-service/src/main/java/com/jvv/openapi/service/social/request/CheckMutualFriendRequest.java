/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.request;

import com.jvv.common.services.order.validation.Query;
import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.meta.OpenApiField;

import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/4/7
 * @time 17:33
 */
public class CheckMutualFriendRequest extends ApiRequest {
	/**
	 * 用户本人ID
	 */
	@OpenApiField(desc = "用户本身的ID")
	@NotNull
	protected String token;
	/**
	 * 对方ID
	 */
	@OpenApiField(desc = "好友ID")
	@NotNull
	protected String friendId;
	
	public String getToken () {
		return token;
	}
	
	public void setToken (String token) {
		this.token = token;
	}
	
	public String getFriendId () {
		return friendId;
	}
	
	public void setFriendId (String friendId) {
		this.friendId = friendId;
	}
	
}
