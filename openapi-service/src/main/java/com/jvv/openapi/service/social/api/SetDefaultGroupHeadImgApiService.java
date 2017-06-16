/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.api;

import com.jvv.common.services.result.SimpleResult;
import com.jvv.facade.group.order.GroupHeadImgOrder;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.intergration.social.group.GroupHeadImgClient;
import com.jvv.openapi.service.social.request.DeletAndDefaultGroupHeadImgRequest;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/4/13
 * @time 16:29
 */
@OpenApiService(name = "setDefaultGroupHeadImg", desc = "设置默认群头像接口", responseType = ResponseTypeEnum.SYN)
public class SetDefaultGroupHeadImgApiService extends AbstractApiService<DeletAndDefaultGroupHeadImgRequest,ApiResponse>{
	
	@Resource
	GroupHeadImgClient client;
	@Resource
	TokenUtils tokenUtils;
	
	@Override
	protected void doService (DeletAndDefaultGroupHeadImgRequest request, ApiResponse response) {
		
		String userId = tokenUtils.getUserIdByToken (request.getToken ());
		GroupHeadImgOrder order = new GroupHeadImgOrder ();
		BeanUtils.copyProperties (request, order);
		SimpleResult result = client.setDefaultHeadImg (order);
		
		response.setStatus (result.getStatus ().getCode ());
		response.setMessage (result.getMessage ());
		response.setDetailMessage (result.getDescription ());
		response.setCode (result.getCode ());
		
	}
}
