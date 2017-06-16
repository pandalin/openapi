/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.requset.login;

import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.meta.OpenApiField;

import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/3/17
 * @time 14:34
 */
public class UserLoginAndRegistRequest extends ApiRequest{
	
	//========== properties ==========
	
	@NotNull
	@OpenApiField(desc = "用户手机号", constraint = "必填")
	protected String userPhone;
	
	@OpenApiField(desc = "短信验证码")
	protected String msgCode;
	
	@OpenApiField(desc = "推荐人ID")
	protected String recommendId;
	/**
	 * 注册渠道  1:app注册 2:推广注册 3:其他合作平台的渠道
	 */
	@OpenApiField(desc = "注册渠道")
	protected Integer registerType;
	
	@OpenApiField(desc = "用户密码")
	protected String password;
	
	//========== getters and setters ==========
	public String getPassword () {
		return password;
	}
	
	public void setPassword (String password) {
		this.password = password;
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
	
	public String getMsgCode () {
		return msgCode;
	}
	
	public void setMsgCode (String msgCode) {
		this.msgCode = msgCode;
	}
	
	/**
	 * 返回 推荐人ID
	 */
	public String getRecommendId() {
		return recommendId;
	}
	
	/**
	 * 设置 推荐人ID
	 */
	public void setRecommendId(String recommendId) {
		this.recommendId = recommendId;
	}
	
	/**
	 * 返回 注册渠道  1:app注册 2:推广注册 3:其他合作平台的渠道
	 */
	public Integer getRegisterType() {
		return registerType;
	}
	
	/**
	 * 设置 注册渠道  1:app注册 2:推广注册 3:其他合作平台的渠道
	 */
	public void setRegisterType(Integer registerType) {
		this.registerType = registerType;
	}
}
