/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.response.topic;

import com.jvv.facade.social.circle.info.TopicWhiteInfo;
import com.jvv.openapi.core.service.entity.AbstractResponseData;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/5/27
 * @time 13:47
 */
public class QueryAllWhiteListResponseData extends AbstractResponseData {
	
	private List<TopicWhiteInfo> list;
	
	public List<TopicWhiteInfo> getList () {
		return list;
	}
	
	public void setList (List<TopicWhiteInfo> list) {
		this.list = list;
	}
}
