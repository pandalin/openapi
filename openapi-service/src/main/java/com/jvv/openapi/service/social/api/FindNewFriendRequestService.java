/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.api;

import com.jvv.facade.social.friend.info.UserInfoFriendInfo;
import com.jvv.facade.social.friend.info.UserInfoInfo;
import com.jvv.facade.social.friend.order.UserInfoFriendOrder;
import com.jvv.facade.social.friend.result.UserInfoFriendResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.intergration.social.friend.UserFriendClient;
import com.jvv.openapi.service.social.request.FindIntroduceUserRequest;
import com.jvv.openapi.service.social.request.FindMsgFriendRequest;
import com.jvv.openapi.service.social.response.SimpleListResponseData;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * 〈新粉丝列表〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/4/12
 * @time 15:53
 */
@OpenApiService(name = "findMsgFriend", desc = "新粉丝列表接口",
                responseType = ResponseTypeEnum.SYN)
public class FindNewFriendRequestService extends AbstractApiService<FindMsgFriendRequest,ApiResponse> {
	@Resource
	UserFriendClient client;
	@Resource
	TokenUtils tokenUtils;
	
	@Override
	protected void doService (FindMsgFriendRequest request, ApiResponse response) {
		
		String userId = tokenUtils.getUserIdByToken (request.getToken ());
		UserInfoFriendResult result = client.findMsgFriend (userId);
		
		response.setStatus (result.getStatus ().getCode ());
		response.setMessage (result.getMessage ());
		response.setDetailMessage (result.getDescription ());
		response.setCode (result.getCode ());
		
		SimpleListResponseData data = new SimpleListResponseData ();
		List<UserInfoFriendInfo> list = result.getInfo ().getUserFriends ();
		data.setList (list);
		response.setDatas (data);
	}
}
