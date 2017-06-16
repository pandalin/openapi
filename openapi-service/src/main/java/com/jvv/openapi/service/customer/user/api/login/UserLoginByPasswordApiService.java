/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.api.login;

import com.jvv.customer.facade.user.info.UserInfoInfo;
import com.jvv.customer.facade.user.result.UserInfoResult;
import com.jvv.gateway.facade.synOldSystem.order.SynOldSystemOrder;
import com.jvv.gateway.facade.synOldSystem.result.SynOldSystemResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.intergration.customer.user.UserLoginAndRegistClient;
import com.jvv.openapi.intergration.synOldSystem.SynOldSystemClient;
import com.jvv.openapi.service.customer.user.requset.login.UserLoginAndRegistRequest;
import com.jvv.openapi.service.customer.user.response.UserLoginAndRegistResponseData;

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
 * @time 17:38
 */
@OpenApiService (name="loginByPassword",desc = "用户账号密码登陆",responseType = ResponseTypeEnum.SYN)
public class UserLoginByPasswordApiService extends AbstractApiService<UserLoginAndRegistRequest ,ApiResponse> {
	
	@Resource
	UserLoginAndRegistClient client;
	@Resource
	SynOldSystemClient synOldSystemClient;
	@Resource
	TokenUtils tokenUtils;
	
	
	@Override
	protected void doService (UserLoginAndRegistRequest request, ApiResponse response) {
		
		
		UserInfoResult result = client.loginByPassword (request.getUserPhone (),request.getPassword (),request.getSystem (),request.getDeviceId () );
		
		response.setStatus (result.getStatus ().getCode ());
		response.setMessage (result.getMessage ());
		response.setDetailMessage (result.getMessage ());
		
		UserLoginAndRegistResponseData userLoginAndRegistResponseData = new UserLoginAndRegistResponseData ();
		
		UserInfoInfo userInfoInfo = result.getInfo ();
		if(userInfoInfo != null){
			//生成token
			String token = tokenUtils.generateUserToken (userInfoInfo.getUserId ());
			
			//******************同步老系统***************************
			Map<String, String> map = new HashMap<> ();
			map.put ("user_id", userInfoInfo.getUserId ());
			map.put ("token", token);
			SynOldSystemOrder synOldSystemOrder = new SynOldSystemOrder ();
			synOldSystemOrder.setSynSerivceName ("/m/syn/login");
			synOldSystemOrder.setSynParam (map);
			SynOldSystemResult synOldSystemResult = synOldSystemClient.syn (synOldSystemOrder);
			//******************************************************
			
			userLoginAndRegistResponseData.setToken (token);
			userLoginAndRegistResponseData.setUserInfoInfo (userInfoInfo);
			
		}
		response.setDatas (userLoginAndRegistResponseData);
	}
}
