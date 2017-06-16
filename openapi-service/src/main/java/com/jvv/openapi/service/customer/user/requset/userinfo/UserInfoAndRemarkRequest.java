/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.requset.userinfo;

import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.meta.OpenApiField;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/3/20
 * @time 17:21
 */
public class UserInfoAndRemarkRequest extends ApiRequest{
	@NotNull
	@OpenApiField(desc = "token", constraint = "必填")
	private String token;
	
	@OpenApiField(desc = "行业")
	protected String industry;
	
	@OpenApiField(desc = "公司")
	protected String company;
	
	@OpenApiField(desc = "职位")
	protected String post;
	
	@OpenApiField(desc = "家乡")
	protected String hometown;
	
	@OpenApiField(desc = "个人签名")
	protected String signature;
	
	@OpenApiField(desc = "个人说明")
	protected String personalDes;
	
	@OpenApiField(desc = "情感状态")
	protected String loveState;
	
	@OpenApiField(desc = "备注")
	protected String remark;
	
	@OpenApiField(desc = "真实姓名")
	protected String realname;
	
	@OpenApiField(desc = "昵称")
	protected String nickname;
	
	@OpenApiField(desc = "出生日期")
	protected String birthday;
	
	@OpenApiField(desc = "身份证号")
	protected String idcard;
	
	@OpenApiField(desc = "邮箱")
	protected String email;
	
	@OpenApiField(desc = "启动时间")
	protected Date lastLogin;
	
	@OpenApiField(desc = "常驻地")
	protected String usualAddress;
	
	@OpenApiField(desc = "实名认证状态")
	protected Integer authenticationState;
	
	@OpenApiField(desc = "头像")
	protected String headImg;
	
	@OpenApiField(desc = "身份")
	protected String identity;
	
	@OpenApiField(desc = "性别")
	protected Integer sex;
	
	@OpenApiField(desc = "是否第一次登陆 0 未登录过  1 非第一次登陆")
	protected Integer isFirstLogin;
	
	//////////////////////////////////////////////
	
	
	public Integer getIsFirstLogin () {
		return isFirstLogin;
	}
	
	public void setIsFirstLogin (Integer isFirstLogin) {
		this.isFirstLogin = isFirstLogin;
	}
	
	public Integer getSex () {
		return sex;
	}
	
	public void setSex (Integer sex) {
		this.sex = sex;
	}
	
	public String getIdentity () {
		return identity;
	}
	
	public void setIdentity (String identity) {
		this.identity = identity;
	}
	
	public String getToken () {
		return token;
	}
	public void setToken (String token) {
		this.token = token;
	}
	
	public String getIndustry () {
		return industry;
	}
	
	public void setIndustry (String industry) {
		this.industry = industry;
	}
	
	public String getCompany () {
		return company;
	}
	
	public void setCompany (String company) {
		this.company = company;
	}
	
	public String getPost () {
		return post;
	}
	
	public void setPost (String post) {
		this.post = post;
	}
	
	public String getHometown () {
		return hometown;
	}
	
	public void setHometown (String hometown) {
		this.hometown = hometown;
	}
	
	public String getSignature () {
		return signature;
	}
	
	public void setSignature (String signature) {
		this.signature = signature;
	}
	
	public String getPersonalDes () {
		return personalDes;
	}
	
	public void setPersonalDes (String personalDes) {
		this.personalDes = personalDes;
	}
	
	public String getLoveState () {
		return loveState;
	}
	
	public void setLoveState (String loveState) {
		this.loveState = loveState;
	}
	
	public String getRemark () {
		return remark;
	}
	
	public void setRemark (String remark) {
		this.remark = remark;
	}
	
	public String getRealname () {
		return realname;
	}
	
	public void setRealname (String realname) {
		this.realname = realname;
	}
	
	public String getNickname () {
		return nickname;
	}
	
	public void setNickname (String nickname) {
		this.nickname = nickname;
	}
	
	public String  getBirthday () {
		return birthday;
	}
	
	public void setBirthday (String birthday) {
		this.birthday = birthday;
	}
	
	public String getIdcard () {
		return idcard;
	}
	
	public void setIdcard (String idcard) {
		this.idcard = idcard;
	}
	
	public String getEmail () {
		return email;
	}
	
	public void setEmail (String email) {
		this.email = email;
	}
	
	public Date getLastLogin () {
		return lastLogin;
	}
	
	public void setLastLogin (Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	
	public String getUsualAddress () {
		return usualAddress;
	}
	
	public void setUsualAddress (String usualAddress) {
		this.usualAddress = usualAddress;
	}
	
	public Integer getAuthenticationState () {
		return authenticationState;
	}
	
	public void setAuthenticationState (Integer authenticationState) {
		this.authenticationState = authenticationState;
	}
	
	public String getHeadImg () {
		return headImg;
	}
	
	public void setHeadImg (String headImg) {
		this.headImg = headImg;
	}
}
