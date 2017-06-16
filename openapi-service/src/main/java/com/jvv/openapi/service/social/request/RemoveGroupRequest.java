/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.request;
import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.meta.OpenApiField;

import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author lxb
 * @date 2017/4/10
 * @time 19:52
 */
public class RemoveGroupRequest extends ApiRequest {
	
	/**
	 * 操作者
	 */
	@NotNull
	@OpenApiField(desc = "token", constraint = "必填")
	protected String token;
	
	/**
	 * 群聊ID
	 */
	@NotNull
	@OpenApiField(desc = "群id", constraint = "必填")
	protected String groupId;
	
	
	
	public String getGroupId () {
		return groupId;
	}
	
	public void setGroupId (String groupId) {
		this.groupId = groupId;
	}
	
	public String getToken () {
		return token;
	}
	
	public void setToken (String token) {
		this.token = token;
	}
}
