/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.api;

import com.jvv.customer.facade.base.result.SimpleResult;
import com.jvv.customer.facade.user.info.UserParamInfo;
import com.jvv.customer.facade.user.order.UserParamOrder;
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
@OpenApiService(name = "createParam", desc = "新增字典参数", responseType = ResponseTypeEnum.SYN)
public class UserParamCreateApiService extends AbstractApiService<UserParamRequest,UserParamResponse>{
	
	@Resource
	private UserParamClient userParamClient;
	
	@Override
	protected void doService (UserParamRequest request, UserParamResponse response) {
		if(request.getCode ()!=null){
			UserParamOrder order = new UserParamOrder ();
			BeanUtils.copyProperties (request,order);
			//远程调用客户端获取其result
			SimpleResult result = userParamClient.create (order);
			//返回结果注入相对应的response
			response.setStatus (result.getStatus ().getCode ());
			response.setMessage (result.getMessage ());
			response.setDetailMessage (result.getMessage ());
			response.setCode (result.getCode ());
		}else{
			response.setStatus (Status.FAIL.getCode ());
			response.setMessage ("code参数代码不能为空!");
			response.setDetailMessage ("code参数代码不能为空!");
		}
		
	}
}
