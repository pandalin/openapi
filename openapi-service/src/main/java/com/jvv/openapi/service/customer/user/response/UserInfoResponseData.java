/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.response;

import com.jvv.customer.facade.user.info.UserInfoInfo;
import com.jvv.openapi.core.service.entity.AbstractResponseData;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author zhaoyk
 * @date
 * @time
 */
public class UserInfoResponseData extends AbstractResponseData {
	/**
	 * 用户ID(唯一标示)
	 */
	protected String userId;
	/**
	 * 手机号
	 */
	protected String userPhone;
	/**
	 * 真实姓名
	 */
	protected String realname;
	/**
	 * 昵称
	 */
	protected String nickname;
	/**
	 * 用户类型 1普通用户  2VIP
	 */
	protected Integer userType;
	/**
	 * 性别 0:男 1:女
	 */
	protected Integer sex;
	/**
	 * 身份
	 */
	protected Integer identity;
	/**
	 * 出生日期
	 */
	protected Date birthday;
	/**
	 * 推荐人ID
	 */
	protected String recommendId;
	/**
	 * 冻结状态  0:冻结 1:正常
	 */
	protected Integer frozenState;
	/**
	 * 异常状态
	 */
	protected Integer exceptionState;
	/**
	 * 身份证号
	 */
	protected String idcard;
	/**
	 * 邮箱
	 */
	protected String email;
	/**
	 * 注册时间
	 */
	protected Date registerTime;
	/**
	 * 常驻地
	 */
	protected String usualAddress;
	/**
	 * 实名认证状态
	 */
	protected Integer authenticationState;
	/**
	 * 头像
	 */
	protected String headImg;
	/**
	 * 创建时间
	 */
	protected Date createtime;
	/**
	 * 创建人
	 */
	protected String cteator;
	/**
	 * 修改时间
	 */
	protected Date updatetime;
	/**
	 * 最后一次登录时间
	 */
	protected  Date lastLogin;
	
	/**
	 * 修改人
	 */
	protected String updater;
	/**
	 * 窝窝号
	 */
	protected String jwwId;
	/**
	 * 注册渠道  1:app注册 2:推广注册 3:其他合作平台的渠道
	 */
	protected Integer registerType;
	/**
	 * QQ绑定状态
	 */
	protected  Integer qqBind ;
	/**
	 *  微信绑定状态
	 */
	protected Integer wxBind ;
	
	protected List<UserInfoInfo> userInfoInfos;
	
	
	
	//========== getters and setters ==========
	/**
	 * 返回 用户ID(唯一标示)
	 */
	public String getUserId() {
		return userId;
	}
	
	/**
	 * 设置 用户ID(唯一标示)
	 */
	public void setUserId(String userId) {
		this.userId = userId;
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
	 * 返回 真实姓名
	 */
	public String getRealname() {
		return realname;
	}
	
	/**
	 * 设置 真实姓名
	 */
	public void setRealname(String realname) {
		this.realname = realname;
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
	 * 返回 用户类型 1普通用户  2VIP
	 */
	public Integer getUserType() {
		return userType;
	}
	
	/**
	 * 设置 用户类型 1普通用户  2VIP
	 */
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	/**
	 * 返回 性别 0:男 1:女
	 */
	public Integer getSex() {
		return sex;
	}
	
	/**
	 * 设置 性别 0:男 1:女
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	/**
	 * 返回 出生日期
	 */
	public Date getBirthday() {
		return birthday;
	}
	
	/**
	 * 设置 出生日期
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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
	 * 返回 冻结状态  0:冻结 1:正常
	 */
	public Integer getFrozenState() {
		return frozenState;
	}
	
	/**
	 * 设置 冻结状态  0:冻结 1:正常
	 */
	public void setFrozenState(Integer frozenState) {
		this.frozenState = frozenState;
	}
	/**
	 * 返回 异常状态
	 */
	public Integer getExceptionState() {
		return exceptionState;
	}
	
	/**
	 * 设置 异常状态
	 */
	public void setExceptionState(Integer exceptionState) {
		this.exceptionState = exceptionState;
	}
	/**
	 * 返回 身份证号
	 */
	public String getIdcard() {
		return idcard;
	}
	
	/**
	 * 设置 身份证号
	 */
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	/**
	 * 返回 邮箱
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * 设置 邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 返回 注册时间
	 */
	public Date getRegisterTime() {
		return registerTime;
	}
	
	/**
	 * 设置 注册时间
	 */
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	/**
	 * 返回 常驻地
	 */
	public String getUsualAddress() {
		return usualAddress;
	}
	
	/**
	 * 设置 常驻地
	 */
	public void setUsualAddress(String usualAddress) {
		this.usualAddress = usualAddress;
	}
	/**
	 * 返回 实名认证状态
	 */
	public Integer getAuthenticationState() {
		return authenticationState;
	}
	
	/**
	 * 设置 实名认证状态
	 */
	public void setAuthenticationState(Integer authenticationState) {
		this.authenticationState = authenticationState;
	}
	/**
	 * 返回 头像
	 */
	public String getHeadImg() {
		return headImg;
	}
	
	/**
	 * 设置 头像
	 */
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	/**
	 * 返回 创建时间
	 */
	public Date getCreatetime() {
		return createtime;
	}
	
	/**
	 * 设置 创建时间
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	/**
	 * 返回 创建人
	 */
	public String getCteator() {
		return cteator;
	}
	
	/**
	 * 设置 创建人
	 */
	public void setCteator(String cteator) {
		this.cteator = cteator;
	}
	/**
	 * 返回 修改时间
	 */
	public Date getUpdatetime() {
		return updatetime;
	}
	
	/**
	 * 设置 修改时间
	 */
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	/**
	 * 返回 修改人
	 */
	public String getUpdater() {
		return updater;
	}
	
	/**
	 * 设置 修改人
	 */
	public void setUpdater(String updater) {
		this.updater = updater;
	}
	/**
	 * 返回 窝窝号
	 */
	public String getJwwId() {
		return jwwId;
	}
	
	/**
	 * 设置 窝窝号
	 */
	public void setJwwId(String jwwId) {
		this.jwwId = jwwId;
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
	
	public Integer getqqBind () {
		return qqBind;
	}
	
	public void setqqBind (Integer qqBind) {
		this.qqBind = qqBind;
	}
	
	public Integer getwxBind () {
		return wxBind;
	}
	
	public void setwxBind (Integer wxBind) {
		this.wxBind = wxBind;
	}
	
	public List<UserInfoInfo> getUserInfoInfos () {
		return userInfoInfos;
	}
	
	public void setUserInfoInfos (List<UserInfoInfo> userInfoInfos) {
		this.userInfoInfos = userInfoInfos;
	}
	
	public Integer getIdentity () {
		return identity;
	}
	
	public void setIdentity (Integer identity) {
		this.identity = identity;
	}
}
