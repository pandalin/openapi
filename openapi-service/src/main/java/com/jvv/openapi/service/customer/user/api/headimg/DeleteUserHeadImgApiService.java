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
 * @date 2017/3/24
 * @time 14:03
 */
@OpenApiService (name = "deleteUserHeadImg",desc = "删除用户头像图片(非物理删除)",responseType = ResponseTypeEnum.SYN)
public class DeleteUserHeadImgApiService extends AbstractApiService<UserHeadimgRequest,ApiResponse>{
	
	@Resource
	UserHeadimgClient userHeadimgClient;
	@Resource
	TokenUtils tokenUtils;
	
	@Override
	protected void doService (UserHeadimgRequest request, ApiResponse response) {
		SimpleResult result = new SimpleResult ();
		if(request.getId () == null){
			result.failure ("图片ID不能为空");
		}else{
			UserHeadimgOrder order = new UserHeadimgOrder ();
			order.setId (request.getId ());
			result = userHeadimgClient.deleteHeadImg (order);
		}
		response.setStatus (result.getStatus ().getCode ());
		response.setMessage (result.getMessage ());
		response.setDetailMessage (result.getMessage ());
		
	}
}
