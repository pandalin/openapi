/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.request.topic;

import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.meta.OpenApiField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;


/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author lxb
 * @date 2017/5/17
 * @time 11:14
 */
public class UserPraiseRequest extends ApiRequest {
	
	@NotBlank
	@OpenApiField(desc = "token",constraint = "必填")
	private String token;
	
	
	@NotBlank
	@OpenApiField(desc = "圈子id",constraint = "必填")
	private String topicId;
	
	@NotNull
	@OpenApiField(desc = "点赞类型",constraint = "必填")
	private Integer praiseType;
	
	public String getToken () {
		return token;
	}
	
	public void setToken (String token) {
		this.token = token;
	}
	
	public String getTopicId () {
		return topicId;
	}
	
	public void setTopicId (String topicId) {
		this.topicId = topicId;
	}
	
	public Integer getPraiseType () {
		return praiseType;
	}
	
	public void setPraiseType (Integer praiseType) {
		this.praiseType = praiseType;
	}
}
