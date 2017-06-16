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
 * @author Huangw
 * @date 2017/4/13
 * @time 16:25
 */
public class UploadAndGetGroupHeadImgRequest extends ApiRequest {
	
	@NotNull
	@OpenApiField(desc = "token" )
	protected String token;
	
	@NotNull
	@OpenApiField(desc = "群ID")
	protected String groupId;
	
	@OpenApiField(desc = "头像地址")
	protected String imgUrl;
	
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
	
	
	public String getImgUrl () {
		return imgUrl;
	}
	
	public void setImgUrl (String imgUrl) {
		this.imgUrl = imgUrl;
	}
}
