/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.requset.third;


import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.meta.OpenApiField;

import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author lxb
 * @date 2017/3/15
 * @time 10:04
 */
public class UserThirdBindingRequest extends ApiRequest {
	/**
	 *0：登录时关联   1：进入app内部绑定
	 */
	@NotNull
	@OpenApiField(desc = "绑定类型", constraint = "必填")
	protected String bindingType;
	
	@NotNull
	@OpenApiField(desc = "用户电话号码", constraint = "必填")
	protected String userPhone;
	
	@OpenApiField(desc = "验证码", constraint = "非必填")
	protected String SecurityCode;
	
	
	@NotNull
	@OpenApiField(desc = "三方类型", constraint ="必填")
	protected String thirdType;
	
	@NotNull
	@OpenApiField(desc = "openid", constraint = "必填")
	protected String openid;
	
	//protected String unionid;
	
	/**
	 * 昵称
	 */
	@NotNull
	@OpenApiField(desc = "昵称", constraint = "必填")
	protected String nickname;
	
	/**
	 * 性别 0:男 1:女
	 */
	@NotNull
	@OpenApiField(desc = "性别", constraint = "必填")
	protected Integer sex;
	
	/**
	 * 头像
	 *
	 */
	@NotNull
	@OpenApiField(desc = "头像", constraint = "必填")
	protected String headImg;
	
	@OpenApiField(desc = "描述", constraint = "非必填")
	protected String remark;
	
	public String getBindingType () {
		return bindingType;
	}
	
	public void setBindingType (String bindingType) {
		this.bindingType = bindingType;
	}
	
	public String getNickname () {
		return nickname;
	}
	
	public void setNickname (String nickname) {
		this.nickname = nickname;
	}
	
	public Integer getSex () {
		return sex;
	}
	
	public void setSex (Integer sex) {
		this.sex = sex;
	}
	
	public String getHeadImg () {
		return headImg;
	}
	
	public void setHeadImg (String headImg) {
		this.headImg = headImg;
	}
	
	public String getUserPhone () {
		return userPhone;
	}
	
	public void setUserPhone (String userPhone) {
		this.userPhone = userPhone;
	}
	
	public String getThirdType () {
		return thirdType;
	}
	
	public void setThirdType (String thirdType) {
		this.thirdType = thirdType;
	}
	
	public String getOpenid () {
		return openid;
	}
	
	public void setOpenid (String openid) {
		this.openid = openid;
	}
	
//	public String getUnionid () {
//		return unionid;
//	}
//
//	public void setUnionid (String unionid) {
//		this.unionid = unionid;
//	}
	
	public String getRemark () {
		return remark;
	}
	
	public void setRemark (String remark) {
		this.remark = remark;
	}
	
	public String getSecurityCode () {
		return SecurityCode;
	}
	
	public void setSecurityCode (String securityCode) {
		SecurityCode = securityCode;
	}
}
