/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.api;

import com.jvv.common.services.result.SimpleResult;
import com.jvv.facade.social.friend.order.UserInfoFriendOrder;
import com.jvv.facade.social.friend.result.UserInfoFriendResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.intergration.social.friend.UserFriendClient;
import com.jvv.openapi.service.social.request.UserFriendRequest;
import com.jvv.openapi.service.social.request.UserInfoFriendRequest;
import com.jvv.openapi.service.social.response.FriendTypeResponseData;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/4/10
 * @time 19:04
 */
@OpenApiService(name = "addUserFriend", desc = "用户添加关注" , responseType = ResponseTypeEnum.SYN)
public class AddUserFriendApiService extends AbstractApiService<UserInfoFriendRequest,ApiResponse> {
	@Resource
	UserFriendClient client;
	@Resource
	TokenUtils tokenUtils;
	
	@Override
	protected void doService (UserInfoFriendRequest request, ApiResponse response) {
		String userId = tokenUtils.getUserIdByToken (request.getToken ());
		UserInfoFriendOrder order = new UserInfoFriendOrder ();
		BeanUtils.copyProperties (request, order);
		order.setUserId (userId);
		UserInfoFriendResult result = client.addUserFriend (order);
		
		FriendTypeResponseData data = new FriendTypeResponseData ();
		data.setUserInfoFriendInfo (result.getInfo ());
		response.setDatas (data);
		
		
		response.setStatus (result.getStatus ().getCode ());
		response.setMessage (result.getMessage ());
		response.setDetailMessage (result.getDescription ());
		response.setCode (result.getCode ());
	}
}
