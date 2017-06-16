/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.api;

import com.jvv.facade.social.friend.order.UserInfoFriendOrder;
import com.jvv.facade.social.friend.result.UserInfoFriendResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.intergration.social.friend.UserFriendClient;
import com.jvv.openapi.service.social.request.FindNearByUserRequest;
import com.jvv.openapi.service.social.request.FindUserByPhoneRequest;
import com.jvv.openapi.service.social.response.FindUserByPhoneResponseData;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/4/10
 * @time 16:24
 */
@OpenApiService(name = "findUserByPhone", desc = "通过手机号查找用户接口" , responseType = ResponseTypeEnum.SYN)
public class FindUserByPhoneApiService extends AbstractApiService<FindUserByPhoneRequest,ApiResponse> {
	
	@Resource
	UserFriendClient client;
	
	@Resource
	TokenUtils tokenUtils;
	
	@Override
	protected void doService (FindUserByPhoneRequest request, ApiResponse response) {
		
		String userId = tokenUtils.getUserIdByToken (request.getToken ());
		UserInfoFriendOrder order = new UserInfoFriendOrder ();
		BeanUtils.copyProperties (request,order);
		order.setUserId (userId);
		
		UserInfoFriendResult userInfoFriendResult = client.findUserByPhone (order);
		
		//返回结果注入相对应的response
		response.setStatus (userInfoFriendResult.getStatus ().getCode ());
		response.setMessage (userInfoFriendResult.getMessage ());
		response.setDetailMessage (userInfoFriendResult.getDescription ());
		response.setCode (userInfoFriendResult.getCode ());
		
		FindUserByPhoneResponseData data = new FindUserByPhoneResponseData ();
		data.setUserInfoFriendInfo (userInfoFriendResult.getInfo ());
		response.setDatas (data);
	}
}
