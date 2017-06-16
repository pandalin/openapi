/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.api;


import com.jvv.customer.facade.base.result.SimpleResult;
import com.jvv.customer.facade.user.order.UserIdentityOrder;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.intergration.customer.user.UserInfoClient;
import com.jvv.openapi.service.customer.user.requset.UserInfoRequestModifyIdentityRequest;
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
@OpenApiService(name = "userInfoServiceModifyUserIdentity", desc = "修改用户身份", responseType = ResponseTypeEnum.SYN)
public class UserInfoServiceModifyIdentity extends AbstractApiService<UserInfoRequestModifyIdentityRequest, ApiResponse> {
	
	@Resource
	private UserInfoClient userInfoClient;
	@Resource
	private TokenUtils tokenUtils;
	
	@Override
	protected void doService(UserInfoRequestModifyIdentityRequest request, ApiResponse response) {
		
		UserIdentityOrder order = new UserIdentityOrder();
        BeanUtils.copyProperties (request , order);
        
		order.setUserId (tokenUtils.getUserIdByToken (request.getToken ()));
		
		SimpleResult result = userInfoClient.modifyUserIdentity (order);
		
		response.setStatus(result.getStatus().getCode());
		response.setMessage(result.getMessage());
		response.setDetailMessage(result.getMessage());
		
	}
	
}
