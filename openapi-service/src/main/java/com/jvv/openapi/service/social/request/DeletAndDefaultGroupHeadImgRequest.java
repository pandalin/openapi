/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.request;

import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.meta.OpenApiField;
import org.apache.commons.digester.annotations.rules.SetTop;

import javax.validation.constraints.NotNull;


/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/4/13
 * @time 16:25
 */
public class DeletAndDefaultGroupHeadImgRequest extends ApiRequest {
	
	@NotNull
	@OpenApiField(desc = "token" )
	protected String token;
	
	@NotNull
	@OpenApiField(desc = "头像Id" )
	protected Long id;
	
	@NotNull
	@OpenApiField(desc = "群ID")
	protected String groupId;
	
	public String getToken () {
		return token;
	}
	
	public void setToken (String token) {
		this.token = token;
	}
	
	public Long getId () {
		return id;
	}
	
	public void setId (Long id) {
		this.id = id;
	}
	
	public String getGroupId () {
		return groupId;
	}
	
	public void setGroupId (String groupId) {
		this.groupId = groupId;
	}
}
