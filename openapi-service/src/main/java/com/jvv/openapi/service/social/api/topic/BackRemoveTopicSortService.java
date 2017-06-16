/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.api.topic;

import com.jvv.common.services.result.SimpleResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.intergration.social.topic.TopicSortClient;
import com.jvv.openapi.service.social.request.topic.BackRemoveTopicSortRequest;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author lxb
 * @date 2017/5/18
 * @time 15:33
 */
@OpenApiService(name = "removeBackTopicSort", desc = "后台删除圈子分类" , responseType = ResponseTypeEnum.SYN)
public class BackRemoveTopicSortService extends AbstractApiService<BackRemoveTopicSortRequest,ApiResponse> {
	
	@Autowired
	private TopicSortClient topicSortClient;
	@Override
	protected void doService (BackRemoveTopicSortRequest request, ApiResponse response) {
		SimpleResult result=topicSortClient.removeSort (request.getSortCode ().longValue ());
		response.setStatus (result.getStatus ().getCode ());
		response.setMessage (result.getMessage ());
		response.setDetailMessage (result.getDescription ());
		response.setCode (result.getCode ());
	}
}
