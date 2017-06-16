/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.api.topic;

import com.jvv.common.lang.beans.Copier;
import com.jvv.facade.social.circle.info.QueryTopicListInfo;
import com.jvv.facade.social.circle.order.QueryPersonageTopicOrder;
import com.jvv.facade.social.circle.result.QueryTopicResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.intergration.social.topic.TopicClient;
import com.jvv.openapi.service.social.request.topic.QueryPensonageTopicRequest;
import com.jvv.openapi.service.social.response.topic.QueryTopicResponseData;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/5/18
 * @time 14:28
 */
@OpenApiService(name = "QueryPensonageTopic", desc = "查询个人动态列表", responseType = ResponseTypeEnum.SYN)
public class QueryPensonageTopicApiService extends AbstractApiService<QueryPensonageTopicRequest,ApiResponse> {
	
	@Resource
	private TokenUtils tokenUtils;
	
	@Resource
	private TopicClient topicClient;
	
	@Override
	protected void doService (QueryPensonageTopicRequest request, ApiResponse response) {
		String userId = tokenUtils.getUserIdByToken (request.getToken ());
		QueryPersonageTopicOrder order = new QueryPersonageTopicOrder ();
		Copier.copy (request, order);
		
		if(request.getDate ()!=null){
			Date date = new Date (new Long (request.getDate ()));
			order.setDate (date);
		}
		
		order.setUserId (userId);
		
		QueryTopicResult result = topicClient.queryPensonageTopic (order);
		response.injectResponse (result,response);
		
		QueryTopicListInfo info = result.getInfo ();
		if(info!=null){
			QueryTopicResponseData data = new QueryTopicResponseData ();
			data.setDate (info.getDate ());
			data.setList (info.getList ());
			response.setDatas (data);
		}
	}
		
	
}
