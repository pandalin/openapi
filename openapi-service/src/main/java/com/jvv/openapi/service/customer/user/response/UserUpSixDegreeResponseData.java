/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.response;

import com.jvv.customer.facade.user.info.UserUpSixDegreeInfo;
import com.jvv.openapi.core.service.entity.AbstractResponseData;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author lxb
 * @date 2017/3/28
 * @time 15:15
 */

public class UserUpSixDegreeResponseData extends AbstractResponseData {
	/**
	 * 用户上六度用户信息
	 */
	private List<UserUpSixDegreeInfo> userUpSixDegreeInfoList;
	
	public List<UserUpSixDegreeInfo> getUserUpSixDegreeInfoList () {
		return userUpSixDegreeInfoList;
	}
	
	public void setUserUpSixDegreeInfoList (
			List<UserUpSixDegreeInfo> userUpSixDegreeInfoList) {
		this.userUpSixDegreeInfoList = userUpSixDegreeInfoList;
	}
}
