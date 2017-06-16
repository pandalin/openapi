/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.response;

import com.jvv.customer.facade.user.info.UserThirdBindingInfo;
import com.jvv.openapi.core.service.entity.AbstractResponseData;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author lxb
 * @date 2017/3/21
 * @time 18:25
 */
public class UserAccountSecureSettingResponseData extends AbstractResponseData {
	/**
	 * 实名认证状态
	 */
	protected Integer authenticationState;
	
	/**
	 * 手机号
	 */
	protected String userPhone;
	/**
	 * 登录密码是否设置  0：未设置  1：设置
	 */
	protected Integer loginPass;
	/**
	 *交易密码是否设置  0：未设置  1：设置
	 */
	protected Integer dealPass;
	
	/**
	 * wx 有就是id
	 */
	protected Long wx;
	
	/**
	 * QQ 有就是对应id
	 */
	protected Long qq;
	
	public Integer getAuthenticationState () {
		return authenticationState;
	}
	
	public void setAuthenticationState (Integer authenticationState) {
		this.authenticationState = authenticationState;
	}
	
	public String getUserPhone () {
		return userPhone;
	}
	
	public void setUserPhone (String userPhone) {
		this.userPhone = userPhone;
	}
	
	public Integer getLoginPass () {
		return loginPass;
	}
	
	public void setLoginPass (Integer loginPass) {
		this.loginPass = loginPass;
	}
	
	public Integer getDealPass () {
		return dealPass;
	}
	
	public void setDealPass (Integer dealPass) {
		this.dealPass = dealPass;
	}
	
	public Long getWx () {
		return wx;
	}
	
	public void setWx (Long wx) {
		this.wx = wx;
	}
	
	public Long getQq () {
		return qq;
	}
	
	public void setQq (Long qq) {
		this.qq = qq;
	}
}
