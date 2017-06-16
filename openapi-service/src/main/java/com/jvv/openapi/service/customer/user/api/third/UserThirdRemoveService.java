/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.api.third;

import com.jvv.customer.facade.base.result.SimpleResult;
import com.jvv.customer.facade.user.order.UserThirdBindingOrder;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.intergration.customer.user.UserThirdBindingOrLoginClient;
import com.jvv.openapi.service.customer.user.requset.third.UserThirdRemoveRequest;
import com.jvv.openapi.service.customer.user.response.third.UserThirdResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author lxb
 * @date 2017/3/15
 * @time 11:45
 */
@OpenApiService(name = "thirdRemove", desc = "解除三方绑定", responseType = ResponseTypeEnum.SYN)
public class UserThirdRemoveService extends AbstractApiService<UserThirdRemoveRequest, UserThirdResponse>{
	@Autowired
	UserThirdBindingOrLoginClient client;
	
	@Override
	protected void doService (UserThirdRemoveRequest request, UserThirdResponse response) {
		UserThirdBindingOrder order=new UserThirdBindingOrder ();
		BeanUtils.copyProperties (request,order);
		
		SimpleResult result=client.remove (order);
		
		response.setStatus (result.getStatus ().getCode ());
		response.setMessage (result.getMessage ());
		response.setDetailMessage (result.getMessage ());
		response.setCode (result.getCode ());
	}
}
