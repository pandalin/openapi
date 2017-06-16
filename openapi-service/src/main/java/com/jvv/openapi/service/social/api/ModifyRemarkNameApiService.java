/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.api;

import com.jvv.common.services.result.ResultCodeable;
import com.jvv.common.services.result.SimpleResult;
import com.jvv.facade.social.friend.order.UserInfoFriendOrder;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.facade.constants.enums.Status;
import com.jvv.openapi.intergration.social.friend.UserFriendClient;
import com.jvv.openapi.service.social.request.UserInfoFriendRequest;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/4/13
 * @time 10:03
 */
@OpenApiService(name = "modifyRemarkName", desc = "设置好友备注接口", responseType = ResponseTypeEnum.SYN)
public class ModifyRemarkNameApiService extends AbstractApiService<UserInfoFriendRequest, ApiResponse> {
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
			SimpleResult result = client.modifyRemarkName (order);
			
			response.setStatus (result.getStatus ().getCode ());
			response.setMessage (result.getMessage ());
			response.setDetailMessage (result.getDescription ());
			response.setCode (result.getCode ());
		}
}
