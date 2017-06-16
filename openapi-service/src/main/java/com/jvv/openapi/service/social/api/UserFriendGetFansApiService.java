/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.api;

import com.jvv.common.services.PageInfo;
import com.jvv.facade.constants.enums.UserFriendTypeEnum;
import com.jvv.facade.social.friend.order.UserFriendOrder;
import com.jvv.facade.social.friend.result.UserFriendResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.listener.event.ApiEvent;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.facade.constants.enums.Status;
import com.jvv.openapi.intergration.social.friend.UserFriendClient;
import com.jvv.openapi.service.social.request.UserFriendRequest;
import com.jvv.openapi.service.social.response.UserFriendResponseData;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/4/7
 * @time 11:53
 */
@OpenApiService (name = "getFansList",desc = "获取用户粉丝列表" , responseType = ResponseTypeEnum.SYN)
public class UserFriendGetFansApiService extends AbstractApiService<UserFriendRequest,ApiResponse> {
	
	@Resource
	UserFriendClient client;
	@Resource
	TokenUtils tokenUtils;
	
	
	@Override
	protected void doService (UserFriendRequest request, ApiResponse response) {
		
		if (request.getPageNo () == null || "".equals (request.getPageNo ())) {
			
			//返回结果注入相对应的response
			response.setStatus (Status.FAIL.getCode ());
			response.setMessage ("执行失败");
			response.setDetailMessage ("pageNo不能为空！");
			response.setCode ("999");
		} else if (request.getPageSize () == null || "".equals (request.getPageSize ())) {
			
			//返回结果注入相对应的response
			response.setStatus (Status.FAIL.getCode ());
			response.setMessage ("执行失败");
			response.setDetailMessage ("pageSize不能为空！");
			response.setCode ("999");
			
		} else {
			
			String userId = tokenUtils.getUserIdByToken (request.getToken ());
			UserFriendOrder order = new UserFriendOrder ();
			order.setUserId (userId);
			//查找粉丝类型数据
			order.setFriendType (UserFriendTypeEnum.FANS);
			order.setKeyWord (request.getKeyWord ());
			
			PageInfo pageInfo = new PageInfo ();//分页对象
			pageInfo.setPageNo (request.getPageNo ());
			pageInfo.setPageSize (request.getPageSize ());
			order.setPageInfo (pageInfo);
			UserFriendResult userFriendResult = client.getUserFriendList (order);
			
			//返回结果注入相对应的response
			response.setStatus (userFriendResult.getStatus ().getCode ());
			response.setMessage (userFriendResult.getMessage ());
			response.setDetailMessage (userFriendResult.getMessage ());
			response.setCode (userFriendResult.getCode ());
			
			UserFriendResponseData data = new UserFriendResponseData ();
			data.setList (userFriendResult.getUserFriendInfos ());
			response.setDatas (data);
		}
	}
}
