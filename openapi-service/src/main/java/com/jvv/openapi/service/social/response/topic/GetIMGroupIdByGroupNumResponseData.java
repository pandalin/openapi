/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.response.topic;

import com.jvv.openapi.core.service.entity.AbstractResponseData;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/5/23
 * @time 11:09
 */
public class GetIMGroupIdByGroupNumResponseData extends AbstractResponseData{
	
	private String groupId;
	
	public String getGroupId () {
		return groupId;
	}
	
	public void setGroupId (String groupId) {
		this.groupId = groupId;
	}
}
