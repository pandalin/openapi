/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.response;

import com.jvv.customer.facade.user.info.UserInfoInfo;
import com.jvv.customer.facade.user.info.UserVipLogInfo;
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
public class VipUserRankResponseData extends AbstractResponseData {
	/**
	 * 用户ID
	 */
	protected String userId;
	/**
	 *
	 */
	protected String recommendId;
	
	protected UserInfoInfo userInfoInfo;
	/**
	 * 成为vip时间
	 */
	protected Date vipTime;
	/**
	 *
	 */
	protected Date createtime;
	
	protected List<UserVipLogInfo> userVipLogInfoList;
	
	protected Integer vipCount;
	
	//========== getters and setters ==========
	
	
	public Integer getVipCount () {
		return vipCount;
	}
	
	public void setVipCount (Integer vipCount) {
		this.vipCount = vipCount;
	}
	
	public List<UserVipLogInfo> getUserVipLogInfoList () {
		return userVipLogInfoList;
	}
	
	public void setUserVipLogInfoList (List<UserVipLogInfo> userVipLogInfoList) {
		this.userVipLogInfoList = userVipLogInfoList;
	}
	
	public UserInfoInfo getUserInfoInfo () {
		return userInfoInfo;
	}
	
	public void setUserInfoInfo (UserInfoInfo userInfoInfo) {
		this.userInfoInfo = userInfoInfo;
	}
	
	/**
	 * 返回 用户ID
	 */
	public String getUserId() {
		return userId;
	}
	
	/**
	 * 设置 用户ID
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 返回
	 */
	public String getRecommendId() {
		return recommendId;
	}
	
	/**
	 * 设置
	 */
	public void setRecommendId(String recommendId) {
		this.recommendId = recommendId;
	}
	/**
	 * 返回 成为vip时间
	 */
	public Date getVipTime() {
		return vipTime;
	}
	
	/**
	 * 设置 成为vip时间
	 */
	public void setVipTime(Date vipTime) {
		this.vipTime = vipTime;
	}
	/**
	 * 返回
	 */
	public Date getCreatetime() {
		return createtime;
	}
	
	/**
	 * 设置
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
}
