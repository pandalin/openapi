package com.jvv.openapi.service.social.api.topic;

import com.jvv.common.services.CommonResultCode;
import com.jvv.common.services.result.SimpleResult;
import com.jvv.facade.social.circle.order.TopicOrder;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.intergration.social.topic.TopicManagerClient;
import com.jvv.openapi.service.social.request.topic.TopicManagerRequest;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/5/24
 * @time 16:19
 */
@OpenApiService(name = "modifyTopicHot", desc = "设置圈子热门状态", responseType = ResponseTypeEnum.SYN)
public class ModifyTopicHotService extends AbstractApiService<TopicManagerRequest,ApiResponse> {
	@Resource
	TopicManagerClient client;
	
	@Override
	protected void doService (TopicManagerRequest request, ApiResponse response) {
		SimpleResult result = new SimpleResult ();
		if(request.getOperater () == null || request.getOperater ().equals ("")){
			result.setToFail (CommonResultCode.NULL_ARGUMENT_EXCEPTION, "操作人参数不可为空");
		}else if(request.getIsHot () == null){
			result.setToFail (CommonResultCode.NULL_ARGUMENT_EXCEPTION,"是否热门参数不可为空");
		}else {
			TopicOrder order = new TopicOrder ();
			BeanUtils.copyProperties (request, order);
			result = client.modifyTopicHot (order);
		}
		
		response.injectResponse (result,response);
}
}