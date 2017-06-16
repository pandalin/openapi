/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.api;

import com.jvv.customer.facade.user.info.UserRegisterTypeNumInfo;
import com.jvv.customer.facade.user.info.UserThirdBindingInfo;
import com.jvv.customer.facade.user.info.UserUpSixDegreeInfo;
import com.jvv.customer.facade.user.order.UserRegisterTypeNumByDateOrder;
import com.jvv.customer.facade.user.order.UserUpSixDegreeOrder;
import com.jvv.customer.facade.user.result.UserRegisterTypeNumResult;
import com.jvv.customer.facade.user.result.UserUpSixDegreeResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.AbstractResponseData;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.intergration.customer.user.UserUpSixDegreeClient;
import com.jvv.openapi.service.customer.user.requset.UserUpSixDegreeRequest;
import com.jvv.openapi.service.customer.user.response.UserUpSixDegreeResponse;
import com.jvv.openapi.service.customer.user.response.UserUpSixDegreeResponseData;
import com.jvv.openapi.service.customer.user.response.third.UserThirdResponseData;
import com.jvv.openapi.service.customer.user.response.third.UserThirdResponseListData;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author lxb
 * @date 2017/3/28
 * @time 15:17
 */

@OpenApiService(name = "userUpSixDegree", desc = "查询某个用户的上六度", responseType = ResponseTypeEnum.SYN)
public class UserUpSixDegreeApiService extends
		AbstractApiService<UserUpSixDegreeRequest,UserUpSixDegreeResponse> {
	@Autowired
	private UserUpSixDegreeClient client;
	@Override
	protected void doService (UserUpSixDegreeRequest request, UserUpSixDegreeResponse response) {
		UserUpSixDegreeOrder order=new UserUpSixDegreeOrder ();
		BeanUtils.copyProperties (request, order);
		
		UserUpSixDegreeResult result=client.findUpSixDegreeByUserId (order);
		
		response.setStatus (result.getStatus ().getCode ());
		response.setMessage (result.getMessage ());
		response.setDetailMessage (result.getMessage ());
		response.setCode (result.getCode ());
		List<UserUpSixDegreeInfo> infos=result.getInfos ();
		if(infos!=null && infos.size ()>0){
			AbstractResponseData datas=convertFrom (infos);
			response.setDatas (datas);
		}
	}
	
	public AbstractResponseData convertFrom(List<UserUpSixDegreeInfo> infos){
		UserUpSixDegreeResponseData responseData=new UserUpSixDegreeResponseData ();
		responseData.setUserUpSixDegreeInfoList (infos);
		return responseData;
	}
}
