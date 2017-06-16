/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.api.topic;

import com.jvv.common.lang.beans.Copier;
import com.jvv.facade.sixdegree.info.SearchSixDegreeInfo;
import com.jvv.facade.sixdegree.info.SearchSixDegreeList;
import com.jvv.facade.social.circle.info.QueryTopicInfo;
import com.jvv.facade.social.circle.info.QueryTopicListInfo;
import com.jvv.facade.social.circle.order.QueryTopicOrder;
import com.jvv.facade.social.circle.result.QueryTopicResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.intergration.social.topic.TopicClient;
import com.jvv.openapi.service.social.request.topic.QueryTopicRequest;
import com.jvv.openapi.service.social.response.SearchSixDegreeResponseData;
import com.jvv.openapi.service.social.response.topic.QueryTopicResponseData;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/5/17
 * @time 16:38
 */
@OpenApiService (name = "QueryTopic", desc = "查询圈子列表", responseType = ResponseTypeEnum.SYN)
public class QueryTopicApiService extends AbstractApiService<QueryTopicRequest,ApiResponse> {
	
	@Resource
	private TokenUtils tokenUtils;
	
	@Resource
	private TopicClient topicClient;
	
	@Override
	protected void doService (QueryTopicRequest request, ApiResponse response) {
		
		String userId = tokenUtils.getUserIdByToken (request.getToken ());
		QueryTopicOrder order = new QueryTopicOrder ();
		Copier.copy (request,order);
		
		if(request.getDate ()!=null){
			Date date = new Date (new Long (request.getDate ()));
			order.setDate (date);
		}
		
		order.setUserId (userId);
		
		QueryTopicResult result = topicClient.queryTopic (order);
		response.injectResponse (result,response);
		
		QueryTopicListInfo info = result.getInfo ();
		if(info!=null){
			QueryTopicResponseData data = new QueryTopicResponseData ();
			data.setList (info.getList ());
			data.setDate (info.getDate ());
			response.setDatas (data);
		}
		
	}
}
