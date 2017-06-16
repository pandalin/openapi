/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.response;

import com.jvv.facade.social.friend.info.UserInfoFriendTreeInfo;
import com.jvv.openapi.core.service.entity.AbstractResponseData;
import com.jvv.openapi.core.service.entity.ApiResponse;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/4/12
 * @time 15:15
 */
public class FindUserInfoResponseData extends AbstractResponseData{
	private UserInfoFriendTreeInfo userInfoFriendTreeInfo;
	
	public UserInfoFriendTreeInfo getUserInfoFriendTreeInfo () {
		return userInfoFriendTreeInfo;
	}
	
	public void setUserInfoFriendTreeInfo (UserInfoFriendTreeInfo userInfoFriendTreeInfo) {
		this.userInfoFriendTreeInfo = userInfoFriendTreeInfo;
	}
}
