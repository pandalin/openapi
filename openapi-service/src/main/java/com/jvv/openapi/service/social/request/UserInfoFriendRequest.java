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
 * @date 2017/4/10
 * @time 18:30
 */
public class UserInfoFriendRequest extends ApiRequest {
	
	@NotNull
	@OpenApiField(desc = "token")
	protected String token;
	
	@NotNull()
	@OpenApiField(desc = "对方ID")
	protected String friendId;
	
	@OpenApiField(desc = "关系类型(1:关注 2:粉丝  3:好友  4:无关系(互相取消关注))")
	protected Long friendType;
	
	@OpenApiField(desc = "好友备注名")
	protected String nameRemark;
	
	@OpenApiField(desc = "备注")
	protected String remark;
	
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
	
	public Long getFriendType () {
		return friendType;
	}
	
	public void setFriendType (Long friendType) {
		this.friendType = friendType;
	}
	
	public String getNameRemark () {
		return nameRemark;
	}
	
	public void setNameRemark (String nameRemark) {
		this.nameRemark = nameRemark;
	}
	
	public String getRemark () {
		return remark;
	}
	
	public void setRemark (String remark) {
		this.remark = remark;
	}
}
