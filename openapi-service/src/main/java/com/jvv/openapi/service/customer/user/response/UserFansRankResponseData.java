/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.response;

import com.jvv.customer.facade.user.info.UserFansRankInfo;
import com.jvv.openapi.core.service.entity.AbstractResponseData;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date
 * @time
 */
public class UserFansRankResponseData extends AbstractResponseData {
	/**
	 * 用户ID(唯一标示)
	 */
	protected String userId;
	
	protected String realname;
	/**
	 * 手机号
	 */
	protected String userPhone;
	/**
	 *身份证号码
	 *  */
	protected String idcard;
	
	protected Integer userType;
	
	protected String recommendId;
	
	protected Date registerTime;
	
	protected Integer countFans;
	
	protected List<UserFansRankInfo> userFansRankInfoList;
	
	public List<UserFansRankInfo> getUserFansRankInfoList () {
		return userFansRankInfoList;
	}
	
	public void setUserFansRankInfoList (List<UserFansRankInfo> userFansRankInfoList) {
		this.userFansRankInfoList = userFansRankInfoList;
	}
	
	public Integer getCountFans () {
		return countFans;
	}
	
	public void setCountFans (Integer countFans) {
		this.countFans = countFans;
	}
	
	public String getRealname () {
		return realname;
	}
	
	public void setRealname (String realname) {
		this.realname = realname;
	}
	
	public String getUserId () {
		return userId;
	}
	
	public void setUserId (String userId) {
		this.userId = userId;
	}
	
	public String getUserPhone () {
		return userPhone;
	}
	
	public void setUserPhone (String userPhone) {
		this.userPhone = userPhone;
	}
	
	public String getIdcard () {
		return idcard;
	}
	
	public void setIdcard (String idcard) {
		this.idcard = idcard;
	}
	
	public Integer getUserType () {
		return userType;
	}
	
	public void setUserType (Integer userType) {
		this.userType = userType;
	}
	
	public String getRecommendId () {
		return recommendId;
	}
	
	public void setRecommendId (String recommendId) {
		this.recommendId = recommendId;
	}
	
	public Date getRegisterTime () {
		return registerTime;
	}
	
	public void setRegisterTime (Date registerTime) {
		this.registerTime = registerTime;
	}
}
