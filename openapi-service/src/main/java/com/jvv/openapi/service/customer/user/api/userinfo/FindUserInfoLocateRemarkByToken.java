/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.api.userinfo;

import com.jvv.customer.facade.user.result.UserInfoLocateRemarkResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.intergration.customer.user.UserInfoClient;
import com.jvv.openapi.service.customer.user.requset.userinfo.UserInfoAndRemarkRequest;
import com.jvv.openapi.service.customer.user.response.FindUserInfoLocateRemarkByTokenResponseData;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/3/21
 * @time 18:40
 */
@OpenApiService(name = "findUserInfoLocateRemarkByTokenService", desc = "根据token获取用户详细资料",
                responseType = ResponseTypeEnum.SYN)
public class FindUserInfoLocateRemarkByToken extends AbstractApiService<UserInfoAndRemarkRequest, ApiResponse> {
	
	@Resource
	UserInfoClient client;
	@Resource
	TokenUtils tokenUtils;
	
	@Override
	protected void doService (UserInfoAndRemarkRequest request, ApiResponse response) {
		String userId = tokenUtils.getUserIdByToken (request.getToken ());
		UserInfoLocateRemarkResult result;
		//取得用户详细资料
		result = client.findUserInfoLocateRemarkByUserId (userId);
		
		response.setStatus (result.getStatus().getCode ());
		response.setMessage (result.getMessage ());
		response.setDetailMessage (result.getMessage ());
		
		FindUserInfoLocateRemarkByTokenResponseData data = new FindUserInfoLocateRemarkByTokenResponseData ();
		data.setUserInfoLocateRemarkInfo (result.getInfo ());
		response.setDatas (data);
	}
}
