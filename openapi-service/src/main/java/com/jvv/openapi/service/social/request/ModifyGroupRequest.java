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
 * @author liujf
 * @date 2017/4/11
 * @time 14:28
 */
public class ModifyGroupRequest extends ApiRequest{
	/**
	 * 群聊ID
	 */
	@NotNull
	@OpenApiField(desc = "群聊ID")
	protected String groupId;
	
	@OpenApiField(desc = "群介绍")
	protected String groupIntroduce;
	
	@OpenApiField(desc = "群名称")
	protected String groupName;
	
	@OpenApiField(desc = "是否全体禁言")
	protected Boolean isAllBanned;
	
	@OpenApiField(desc = "是否需要验证入群")
	protected Boolean isVerifyJoin;
	
	@OpenApiField(desc = "群头像")
	protected String groupHeadImg;
	
	public String getGroupIntroduce () {
		return groupIntroduce;
	}
	
	public void setGroupIntroduce (String groupIntroduce) {
		this.groupIntroduce = groupIntroduce;
	}
	
	public String getGroupName () {
		return groupName;
	}
	
	public void setGroupName (String groupName) {
		this.groupName = groupName;
	}
	
	public Boolean getIsAllBanned() {
		return isAllBanned;
	}
	
	public void setIsAllBanned(Boolean isAllBanned) {
		this.isAllBanned = isAllBanned;
	}
	
	public Boolean getIsVerifyJoin() {
		return isVerifyJoin;
	}

	public void setIsVerifyJoin(Boolean isVerifyJoin) {
		this.isVerifyJoin = isVerifyJoin;
	}
	
	
	public String getGroupHeadImg () {
		return groupHeadImg;
	}
	
	public void setGroupHeadImg (String groupHeadImg) {
		this.groupHeadImg = groupHeadImg;
	}
	
	public String getGroupId () {
		return groupId;
	}
	
	public void setGroupId (String groupId) {
		this.groupId = groupId;
	}
}
