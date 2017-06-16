/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.api;


import com.jvv.customer.facade.user.info.UserInfoInfo;
import com.jvv.customer.facade.user.order.UserInfoOrder;
import com.jvv.customer.facade.user.result.UserInfoResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.AbstractResponseData;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.intergration.customer.user.UserInfoClient;
import com.jvv.openapi.service.customer.user.requset.UserInfoRequestFindUserInfoByUserId;
import com.jvv.openapi.service.customer.user.response.UserInfoResponse;
import com.jvv.openapi.service.customer.user.response.UserInfoResponseData;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author zhaoyk
 * @date
 * @time
 */
@OpenApiService(name = "userInfoServiceFindUserInfoByUserId", desc = "查找用户详细资料例子", responseType = ResponseTypeEnum.SYN)
public class UserInfoServiceFindUserInfoByUserId extends AbstractApiService<UserInfoRequestFindUserInfoByUserId, UserInfoResponse> {
	
	@Resource
	private UserInfoClient userInfoClient;
	
	@Override
	protected void doService(UserInfoRequestFindUserInfoByUserId request, UserInfoResponse response) {
		
		UserInfoOrder order = new UserInfoOrder();
		order.setUserId (request.getUserId ());
		UserInfoResult result = userInfoClient.findUserInfoByUserId (order);
		
		response.setStatus(result.getStatus().getCode());
		response.setMessage(result.getMessage());
		response.setDetailMessage(result.getMessage());
		
		UserInfoInfo userInfo = result.getInfo();
		
		if (userInfo != null) {
			AbstractResponseData responseData = convertFrom(userInfo);
			response.setDatas(responseData);
		}
	}
	
	private AbstractResponseData convertFrom(UserInfoInfo userInfo) {
		UserInfoResponseData responseData = new UserInfoResponseData ();
		BeanUtils.copyProperties(userInfo, responseData);
		return responseData;
	}
	
}
