/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.api.headimg;

import com.jvv.customer.facade.base.result.SimpleResult;
import com.jvv.customer.facade.user.order.UserHeadimgOrder;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.intergration.customer.user.UserHeadimgClient;
import com.jvv.openapi.service.customer.user.requset.headimag.UserHeadimgRequest;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/3/23
 * @time 17:28
 */
@OpenApiService (name = "setDefaultHeadImg",desc = "设置用户默认头像",responseType = ResponseTypeEnum.SYN)
public class SetDefaultHeadImgApiService extends AbstractApiService<UserHeadimgRequest ,ApiResponse> {
	
	@Resource
	UserHeadimgClient userHeadimgClient;
	@Resource
	TokenUtils tokenUtils;
	
	@Override
	protected void doService (UserHeadimgRequest request, ApiResponse response) {
		SimpleResult result = new SimpleResult ();
		String userId =	tokenUtils.getUserIdByToken (request.getToken ());
		if(request.getId () == null){
			result.failure ("头像ID不能为空");
		}else {
			UserHeadimgOrder order = new UserHeadimgOrder ();
			order.setUserId (userId);
			order.setId (request.getId ());
			
			result = userHeadimgClient.setDefaultHeadImg (order);
		}
		
		response.setStatus (result.getStatus ().getCode ());
		response.setDetailMessage (result.getMessage ());
		response.setMessage (result.getMessage ());
	}
}
