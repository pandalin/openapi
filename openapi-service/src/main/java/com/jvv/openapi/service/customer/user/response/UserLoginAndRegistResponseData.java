/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.response;

import com.jvv.customer.facade.user.info.UserInfoInfo;
import com.jvv.openapi.core.service.entity.AbstractResponseData;
import com.jvv.openapi.core.service.entity.ApiResponse;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/3/17
 * @time 15:26
 */
public class UserLoginAndRegistResponseData extends AbstractResponseData{
	
	private UserInfoInfo userInfoInfo;
	private String token;
	
	public UserInfoInfo getUserInfoInfo () {
		return userInfoInfo;
	}
	
	public void setUserInfoInfo (UserInfoInfo userInfoInfo) {
		this.userInfoInfo = userInfoInfo;
	}
	
	public String getToken () {
		return token;
	}
	
	public void setToken (String token) {
		this.token = token;
	}
}
