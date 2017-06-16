package com.jvv.openapi.service.social.api.topic;

import com.jvv.facade.social.circle.order.QueryTopicManagerOrder;
import com.jvv.facade.social.circle.result.TopicManagerResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.intergration.social.topic.TopicManagerClient;
import com.jvv.openapi.service.social.request.topic.QueryTopicListRequest;
import com.jvv.openapi.service.social.request.topic.QueryTopicRequest;
import com.jvv.openapi.service.social.response.topic.QueryTopicListRspData;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/5/26
 * @time 9:59
 */
@OpenApiService(name = "queryTopicList", desc = "查询圈子列表", responseType = ResponseTypeEnum.SYN)
public class QueryTopicListService extends AbstractApiService<QueryTopicListRequest,ApiResponse> {
	
	@Resource
	TopicManagerClient client;
	
	@Override
	protected void doService (QueryTopicListRequest request, ApiResponse response) {
		TopicManagerResult result ;
		QueryTopicManagerOrder order = new QueryTopicManagerOrder ();
		BeanUtils.copyProperties (request,order);
		result = client.queryTopicList (order);
		 
		QueryTopicListRspData data = new QueryTopicListRspData ();
		data.setList (result.getInfos ());
		data.setCount (result.getCount ());
		
		response.injectResponse (result, response);
		response.setDatas (data);
	}
}
