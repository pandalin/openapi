/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.api.login;

import com.jvv.customer.facade.base.result.SimpleResult;
import com.jvv.customer.facade.user.info.UserInfoInfo;
import com.jvv.customer.facade.user.order.UserRegisterOrder;
import com.jvv.gateway.facade.synOldSystem.order.SynOldSystemOrder;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.intergration.customer.sendsms.SendSmsClient;
import com.jvv.openapi.intergration.customer.user.UserLoginAndRegistClient;
import com.jvv.openapi.intergration.synOldSystem.SynOldSystemClient;
import com.jvv.openapi.service.customer.user.requset.login.OldRegistRequest;
import com.jvv.openapi.service.customer.user.response.UserLoginAndRegistResponseData;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/3/17
 * @time 15:41
 */
@OpenApiService (name = "oldRegist" ,desc = "登陆/注册（验证码）统一进入接口" , responseType = ResponseTypeEnum.SYN)
public class UserOldRegistApiService extends AbstractApiService<OldRegistRequest, ApiResponse> {
	
	@Resource
	UserLoginAndRegistClient loginAndRegistClient;
	@Resource
	SynOldSystemClient synOldSystemClient;
	@Resource
	SendSmsClient sendSmsClient;
	@Resource
	TokenUtils tokenUtils;
	
	@Override
	protected void doService (OldRegistRequest request, ApiResponse response) {
		SimpleResult result;
		
		UserRegisterOrder order = new UserRegisterOrder ();
		BeanUtils.copyProperties (request, order);
		order.setIsOld (1);
		order.setRegisterType (2);
		result = loginAndRegistClient.registeredUser (order);
		
		
		response.setStatus (result.getStatus ().getCode ());
		response.setMessage (result.getMessage ());
		response.setDetailMessage (result.getMessage ());
		response.setCode (result.getCode ());
		
	}
}
