/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.api;

import com.jvv.common.services.result.SimpleResult;
import com.jvv.facade.group.order.GroupInfoOrder;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.intergration.social.group.GroupInfoClient;
import com.jvv.openapi.service.social.request.RemoveGroupRequest;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by IntelliJ IDEA
 * 〈移除群接口〉 <p>
 * 〈移除群接口〉
 *
 * @author lxb
 * @date 2017/4/10
 * @time 19:50
 */
@OpenApiService(name = "removeGroup", desc = "移除群", responseType = ResponseTypeEnum.SYN)
public class RemoveGroupApiService   extends AbstractApiService<RemoveGroupRequest,ApiResponse>{
	@Autowired
	GroupInfoClient client;
	@Autowired
	TokenUtils tokenUtils;
	
	@Override
	protected void doService (RemoveGroupRequest request, ApiResponse response) {
		String userId=tokenUtils.getUserIdByToken (request.getToken ());
		GroupInfoOrder order=new GroupInfoOrder ();
		order.setCreator (userId);
		order.setGroupId (request.getGroupId ());
		
		SimpleResult result=client.removeGroup (order);
		
		response.setCode (result.getCode ());
		response.setStatus (result.getStatus ().getCode ());
		response.setMessage (result.getMessage ());
		response.setDetailMessage (result.getDescription ());
	}
}
