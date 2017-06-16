/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.requset.loginfo;

import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.meta.OpenApiField;

import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/3/15
 * @time 14:27
 */
public class UserLoginLogInfoCommitRequest extends ApiRequest {
	
	@NotNull
	@OpenApiField(desc = "token", constraint = "必填")
	private String token;
	
	@NotNull
	@OpenApiField(desc = "用户手机号", constraint = "必填")
	private String userPhone;
	
	@OpenApiField(desc = "用户昵称")
	private String nickname;
	
	//@OpenApiField(desc = "设备品牌")
	//private String equipment;
	
	//@OpenApiField(desc = "设备系统版本")
	//private String systemVer;
	
	@OpenApiField(desc = "登录ip")
	private String ip;
	
	//@OpenApiField(desc = "APP版本号")
	//private String appVer;
	
	@OpenApiField(desc = "登陆方式")
	private String loginType;
	
	@OpenApiField(desc = "第三方登录记录")
	private String loginRemark;
	
	//========== getters and setters ==========
	
	
	public String getToken () {
		return token;
	}
	public void setToken (String token) {
		this.token = token;
	}
	/**
	 * 返回 手机号
	 */
	public String getUserPhone() {
		return userPhone;
	}
	
	/**
	 * 设置 手机号
	 */
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	/**
	 * 返回 昵称
	 */
	public String getNickname() {
		return nickname;
	}
	
	/**
	 * 设置 昵称
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	/**
	 * 返回 登录ip
	 */
	public String getIp() {
		return ip;
	}
	
	/**
	 * 设置 登录ip
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	/**
	 * 返回 登陆方式
	 */
	public String getLoginType() {
		return loginType;
	}
	
	/**
	 * 设置 登陆方式
	 */
	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}
	/**
	 * 返回 第三方登录记录
	 */
	public String getLoginRemark() {
		return loginRemark;
	}
	
	/**
	 * 设置 第三方登录记录
	 */
	public void setLoginRemark(String loginRemark) {
		this.loginRemark = loginRemark;
	}
}
