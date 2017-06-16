/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.response;

import com.jvv.facade.social.friend.info.UserInfoFriendInfo;
import com.jvv.openapi.core.service.entity.AbstractResponseData;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/4/10
 * @time 16:32
 */
public class FindUserByPhoneResponseData extends AbstractResponseData {
	private UserInfoFriendInfo userInfoFriendInfo;
	
	public UserInfoFriendInfo getUserInfoFriendInfo () {
		return userInfoFriendInfo;
	}
	
	public void setUserInfoFriendInfo (UserInfoFriendInfo userInfoFriendInfo) {
		this.userInfoFriendInfo = userInfoFriendInfo;
	}
}
