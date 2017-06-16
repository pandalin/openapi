/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.api.topic;

import com.jvv.facade.social.circle.result.TopicPraiseListResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.intergration.social.topic.TopicPraiseClient;
import com.jvv.openapi.service.social.request.topic.UserPraiseInfoRequest;
import com.jvv.openapi.service.social.response.topic.UserPraiseListResponseData;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author lxb
 * @date 2017/5/17
 * @time 11:53
 */
@OpenApiService(name = "getPraiseList", desc = "获取点赞列表" , responseType = ResponseTypeEnum.SYN)
public class UserPraiseListService extends AbstractApiService<UserPraiseInfoRequest,ApiResponse> {
	
	@Autowired
	TopicPraiseClient topicPraiseClient;
	@Autowired
	TokenUtils tokenUtils;
	
	@Override
	protected void doService (UserPraiseInfoRequest request, ApiResponse response) {
		String userId=tokenUtils.getUserIdByToken (request.getToken ());
		
		TopicPraiseListResult result=topicPraiseClient.getUserPraiseList (userId,request.getPageNo (),request.getPageSize ());
		UserPraiseListResponseData data=new UserPraiseListResponseData ();
		data.setList (result.getList ());
		response.setDatas (data);
		response.setStatus (result.getStatus ().code ());
		response.setCode (result.getCode ());
		response.setMessage (result.getMessage ());
		response.setDetailMessage (result.getDescription ());
	}
}
