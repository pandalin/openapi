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
 * @time 9:45
 */

public class UserThirdLoginRequest extends ApiRequest {
	
//	@OpenApiField(desc = "用户电话号码", constraint = "非必填")
//	protected String userPhone;
//
//	@OpenApiField(desc = "验证码", constraint = "非必填")
//	protected String SecurityCode;
	
	@NotNull
	@OpenApiField(desc = "三方类型", constraint ="必填")
	protected String thirdType;
	
	@NotNull
	@OpenApiField(desc = "openID", constraint = "必填")
	protected String openid;
	
//	@OpenApiField(desc = "openID", constraint = "非必填")
//	protected String unionid;
//
//	@OpenApiField(desc = "描述", constraint = "非必填")
//	protected String remark;
	
//	/**
//	 * 昵称
//	 */
//	@OpenApiField(desc = "昵称", constraint = "非必填")
//	protected String nickname;
//
//	/**
//	 * 性别 0:男 1:女
//	 */
//	@OpenApiField(desc = "性别", constraint = "非必填")
//	protected Integer sex;
//
//	/**
//	 * 头像
//	 */
//	@OpenApiField(desc = "头像地址", constraint = "非必填")
//	protected String headImg;
	
//	public String getNickname () {
//		return nickname;
//	}
//
//	public void setNickname (String nickname) {
//		this.nickname = nickname;
//	}
//
//	public Integer getSex () {
//		return sex;
//	}
//
//	public void setSex (Integer sex) {
//		this.sex = sex;
//	}
//
//	public String getHeadImg () {
//		return headImg;
//	}
//
//	public void setHeadImg (String headImg) {
//		this.headImg = headImg;
//	}
//
//	public String getUserPhone () {
//		return userPhone;
//	}
//
//	public void setUserPhone (String userPhone) {
//		this.userPhone = userPhone;
//	}
//
//	public String getSecurityCode () {
//		return SecurityCode;
//	}
//
//	public void setSecurityCode (String securityCode) {
//		SecurityCode = securityCode;
//	}
	
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
//
//	public String getRemark () {
//		return remark;
//	}
//
//	public void setRemark (String remark) {
//		this.remark = remark;
//	}
}
