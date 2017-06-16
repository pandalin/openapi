/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.response.topic;

import com.jvv.facade.social.circle.info.TopicInfo;
import com.jvv.openapi.core.service.entity.AbstractResponseData;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author zhaoyk
 * @date 2017/5/19
 * @time 15:40
 */
public class TopicAddResponseData extends AbstractResponseData {
	private TopicInfo topicInfo;
	
	public TopicInfo getTopicInfo () {
		return topicInfo;
	}
	
	public void setTopicInfo (TopicInfo topicInfo) {
		this.topicInfo = topicInfo;
	}
}
