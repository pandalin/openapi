/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.requset.userpwd;

import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.meta.OpenApiField;

import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA
 * 〈重置密码请求参数〉 <p>
 * 〈重置密码请求参数〉
 *
 * @author linxm
 * @date 2017/3/16
 * @time 9:16
 */
public class UserResetPwdRequest extends ApiRequest {
	
	@NotNull
	@OpenApiField(desc = "userId",constraint = "必填")
	private String userId;
	
	@NotNull
	@OpenApiField(desc = "真实姓名",constraint = "必填")
	private String realname;
	
	@NotNull
	@OpenApiField(desc = "身份证号码",constraint = "必填")
	private String idcard;
	
	@NotNull
	@OpenApiField(desc = "修改密码类型",constraint = "必填",demo = "0-登录密码，1-交易密码")
	private int pwdType;
	
	public String getUserId () {
		return userId;
	}
	
	public void setUserId (String userId) {
		this.userId = userId;
	}
	
	public String getRealname () {
		return realname;
	}
	
	public void setRealname (String realname) {
		this.realname = realname;
	}
	
	public String getIdcard () {
		return idcard;
	}
	
	public void setIdcard (String idcard) {
		this.idcard = idcard;
	}
	
	public int getPwdType () {
		return pwdType;
	}
	
	public void setPwdType (int pwdType) {
		this.pwdType = pwdType;
	}
}
