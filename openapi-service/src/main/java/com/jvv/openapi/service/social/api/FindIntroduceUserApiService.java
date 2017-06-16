/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.api;

import com.jvv.facade.social.friend.info.UserInfoFriendInfo;
import com.jvv.facade.social.friend.info.UserInfoFriendTreeInfo;
import com.jvv.facade.social.friend.info.UserInfoInfo;
import com.jvv.facade.social.friend.order.UserInfoFriendOrder;
import com.jvv.facade.social.friend.result.UserInfoFriendResult;
import com.jvv.facade.social.friend.result.UserInfoFriendTreeResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.intergration.social.friend.UserFriendClient;
import com.jvv.openapi.service.customer.user.response.SimpleResultResponseData;
import com.jvv.openapi.service.social.request.FindIntroduceUserRequest;
import com.jvv.openapi.service.social.request.UserInfoFriendRequest;
import com.jvv.openapi.service.social.response.FindUserInfoResponseData;
import com.jvv.openapi.service.social.response.SimpleListResponseData;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * 〈随机推荐20个好友〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/4/12
 * @time 15:53
 */
@OpenApiService(name = "findIntroduceUser", desc = "随机推荐20个好友接口",
                responseType = ResponseTypeEnum.SYN)
public class FindIntroduceUserApiService extends AbstractApiService<FindIntroduceUserRequest,ApiResponse> {
	@Resource
	UserFriendClient client;
	@Resource
	TokenUtils tokenUtils;
	
	@Override
	protected void doService (FindIntroduceUserRequest request, ApiResponse response) {
		
		String userId = tokenUtils.getUserIdByToken (request.getToken ());
		UserInfoFriendOrder order = new UserInfoFriendOrder ();
		BeanUtils.copyProperties (request, order);
		order.setUserId (userId);
		UserInfoFriendResult result = client.findIntroduceUser (order);
		
		response.setStatus (result.getStatus ().getCode ());
		response.setMessage (result.getMessage ());
		response.setDetailMessage (result.getDescription ());
		response.setCode (result.getCode ());
		
		SimpleListResponseData data = new SimpleListResponseData ();
		List<UserInfoInfo> list = result.getInfo ().getUserInfoInfos ();
		data.setList (list);
		response.setDatas (data);
	}
}
