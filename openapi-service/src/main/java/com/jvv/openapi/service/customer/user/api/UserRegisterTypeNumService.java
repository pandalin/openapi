/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.api;

import com.jvv.customer.facade.base.result.SimpleResult;
import com.jvv.customer.facade.user.api.UserRegisterTypeNumApi;
import com.jvv.customer.facade.user.info.UserRegisterTypeNumInfo;
import com.jvv.customer.facade.user.order.UserRegisterTypeNumByDateOrder;
import com.jvv.customer.facade.user.order.UserThirdBindingOrder;
import com.jvv.customer.facade.user.result.UserRegisterTypeNumResult;
import com.jvv.customer.facade.user.result.UserThirdBindingResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.AbstractResponseData;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.intergration.customer.user.UserRegisterTypeNumClient;
import com.jvv.openapi.service.customer.user.requset.UserRegisterTypeNumRequest;
import com.jvv.openapi.service.customer.user.requset.third.UserThirdBindingRequest;
import com.jvv.openapi.service.customer.user.response.UserRegisterTypeNumResponse;
import com.jvv.openapi.service.customer.user.response.UserRegisterTypeNumResponseData;
import com.jvv.openapi.service.customer.user.response.third.UserThirdResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 注册渠道和类型
 *
 * @author lxb
 * @date 2017/3/17
 * @time 17:12
 */
@OpenApiService(name = "registerTypeAndNum", desc = "查询注册类型对应数量", responseType = ResponseTypeEnum.SYN)
public class UserRegisterTypeNumService extends AbstractApiService<UserRegisterTypeNumRequest,UserRegisterTypeNumResponse> {
	@Autowired
	private UserRegisterTypeNumClient client;
	@Override
	protected void doService (UserRegisterTypeNumRequest request, UserRegisterTypeNumResponse response) {
		UserRegisterTypeNumByDateOrder order=new UserRegisterTypeNumByDateOrder ();
		BeanUtils.copyProperties (request, order);
		
		UserRegisterTypeNumResult result=client.queryRegisterTypeNum (order);
		
		response.setStatus (result.getStatus ().getCode ());
		response.setMessage (result.getMessage ());
		response.setDetailMessage (result.getMessage ());
		response.setCode (result.getCode ());
		UserRegisterTypeNumInfo info=result.getInfo ();
		if (info!=null){
			AbstractResponseData datas=convertFrom (info);
			response.setDatas (datas);
		}
	}
	
	public AbstractResponseData convertFrom(UserRegisterTypeNumInfo info){
		UserRegisterTypeNumResponseData datas=new UserRegisterTypeNumResponseData ();
		BeanUtils.copyProperties (info,datas);
		return datas;
	}
}
