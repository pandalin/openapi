/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.api;

import com.jvv.common.services.result.SimpleResult;
import com.jvv.facade.social.friend.info.UserInfoFriendTreeInfo;
import com.jvv.facade.social.friend.order.UserInfoFriendOrder;
import com.jvv.facade.social.friend.result.UserInfoFriendTreeResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.intergration.social.friend.UserFriendClient;
import com.jvv.openapi.service.social.request.UserInfoFriendRequest;
import com.jvv.openapi.service.social.response.FindUserInfoResponseData;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/4/12
 * @time 15:10
 */
@OpenApiService(name = "findUserInfoByFriendId", desc = "查看用户资料",
                responseType = ResponseTypeEnum.SYN)
public class FindUserInfoByUserIdAndFriendId  extends AbstractApiService<UserInfoFriendRequest,ApiResponse> {
	
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
		UserInfoFriendTreeResult result = client.findUserInfoFriendByUserIdAndFriendId (order);
		
		response.setStatus (result.getStatus ().getCode ());
		response.setMessage (result.getMessage ());
		response.setDetailMessage (result.getDescription ());
		response.setCode (result.getCode ());
		
		FindUserInfoResponseData data = new FindUserInfoResponseData ();
		UserInfoFriendTreeInfo info = result.getInfo ();
		
		data.setUserInfoFriendTreeInfo (info);
		response.setDatas (data);
		
	}
}
