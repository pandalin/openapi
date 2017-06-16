package com.jvv.openapi.service.social.api.topic;

import com.jvv.common.services.CommonResultCode;
import com.jvv.common.services.result.SimpleResult;
import com.jvv.facade.social.circle.order.TopicOrder;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.intergration.social.topic.TopicApiClient;
import com.jvv.openapi.service.social.request.topic.AddTopicRequest;
import com.jvv.openapi.service.social.request.topic.RemoveTopicRequest;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/5/17
 * @time 11:50
 */
@OpenApiService(name = "removeTopicService", desc = "删除圈子" , responseType = ResponseTypeEnum.SYN)
public class RemoveTopicService extends AbstractApiService<RemoveTopicRequest,ApiResponse> {
	@Resource
	TopicApiClient client;
	@Resource
	TokenUtils tokenUtils;
	
	@Override
	protected void doService (RemoveTopicRequest request, ApiResponse response) {
		tokenUtils.getUserIdByToken (request.getToken ());
		TopicOrder order = new TopicOrder ();
		order.setTopicId (request.getTopicId ());
		
		SimpleResult result = client.removeTopic (order);
		
		response.setStatus (result.getStatus ().getCode ());
		response.setMessage (result.getMessage ());
		response.setDetailMessage (result.getDescription ());
		response.setCode (result.getCode ());
		
	}
}
