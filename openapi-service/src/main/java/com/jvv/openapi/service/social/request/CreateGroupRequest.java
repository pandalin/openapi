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
 * @time 20:04
 */
public class CreateGroupRequest extends ApiRequest {
	/**
	 * 创建人
	 */
	@NotNull
	@OpenApiField(desc = "token", constraint = "必填")
	protected String token;
	
	/**
	 * 群类型；条用php需要，金窝窝数据库并没有存储
	 */
	@NotNull
	@OpenApiField(desc = "群类型", constraint = "必填")
	protected  String groupType;
	
	/**
	 * 群成员集合（json）
	 */
	@NotNull(message = "至少邀请一名群成员")
	@OpenApiField(desc = "群成员", constraint = "必填")
	protected String memberList;
	
	/**
	 * 群介绍
	 */
//	@NotNull
	@OpenApiField(desc = "群介绍", constraint = "非必填")
	protected String groupIntroduce;
	
	public String getToken () {
		return token;
	}
	
	public void setToken (String token) {
		this.token = token;
	}
	
	public String getGroupType () {
		return groupType;
	}
	
	public void setGroupType (String groupType) {
		this.groupType = groupType;
	}
	
	public String getGroupIntroduce () {
		return groupIntroduce;
	}
	
	public void setGroupIntroduce (String groupIntroduce) {
		this.groupIntroduce = groupIntroduce;
	}
	
	public String getMemberList () {
		return memberList;
	}
	
	public void setMemberList (String memberList) {
		this.memberList = memberList;
	}
	
}
