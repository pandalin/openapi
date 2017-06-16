/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.response;

import com.jvv.facade.social.friend.info.CheckMutualFriendInfo;
import com.jvv.facade.social.friend.info.CheckMutualFriendListInfo;
import com.jvv.facade.social.friend.info.UserFriendInfo;
import com.jvv.openapi.core.service.entity.AbstractResponseData;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/4/7
 * @time 17:36
 */
public class CheckMutualFriendResponseData extends AbstractResponseData{
	
	private List<CheckMutualFriendInfo> userFriendInfoList;
	
	public List<CheckMutualFriendInfo> getUserFriendInfoList () {
		return userFriendInfoList;
	}
	
	public void setUserFriendInfoList (List<CheckMutualFriendInfo> userFriendInfoList) {
		this.userFriendInfoList = userFriendInfoList;
	}
}
