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
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.intergration.customer.user.UserThirdBindingOrLoginClient;
import com.jvv.openapi.service.customer.user.requset.third.UserThirdFindByUserIdRequest;
import com.jvv.openapi.service.customer.user.response.third.UserThirdResponse;
import com.jvv.openapi.service.customer.user.response.third.UserThirdResponseData;
import com.jvv.openapi.service.customer.user.response.third.UserThirdResponseListData;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author lxb
 * @date 2017/3/15
 * @time 11:57
 */
@OpenApiService(name = "thirdFindByUserId", desc = "通过用户id查询绑定信息", responseType = ResponseTypeEnum.SYN)
public class UserThirdFindByUserIdService extends AbstractApiService<UserThirdFindByUserIdRequest,UserThirdResponse> {
	@Autowired
	UserThirdBindingOrLoginClient client;
	
	@Resource
	private TokenUtils tokenUtils;
	
	@Override
	protected void doService (UserThirdFindByUserIdRequest request, UserThirdResponse response) {
		
		String userId = tokenUtils.getUserIdByToken (request.getToken ());
		
		
		UserThirdBindingOrder order=new UserThirdBindingOrder ();
		//BeanUtils.copyProperties (request, order);
		order.setUserId (userId);
		order.setUserPhone (request.getUserPhone ());
		UserThirdBindingResult result=client.findByUserId (order);
		
		response.setStatus (result.getStatus ().getCode ());
		response.setMessage (result.getMessage ());
		response.setDetailMessage (result.getMessage ());
		response.setCode (result.getCode ());
		List<UserThirdBindingInfo>  infos=result.getInfos ();
		
		if(infos!=null && infos.size ()>0){
			AbstractResponseData datas=convertFrom (infos);
			response.setDatas (datas);
		}
	}
	
	private AbstractResponseData convertFrom(List<UserThirdBindingInfo> userThirdBindingInfos) {
		UserThirdResponseListData responseListData=new UserThirdResponseListData ();
		
		List<UserThirdResponseData> responseDatas=new ArrayList<UserThirdResponseData> ();
		UserThirdResponseData responseData ;
		for(UserThirdBindingInfo info:userThirdBindingInfos){
			responseData= new UserThirdResponseData();
			BeanUtils.copyProperties(info, responseData);
			responseDatas.add (responseData);
		}
		
		
		responseListData.setList (responseDatas);
		
		return responseListData;
	}
}
