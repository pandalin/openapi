/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.api.topic;

import com.jvv.common.services.result.SimpleResult;
import com.jvv.facade.social.circle.order.TopicSortParamOrder;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.intergration.social.topic.TopicSortClient;
import com.jvv.openapi.service.social.request.topic.BackUpdateTopicSortRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author lxb
 * @date 2017/5/18
 * @time 15:36
 */
@OpenApiService(name = "updateBackTopicSort", desc = "后台修改圈子分类信息" , responseType = ResponseTypeEnum.SYN)
public class BackUpdateTopicSortService extends AbstractApiService<BackUpdateTopicSortRequest,ApiResponse> {
	
	@Autowired
	private TopicSortClient topicSortClient;
	@Override
	protected void doService (BackUpdateTopicSortRequest request, ApiResponse response) {
		TopicSortParamOrder order=new TopicSortParamOrder ();
		BeanUtils.copyProperties (request,order);
		order.setSortCode (request.getSortCode ().longValue ());
//		System.out.println ("圈子更新："+request);
//		System.out.println ("圈子更新："+order);
		SimpleResult result=topicSortClient.updateSort (order);
		
		response.setStatus (result.getStatus ().getCode ());
		response.setMessage (result.getMessage ());
		response.setDetailMessage (result.getDescription ());
		response.setCode (result.getCode ());
	}
}
