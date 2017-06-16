/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.api.headimg;

import com.jvv.customer.facade.user.order.UserHeadimgOrder;
import com.jvv.customer.facade.user.result.UserHeadimgResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.intergration.customer.user.UserHeadimgClient;
import com.jvv.openapi.service.customer.user.requset.headimag.UserHeadimgRequest;
import com.jvv.openapi.service.customer.user.response.UserHeadimgResponseData;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/3/24
 * @time 14:30
 */
@OpenApiService(name = "getUserHeadImgList", desc = "获取用户头像列表", responseType = ResponseTypeEnum.SYN)
public class GetUserHeadImgListApiService extends AbstractApiService<UserHeadimgRequest, ApiResponse> {
	
	@Resource
	UserHeadimgClient userHeadimgClient;
	@Resource
	TokenUtils tokenUtils;
	
	@Override
	protected void doService (UserHeadimgRequest request, ApiResponse response) {
		UserHeadimgResult result = new UserHeadimgResult ();
		String userSelfId = tokenUtils.getUserIdByToken (request.getToken ());
		String userId;
		if(request.getUserId () == null || "".equals (request.getUserId ())){
			userId = userSelfId;
		}else {
			userId = request.getUserId ();
		}
		
		UserHeadimgOrder order = new UserHeadimgOrder ();
		order.setUserId (userId);
		result = userHeadimgClient.getHeadImgList (order);
		
		
		response.setStatus (result.getStatus ().getCode ());
		response.setDetailMessage (result.getMessage ());
		response.setMessage (result.getMessage ());
		
		UserHeadimgResponseData data = new UserHeadimgResponseData ();
		data.setList (result.getInfos ());
		response.setDatas (data);
		
	}
}
