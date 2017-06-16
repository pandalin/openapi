/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.api;

import com.jvv.facade.social.friend.order.UserInterpersonalOrder;
import com.jvv.facade.social.friend.result.UserInterpersonalResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.facade.constants.enums.Status;
import com.jvv.openapi.intergration.social.Interpersonal.UserInterpersonalClient;
import com.jvv.openapi.service.social.request.UserInterpersonalRequest;
import com.jvv.openapi.service.social.response.UserInterpersonalResponseData;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author lxb
 * @date 2017/4/10
 * @time 17:34
 */
@OpenApiService(name = "queryUserInterpersonal", desc = "查询用户人脉", responseType = ResponseTypeEnum.SYN)
public class UserInterpersonalService extends AbstractApiService<UserInterpersonalRequest,ApiResponse> {
	@Resource
	UserInterpersonalClient client;
	@Resource
	TokenUtils tokenUtils;
	
	@Override
	protected void doService (UserInterpersonalRequest request, ApiResponse response) {
			String userId=tokenUtils.getUserIdByToken (request.getToken ());
			
			UserInterpersonalOrder order=new UserInterpersonalOrder ();
			order.setUserId (userId);
			order.setStart (request.getStart ());
			order.setPageSize (request.getPageSize ());
			
			UserInterpersonalResult result=client.queryUserInterpersonal (order);
			
			response.setStatus (result.getStatus ().getCode ());
			response.setCode (result.getCode ());
			response.setMessage (result.getMessage ());
			response.setDetailMessage (result.getDescription ());
			
			UserInterpersonalResponseData datas=new UserInterpersonalResponseData ();
			if(result!=null){
				datas.setUserInviter (result.getUserInviter ());
				datas.setList (result.getFansList ());
			}
			
			response.setDatas (datas);
	}
}
