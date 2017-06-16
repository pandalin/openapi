/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.response;

import com.jvv.customer.facade.user.info.UserInfoLocateRemarkInfo;
import com.jvv.openapi.core.service.entity.AbstractResponseData;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/3/21
 * @time 18:52
 */
public class FindUserInfoLocateRemarkByTokenResponseData extends AbstractResponseData {
	
	private UserInfoLocateRemarkInfo UserInfoLocateRemarkInfo;
	
	public com.jvv.customer.facade.user.info.UserInfoLocateRemarkInfo getUserInfoLocateRemarkInfo () {
		return UserInfoLocateRemarkInfo;
	}
	
	public void setUserInfoLocateRemarkInfo (
			com.jvv.customer.facade.user.info.UserInfoLocateRemarkInfo userInfoLocateRemarkInfo) {
		UserInfoLocateRemarkInfo = userInfoLocateRemarkInfo;
	}
}
