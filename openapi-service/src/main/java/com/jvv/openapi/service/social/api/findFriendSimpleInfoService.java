/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.api;

import com.jvv.facade.social.friend.info.UserInfoFriendTreeInfo;
import com.jvv.facade.social.friend.order.UserFriendSimpleOrder;
import com.jvv.facade.social.friend.result.UserInfoFriendTreeResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.intergration.social.friend.UserFriendClient;
import com.jvv.openapi.service.social.request.UserInfoFriendRequest;
import com.jvv.openapi.service.social.response.FindUserInfoResponseData;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author lxb
 * @date 2017/6/2
 * @time 10:55
 */
@OpenApiService(name = "findFriendSimpleInfo", desc="获取好友简单信息", responseType = ResponseTypeEnum.SYN)
public class findFriendSimpleInfoService extends AbstractApiService<UserInfoFriendRequest,ApiResponse> {
	@Autowired
	private UserFriendClient userFriendClient;
	@Autowired
	private TokenUtils tokenUtils;
	
	
	@Override
	protected void doService (UserInfoFriendRequest request, ApiResponse response) {
		String userId=tokenUtils.getUserIdByToken (request.getToken ());
		UserFriendSimpleOrder order=new UserFriendSimpleOrder ();
		order.setUserId (userId);
		order.setFriendId (request.getFriendId ());
		
		UserInfoFriendTreeResult result=userFriendClient.findFriendSimpleInfo (order);
		if(result.getInfo ()!=null){
			FindUserInfoResponseData data = new FindUserInfoResponseData ();
			UserInfoFriendTreeInfo info = result.getInfo ();
			
			data.setUserInfoFriendTreeInfo (info);
			response.setDatas (data);
		}
		response.setStatus (result.getStatus ().getCode ());
		response.setMessage (result.getMessage ());
		response.setDetailMessage (result.getDescription ());
		response.setCode (result.getCode ());
		
	}
}
