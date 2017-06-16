/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.api;

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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date
 * @time
 */
@OpenApiService(name = "queryParam", desc = "获取字典列表", responseType = ResponseTypeEnum.SYN)
public class UserParamQueryApiService  extends AbstractApiService<UserParamRequest,UserParamResponse> {
	
	@Resource
	UserParamClient userParamClient;
	
	@Override
	protected void doService (UserParamRequest request, UserParamResponse response) {
		
		if(request.getCode ()!=null){
			UserParamOrder order = new UserParamOrder ();
			BeanUtils.copyProperties (request,order);
				//远程调用客户端获取其result
			UserParamResult result = userParamClient.query (order,request.getStart (),request.getPageSize ());
			//返回结果注入相对应的response
			response.setStatus (result.getStatus ().getCode ());
			response.setMessage (result.getMessage ());
			response.setDetailMessage (result.getMessage ());
			response.setCode (result.getCode ());
			//从取得的UserParamResult中获取info对象
			List<UserParamInfo> infos = result.getInfos ();
			//如果获取的UserParamInfo对象不为空，就向response注入其参数值，从而返回给服务请求者
			if(infos!=null){
				UserParamResponseData responseData = new UserParamResponseData ();
				responseData.setUserParamInfos (infos);
//				得到对应count总数
				responseData.setCount (infos.get (0).getCount ());
//				responseData.setCount ();
				response.setDatas (responseData);
			}
		}else{
			response.setStatus (Status.FAIL.getCode ());
			response.setMessage ("code参数代码不能为空!");
			response.setDetailMessage ("code参数代码不能为空!");
		}
		
	}
}
