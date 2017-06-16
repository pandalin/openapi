/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.response;

import com.jvv.customer.facade.user.info.UserInfoInfo;
import com.jvv.customer.facade.user.info.UserLocateInfo;
import com.jvv.customer.facade.user.info.UserLookRecordInfo;
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
public class UserLookRecordResponseData extends AbstractResponseData{
	/***
	 *  谁看过我
	 *  返回数据Info结果实体类
	 * */
	/**
	 * 被查看的人userId
	 * */
	protected String userId;
	
	/**
	 * 查看者的userId
	 * */
	protected Long lookType;
	protected Date createtime;
	protected Date updatetime;
	protected Byte isNewlook;
	/**
	 * userInfo表
	 * */
	protected UserInfoInfo userInfo;
	/**
	 * userLocate表
	 * */
	protected UserLocateInfo userLocateInfo;
	
	protected Long count;
	
	protected List<UserLookRecordInfo> userLookRecordInfoList;
	
	//========== getters and setters ==========
	
	public Byte getIsNewlook () {
		return isNewlook;
	}
	
	public void setIsNewlook (Byte isNewlook) {
		this.isNewlook = isNewlook;
	}
	
	public List<UserLookRecordInfo> getUserLookRecordInfoList () {
		return userLookRecordInfoList;
	}
	
	public void setUserLookRecordInfoList (List<UserLookRecordInfo> userLookRecordInfoList) {
		this.userLookRecordInfoList = userLookRecordInfoList;
	}
	
	public Long getCount () {
		return count;
	}
	
	public void setCount (Long count) {
		this.count = count;
	}
	
	public UserInfoInfo getUserInfo () {
		return userInfo;
	}
	public void setUserInfo (UserInfoInfo userInfo) {
		this.userInfo = userInfo;
	}
	
	public UserLocateInfo getUserLocateInfo () {
		return userLocateInfo;
	}
	
	public void setUserLocateInfo (UserLocateInfo userLocateInfo) {
		this.userLocateInfo = userLocateInfo;
	}
	public String getUserId () {
		return userId;
	}
	
	public void setUserId (String userId) {
		this.userId = userId;
	}
	
	public Long getLookType () {
		return lookType;
	}
	
	public void setLookType (Long lookType) {
		this.lookType = lookType;
	}
	
	public Date getCreatetime () {
		return createtime;
	}
	
	public void setCreatetime (Date createtime) {
		this.createtime = createtime;
	}
	
	public Date getUpdatetime () {
		return updatetime;
	}
	
	public void setUpdatetime (Date updatetime) {
		this.updatetime = updatetime;
	}
	
}
