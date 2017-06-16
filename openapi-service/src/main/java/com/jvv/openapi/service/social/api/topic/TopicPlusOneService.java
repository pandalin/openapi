package com.jvv.openapi.service.social.api.topic;

import com.jvv.common.services.result.SimpleResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.base.ApiService;
import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.intergration.social.topic.TopicManagerClient;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/5/23
 * @time 15:13
 */
@OpenApiService(name = "topicOrderAddOne", desc = "所有圈子排序字段+1" , responseType = ResponseTypeEnum.SYN)
public class TopicPlusOneService extends AbstractApiService<ApiRequest,ApiResponse> {
	
	@Resource
	TopicManagerClient client;
			
	@Override
	protected void doService (ApiRequest request, ApiResponse response) {
		SimpleResult result = client.modifyTopicPlusOne ();
		response.injectResponse (result, response);
	}
}
