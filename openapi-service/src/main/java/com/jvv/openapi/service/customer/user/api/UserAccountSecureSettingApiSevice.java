/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.api;

import com.jvv.customer.facade.user.info.UserAccountSecureSettingInfo;
import com.jvv.customer.facade.user.order.UserAccountSecureSettingOrder;
import com.jvv.customer.facade.user.result.UserAccountSecureSettingResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.intergration.customer.user.UserAccountSecureSettingClient;
import com.jvv.openapi.service.customer.user.requset.UserAccountSecureSettingRequest;
import com.jvv.openapi.service.customer.user.response.UserAccountSecureSettingResponse;
import com.jvv.openapi.service.customer.user.response.UserAccountSecureSettingResponseData;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author lxb
 * @date 2017/3/21
 * @time 18:21
 */
@OpenApiService(name = "queryAccounSecureSetting", desc = "查询账户安全设置", responseType = ResponseTypeEnum.SYN)
public class UserAccountSecureSettingApiSevice extends
		AbstractApiService<UserAccountSecureSettingRequest,UserAccountSecureSettingResponse> {
	
	@Autowired
	private UserAccountSecureSettingClient client;
	@Autowired
	private TokenUtils tokenUtils;
	
	@Override
	protected void doService (UserAccountSecureSettingRequest request, UserAccountSecureSettingResponse response) {
		UserAccountSecureSettingOrder order=new UserAccountSecureSettingOrder ();
		String userId = tokenUtils.getUserIdByToken (request.getToken ());
		order.setUserId (userId);
		UserAccountSecureSettingResult result=client.queruAccounSecureSetting (order);
		
		//System.out.println("----->"+result);
		
		//设置响应信息
		response.setStatus (result.getStatus ().getCode ());
		response.setMessage (result.getMessage ());
		response.setDetailMessage (result.getMessage ());
		response.setCode (result.getCode ());
		//组装响应数据  info   ==>   data
		
		UserAccountSecureSettingResponseData data=new UserAccountSecureSettingResponseData ();
		UserAccountSecureSettingInfo info=result.getInfo ();
		BeanUtils.copyProperties (result.getInfo (),data);
//		data.setAuthenticationState (info.getAuthenticationState ());
//		data.setUserPhone (info.getUserPhone ());
//		data.setLoginPass (info.getLoginPass ());
//		data.setDealPass (info.getDealPass ());
//		data.setUserThirdBindingInfoList (info.getUserThirdBindingInfoList ());
		
		
		response.setDatas (data);
	}
}
