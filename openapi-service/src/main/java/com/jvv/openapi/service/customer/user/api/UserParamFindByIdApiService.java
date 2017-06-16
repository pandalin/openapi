/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.api;

import com.jvv.customer.facade.user.info.UserParamInfo;
import com.jvv.customer.facade.user.result.UserParamResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.facade.constants.enums.Status;
import com.jvv.openapi.intergration.customer.user.UserParamClient;
import com.jvv.openapi.service.customer.user.requset.UserParamRequest;
import com.jvv.openapi.service.customer.user.response.UserParamResponse;
import com.jvv.openapi.service.customer.user.response.UserParamResponseData;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date
 * @time
 */
@OpenApiService (name = "findUserParamByID",desc = "通过ID找到对应字典参数", responseType = ResponseTypeEnum.SYN)
public class UserParamFindByIdApiService extends AbstractApiService<UserParamRequest,UserParamResponse>{
	
	@Resource
	private UserParamClient userParamClient;
	
	@Override
	protected void doService (UserParamRequest request, UserParamResponse response) {
		//远程调用客户端获取其result
		UserParamResult result = userParamClient.findById (request.getId ());
		//返回结果注入相对应的response
		response.setStatus (result.getStatus ().getCode ());
		response.setMessage (result.getMessage ());
		response.setDetailMessage (result.getMessage ());
		response.setCode (result.getCode ());
		//从取得的UserParamResult中获取info对象
		UserParamInfo userParamInfo = result.getInfo ();
		
		//如果获取的UserParamInfo对象不为空，就向response注入其参数值，从而返回给服务请求者
		if(userParamInfo!=null){
			UserParamResponseData responseData = new UserParamResponseData ();
			BeanUtils.copyProperties (userParamInfo,responseData,"status");
			
			response.setDatas (responseData);
		}
		
	}
}
