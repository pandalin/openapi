/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.intergration.social.topic;

import com.jvv.common.services.result.SimpleResult;
import com.jvv.facade.social.circle.api.TopicApi;
import com.jvv.facade.social.circle.order.TopicOrder;
import com.jvv.facade.social.circle.result.TopicResult;
import com.jvv.openapi.intergration.Client;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author huangw
 * @date
 * @time
 */
@Component
public class TopicApiClient extends Client {
	/**
	 * 发布圈子
	 * */
	public TopicResult addTopic(TopicOrder order){
		TopicApi api = getDubboClient (TopicApi.class);
		TopicResult result = api.addTopic (order);
		return result;
	}
	/**
	 * 删除圈子
	 * */
	public SimpleResult removeTopic(TopicOrder order){
		TopicApi api = getDubboClient (TopicApi.class);
		SimpleResult result = api.removeTopic (order);
		return result;
	}
}
