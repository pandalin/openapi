/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.api.topic;

import com.jvv.common.services.result.SimpleResult;
import com.jvv.facade.social.circle.order.TopicDoPraiseOrder;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.intergration.social.topic.TopicPraiseClient;
import com.jvv.openapi.service.social.request.topic.UserPraiseRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈〉
 *
 * @author lxb
 * @date 2017/5/17
 * @time 11:12
 */
@OpenApiService(name = "userPraise", desc = "用户点赞" , responseType = ResponseTypeEnum.SYN)
public class UserPraiseApiService extends AbstractApiService<UserPraiseRequest,ApiResponse> {
	@Autowired
	TopicPraiseClient topicPraiseClient;
	@Autowired
	TokenUtils tokenUtils;
	
	@Override
	protected void doService (UserPraiseRequest request, ApiResponse response) {
		String userId=tokenUtils.getUserIdByToken (request.getToken ());
		TopicDoPraiseOrder order=new TopicDoPraiseOrder ();
		order.setTopicId (request.getTopicId ());
		order.setPraiseType (request.getPraiseType ().longValue ());
		//BeanUtils.copyProperties (request, order);
		order.setUserId (userId);
		System.out.println (order);
		SimpleResult result=topicPraiseClient.praise (order);
		
		response.setStatus (result.getStatus ().code ());
		response.setCode (result.getCode ());
		response.setMessage (result.getMessage ());
		response.setDetailMessage (result.getDescription ());
		
	}
}
