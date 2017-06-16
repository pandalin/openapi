/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.api.third;
import com.jvv.customer.facade.user.info.UserInfoInfo;
import com.jvv.customer.facade.user.order.UserThirdBindingOrder;
import com.jvv.customer.facade.user.result.UserInfoResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.AbstractResponseData;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.intergration.customer.user.UserThirdBindingOrLoginClient;
import com.jvv.openapi.service.customer.user.requset.third.UserThirdBindingRequest;
import com.jvv.openapi.service.customer.user.response.UserLoginAndRegistResponseData;
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
 * @time 11:48
 */
@OpenApiService(name = "thirdBinding", desc = "三方绑定", responseType = ResponseTypeEnum.SYN)
public class UserThirdBindingService extends AbstractApiService<UserThirdBindingRequest,UserThirdResponse> {
	@Autowired
	UserThirdBindingOrLoginClient client;
	@Autowired
	private TokenUtils tokenUtils;
	
	@Override
	protected void doService (UserThirdBindingRequest request, UserThirdResponse response) {
		UserThirdBindingOrder order=new UserThirdBindingOrder ();
		BeanUtils.copyProperties (request,order);
		
		UserInfoResult result=client.binding (order);
		
		response.setStatus (result.getStatus ().getCode ());
		response.setMessage (result.getMessage ());
		response.setDetailMessage (result.getMessage ());
		response.setCode (result.getCode ());
		//在绑定之前如果已经注册的用户；直接返回
		//否则返回的数据要添加登陆信息
		//设置响应数据
		UserInfoInfo infoInfo=result.getInfo ();
		if(infoInfo!=null){
			AbstractResponseData responseData=convertFrom (infoInfo);
			//登录后响应数据体
			response.setDatas (responseData);
		}
		
		
		
	}
	
	private AbstractResponseData convertFrom(UserInfoInfo info) {
		UserLoginAndRegistResponseData data=new UserLoginAndRegistResponseData ();
		//BeanUtils.copyProperties (info,data.get);
		data.setUserInfoInfo (info);
		//向redis存入token，表示已经登录
		String token=tokenUtils.generateUserToken (info.getUserId ());
		data.setToken (token);
		return data;
	}
	
	
}
