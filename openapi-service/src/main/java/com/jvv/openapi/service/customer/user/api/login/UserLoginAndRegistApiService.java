/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.api.login;

import com.alibaba.druid.util.StringUtils;
import com.jvv.customer.facade.user.info.UserInfoInfo;
import com.jvv.customer.facade.user.order.UserRegisterOrder;
import com.jvv.customer.facade.user.result.UserInfoResult;
import com.jvv.gateway.facade.synOldSystem.order.SynOldSystemOrder;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.intergration.customer.sendsms.SendSmsClient;
import com.jvv.openapi.intergration.customer.user.UserLoginAndRegistClient;
import com.jvv.openapi.intergration.synOldSystem.SynOldSystemClient;
import com.jvv.openapi.service.customer.user.requset.login.UserLoginAndRegistRequest;
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
@OpenApiService (name = "loginAndRegist" ,desc = "登陆/注册（验证码）统一进入接口" , responseType = ResponseTypeEnum.SYN)
public class UserLoginAndRegistApiService extends AbstractApiService<UserLoginAndRegistRequest , ApiResponse> {
	
	@Resource
	UserLoginAndRegistClient loginAndRegistClient;
	@Resource
	SynOldSystemClient synOldSystemClient;
	@Resource
	SendSmsClient sendSmsClient;
	@Resource
	TokenUtils tokenUtils;
	
	@Override
	protected void doService (UserLoginAndRegistRequest request, ApiResponse response) {
		UserInfoResult result = new UserInfoResult ();
		//验证码不能为空
		if(StringUtils.isEmpty (request.getMsgCode ())){
			result.failure ("验证码不能为空");
		}else{
			UserRegisterOrder order = new UserRegisterOrder ();
			BeanUtils.copyProperties (request, order);
			order.setSysType (request.getSystem ());
			order.setPushMsgid (request.getDeviceId ());
			result = loginAndRegistClient.loginOrRegister (order);
		}
		
		
		response.setStatus (result.getStatus ().getCode ());
		response.setMessage (result.getMessage ());
		response.setDetailMessage (result.getMessage ());
		response.setCode (result.getCode ());
				
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
			synOldSystemClient.syn (synOldSystemOrder);
			//******************************************************
			
			//返回token
			userLoginAndRegistResponseData.setUserInfoInfo (userInfoInfo);
			userLoginAndRegistResponseData.setToken (token);
		}
			response.setDatas (userLoginAndRegistResponseData);
		
	}
}
