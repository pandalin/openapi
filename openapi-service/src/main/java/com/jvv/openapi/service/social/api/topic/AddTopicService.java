package com.jvv.openapi.service.social.api.topic;

import com.jvv.common.services.CommonResultCode;
import com.jvv.common.services.result.ResultCodeable;
import com.jvv.common.services.result.SimpleResult;
import com.jvv.facade.social.circle.order.TopicOrder;
import com.jvv.facade.social.circle.result.TopicResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.intergration.social.topic.TopicApiClient;
import com.jvv.openapi.service.social.request.topic.AddTopicRequest;
import com.jvv.openapi.service.social.response.topic.TopicAddResponseData;
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
@OpenApiService(name = "submitTopicService", desc = "发布圈子" , responseType = ResponseTypeEnum.SYN)
public class AddTopicService extends AbstractApiService<AddTopicRequest,ApiResponse> {
	@Resource
	TopicApiClient client;
	@Resource
	TokenUtils tokenUtils;
	
	@Override
	protected void doService (AddTopicRequest request, ApiResponse response) {
		String userId = tokenUtils.getUserIdByToken (request.getToken ());
		String content = request.getContent ();
		List list = request.getTopicFiles ();
		TopicResult result = new TopicResult ();
		
		if((content == null ||content.equals (""))&&(list == null || list.size () < 1)){
			result.setToFail (CommonResultCode.NULL_ARGUMENT_EXCEPTION, "文字与图片不能同时为空");
		}else {
			
			TopicOrder order = new TopicOrder ();
			BeanUtils.copyProperties (request, order);
			order.setUserId (userId);
			if(request.getUserlocation () != null && !"".equals (request.getUserlocation ())){
				order.setLocation (request.getUserlocation ());
			}
			result = client.addTopic (order);
		}
		
		TopicAddResponseData data = new TopicAddResponseData();
			
		data.setTopicInfo (result.getInfo ());
		response.setStatus (result.getStatus ().getCode ());
		response.setMessage (result.getMessage ());
		response.setDetailMessage (result.getDescription ());
		response.setCode (result.getCode ());
		response.setDatas (data);
		
	}
}
