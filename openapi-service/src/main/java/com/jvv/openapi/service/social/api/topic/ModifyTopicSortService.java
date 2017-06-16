package com.jvv.openapi.service.social.api.topic;

import com.alibaba.druid.util.StringUtils;
import com.jvv.common.services.CommonResultCode;
import com.jvv.common.services.result.ResultCodeable;
import com.jvv.common.services.result.SimpleResult;
import com.jvv.facade.social.circle.order.TopicOrder;
import com.jvv.facade.social.circle.order.TopicSortOrder;
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
 * @date 2017/5/23
 * @time 16:49
 */
@OpenApiService(name = "modifyTopicSort", desc = "设置圈子分类", responseType = ResponseTypeEnum.SYN)
public class ModifyTopicSortService extends AbstractApiService<TopicManagerRequest,ApiResponse> {
	
	@Resource
	TopicManagerClient client;
			
	@Override
	protected void doService (TopicManagerRequest request, ApiResponse response) {
		SimpleResult result = new SimpleResult ();
		if(request.getTopicSorts () == null || "".equals (request.getTopicSorts ())){
			result.setToFail (CommonResultCode.NULL_ARGUMENT_EXCEPTION,"分类参数不能为空");
		}else{
			String[] str = request.getTopicSorts ().split (",");
			if(str.length > 2){
				result.setToFail (CommonResultCode.ILLEGAL_NUMBER_OF_ARGUMENT,"分类最多为两项");
			}else{
				
				TopicSortOrder order = new TopicSortOrder ();
				BeanUtils.copyProperties (request,order);
				result = client.modifyTopicSort (order);
			}
		}
		response.injectResponse (result, response);
	}
}
