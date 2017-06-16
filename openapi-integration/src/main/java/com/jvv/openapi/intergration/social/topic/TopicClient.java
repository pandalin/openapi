/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.intergration.social.topic;

import com.jvv.facade.social.circle.api.TopicApi;
import com.jvv.facade.social.circle.order.QueryPersonageTopicOrder;
import com.jvv.facade.social.circle.order.QueryTopicOrder;
import com.jvv.facade.social.circle.result.QueryTopicResult;
import com.jvv.openapi.intergration.Client;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/5/17
 * @time 16:29
 */
@Component
public class TopicClient extends Client {
	
	public QueryTopicResult queryTopic (QueryTopicOrder order) {
		TopicApi api = getDubboClient (TopicApi.class);
		return api.QueryTopic (order);
	}
	
	public QueryTopicResult queryPensonageTopic(QueryPersonageTopicOrder order){
		TopicApi api = getDubboClient (TopicApi.class);
		return api.queryPensonageTopic (order);
	}
}
