/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.api;

import com.jvv.facade.social.friend.info.CheckMutualFriendInfo;
import com.jvv.facade.social.friend.info.CheckMutualFriendListInfo;
import com.jvv.facade.social.friend.info.UserFriendInfo;
import com.jvv.facade.social.friend.order.CheckMutualFriendOrder;
import com.jvv.facade.social.friend.result.CheckMutualFriendResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.intergration.social.friend.UserFriendClient;
import com.jvv.openapi.service.social.request.CheckMutualFriendRequest;
import com.jvv.openapi.service.social.response.CheckMutualFriendResponseData;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/4/7
 * @time 17:41
 */
@OpenApiService (name = "checkMutualFriend",desc="获取共同认识的好友",responseType = ResponseTypeEnum.SYN)
public class CheckMutualFriendApiService extends AbstractApiService<CheckMutualFriendRequest,ApiResponse>{
	@Autowired
	private UserFriendClient userFriendClient;
	@Autowired
	private TokenUtils tokenUtils;
	
	@Override
	protected void doService (CheckMutualFriendRequest request, ApiResponse response) {
		CheckMutualFriendOrder order = new CheckMutualFriendOrder ();
		BeanUtils.copyProperties (request,order);
		String userId = tokenUtils.getUserIdByToken (request.getToken ());
		order.setUserId (userId);
		
		CheckMutualFriendResult result = userFriendClient.checkMutualFriend (order);
		response.setCode (result.getCode ());
		response.setStatus (result.getStatus ().getCode ());
		response.setMessage (result.getMessage ());
		response.setDetailMessage (result.getDescription ());
		
		if(result.getInfo () != null){
			List<CheckMutualFriendInfo> userFriendInfoList = result.getInfo ().getUserFriendInfoList ();
			CheckMutualFriendResponseData datas = new CheckMutualFriendResponseData ();
			datas.setUserFriendInfoList (userFriendInfoList);
			response.setDatas (datas);
		}
		
	}
}
