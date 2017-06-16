/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.api.topic;

import com.jvv.facade.social.circle.result.TopicUnreadCountResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.intergration.social.topic.TopicPraiseClient;
import com.jvv.openapi.service.social.request.topic.TopicSortParamRequest;
import com.jvv.openapi.service.social.request.topic.UserPraiseInfoRequest;
import com.jvv.openapi.service.social.response.topic.UserPraiseCountResponseData;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author lxb
 * @date 2017/5/17
 * @time 11:56
 */
@OpenApiService(name = "getUnReadPraiseCount", desc = "获取与我相关未读总数" , responseType = ResponseTypeEnum.SYN)
public class UserUnReadPraiseCountService extends AbstractApiService<TopicSortParamRequest,ApiResponse> {
	
	@Autowired
	TopicPraiseClient topicPraiseClient;
	@Autowired
	TokenUtils tokenUtils;
	
	@Override
	protected void doService (TopicSortParamRequest request, ApiResponse response) {
		String userId=tokenUtils.getUserIdByToken (request.getToken ());
		
		TopicUnreadCountResult result=topicPraiseClient.getUnreadPraiseCount (userId);
		
		UserPraiseCountResponseData data=new UserPraiseCountResponseData ();
		if(result.getInfo ()!=null){
			BeanUtils.copyProperties (result.getInfo (),data);
			response.setDatas (data);
		}
		response.setStatus (result.getStatus ().code ());
		response.setCode (result.getCode ());
		response.setMessage (result.getMessage ());
		response.setDetailMessage (result.getDescription ());
	}
}
