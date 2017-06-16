/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.api;

import com.jvv.common.services.result.SimpleResult;
import com.jvv.facade.group.info.CheckGroupInfo;
import com.jvv.facade.group.order.GroupInfoOrder;
import com.jvv.facade.group.result.CheckGroupResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.intergration.social.group.GroupInfoClient;
import com.jvv.openapi.service.social.request.CreateGroupRequest;
import com.jvv.openapi.service.social.response.CheckGroupResponseData;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/4/11
 * @time 14:38
 */
@OpenApiService (name = "CreateGroup",desc = "创建群",responseType = ResponseTypeEnum.SYN)
public class CreateGroupApiService extends AbstractApiService<CreateGroupRequest,ApiResponse>{
	
	@Autowired
	private GroupInfoClient groupInfoClient;
	@Autowired
	private TokenUtils tokenUtils;
	
	@Override
	protected void doService (CreateGroupRequest request, ApiResponse response) {
		GroupInfoOrder order = new GroupInfoOrder ();
		String creator = tokenUtils.getUserIdByToken (request.getToken ());
		BeanUtils.copyProperties (request,order);
		order.setCreator (creator);
		
		CheckGroupResult result = groupInfoClient.createGroup (order);
		response.setStatus (result.getStatus ().getCode ());
		response.setCode (result.getCode ());
		response.setMessage (result.getMessage ());
		response.setDetailMessage(result.getDescription ());
		
		CheckGroupInfo checkGroupInfo=result.getInfo ();
		if(checkGroupInfo!=null){
			CheckGroupResponseData data=new CheckGroupResponseData ();
			BeanUtils.copyProperties (checkGroupInfo,data);
			response.setDatas (data);
		}
		
		
	}
}
