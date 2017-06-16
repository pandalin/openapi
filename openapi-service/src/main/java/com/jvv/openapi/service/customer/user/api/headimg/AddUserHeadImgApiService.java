/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.api.headimg;

import com.alibaba.druid.util.StringUtils;
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
 * @time 11:35
 */
@OpenApiService (name = "addUserHeadImg" , desc = "用户添加头像图片",responseType = ResponseTypeEnum.SYN)
public class AddUserHeadImgApiService extends AbstractApiService<UserHeadimgRequest , ApiResponse> {
	
	@Resource
	UserHeadimgClient client;
	@Resource
	TokenUtils tokenUtils;
	
	@Override
	protected void doService (UserHeadimgRequest request, ApiResponse response) {
		SimpleResult result = new SimpleResult ();
		if (StringUtils.isEmpty (request.getImgurl ())){
			result.failure ("图片地址不能为空");
		}else{
			UserHeadimgOrder order = new UserHeadimgOrder ();
			order.setUserId (tokenUtils.getUserIdByToken (request.getToken ()));
			order.setImgurl (request.getImgurl ());
			result = client.uploadHeadImg (order);
		}
		response.setStatus (result.getStatus ().getCode ());
		response.setMessage (result.getMessage ());
		response.setDetailMessage (result.getMessage ());
	}
}
