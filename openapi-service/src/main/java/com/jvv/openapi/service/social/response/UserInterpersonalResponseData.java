/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.response;

import com.jvv.facade.social.friend.info.UserInterpersonalInfo;
import com.jvv.openapi.core.service.entity.AbstractResponseData;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author lxb
 * @date 2017/4/11
 * @time 9:52
 */
public class UserInterpersonalResponseData extends AbstractResponseData {
	/**
	 * 用户邀请人
	 * */
	private UserInterpersonalInfo userInviter;
	/**
	 * 用户窝粉集合
	 * */
	private List<UserInterpersonalInfo> list;
	
	public UserInterpersonalInfo getUserInviter () {
		return userInviter;
	}
	
	public void setUserInviter (UserInterpersonalInfo userInviter) {
		this.userInviter = userInviter;
	}
	
	public List<UserInterpersonalInfo> getList () {
		return list;
	}
	
	public void setList (List<UserInterpersonalInfo> list) {
		this.list = list;
	}
}
