/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.request;

import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.meta.OpenApiField;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/4/7
 * @time 14:30
 */
public class CheckGroupRequest extends ApiRequest {
	/**
	 * 用户ID
	 */
	@OpenApiField(desc = "token")
	@NotBlank
	protected String token;
	
	/**
	 * 群ID
	 */
	@OpenApiField(desc = "群ID")
	@NotBlank
	protected String groupId;
	
	public String getToken () {
		return token;
	}
	
	public void setToken (String token) {
		this.token = token;
	}
	
	public String getGroupId () {
		return groupId;
	}
	
	public void setGroupId (String groupId) {
		this.groupId = groupId;
	}
}
