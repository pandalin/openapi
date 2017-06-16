/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.response.topic;

import com.jvv.openapi.core.service.entity.AbstractResponseData;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author lxb
 * @date 2017/5/17
 * @time 16:43
 */
public class TopicSortParamResponseData extends AbstractResponseData {
	List<TopicSortParamResponse> list;
	
	public List<TopicSortParamResponse> getList () {
		return list;
	}
	
	public void setList (List<TopicSortParamResponse> list) {
		this.list = list;
	}
}
