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
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author linxm
 * @date 2017/3/22
 * @time 18:00
 */
public class UserPwdRequest extends ApiRequest {
	
	@NotNull
	@OpenApiField(desc = "token", constraint = "必填")
	private String token;
	
	@NotNull
	@OpenApiField(desc = "密码",constraint = "必填")
	private String password;
	
	@NotNull
	@OpenApiField(desc = "确认密码",constraint = "必填")
	private String confirmPassword;

	@NotNull
	@OpenApiField(desc = "动态码",constraint = "必填")
	private String smsCode;
	
	@NotNull
	@OpenApiField(desc = "密码类型",constraint = "必填")
	private String pwdType;
	
	public String getToken () {
		return token;
	}
	
	public void setToken (String token) {
		this.token = token;
	}
	
	public String getPassword () {
		return password;
	}
	
	public void setPassword (String password) {
		this.password = password;
	}
	
	public String getConfirmPassword () {
		return confirmPassword;
	}
	
	public void setConfirmPassword (String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	public String getPwdType () {
		return pwdType;
	}
	
	public void setPwdType (String pwdType) {
		this.pwdType = pwdType;
	}

	public String getSmsCode() {
		return smsCode;
	}

	public void setSmsCode(String smsCode) {
		this.smsCode = smsCode;
	}
}
