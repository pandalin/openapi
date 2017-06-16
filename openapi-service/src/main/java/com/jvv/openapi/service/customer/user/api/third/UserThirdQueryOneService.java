/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.api.third;

import com.jvv.customer.facade.user.info.UserThirdBindingInfo;
import com.jvv.customer.facade.user.order.UserThirdBindingOrder;
import com.jvv.customer.facade.user.result.UserThirdBindingResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.AbstractResponseData;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.intergration.customer.user.UserThirdBindingOrLoginClient;
import com.jvv.openapi.service.customer.user.requset.third.UserThirdQueryOneRequest;
import com.jvv.openapi.service.customer.user.response.third.UserThirdResponse;
import com.jvv.openapi.service.customer.user.response.third.UserThirdResponseData;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author lxb
 * @date 2017/3/15
 * @time 10:38
 */
@OpenApiService(name = "thirdQueryOne", desc = "查询某个三方账户的绑定情况", responseType = ResponseTypeEnum.SYN)
public class UserThirdQueryOneService extends AbstractApiService<UserThirdQueryOneRequest, UserThirdResponse> {
	@Autowired
	private UserThirdBindingOrLoginClient client;
	
	@Override
	protected void doService (UserThirdQueryOneRequest request, UserThirdResponse response) {
		UserThirdBindingOrder order=new UserThirdBindingOrder ();
		BeanUtils.copyProperties (request,order);
		
		UserThirdBindingResult result=client.queryOne (order);
		
		response.setStatus(result.getStatus().getCode());
		response.setMessage (result.getMessage ());
		response.setDetailMessage(result.getMessage());
		response.setCode (result.getCode ());
		List<UserThirdBindingInfo> userThirdBindingInfos=result.getInfos ();
		
		if(userThirdBindingInfos!=null && userThirdBindingInfos.size ()>0){
			AbstractResponseData responseData = convertFrom(userThirdBindingInfos);
			response.setDatas(responseData);
		}
		
	}
	
	private AbstractResponseData convertFrom(List<UserThirdBindingInfo> userThirdBindingInfos) {
		UserThirdResponseData responseData = new UserThirdResponseData();
		//只能绑定一个类型的三方号，查询某个类型的某个号最多一个
		BeanUtils.copyProperties(userThirdBindingInfos.get (0), responseData, "status");
		return responseData;
	}
}
