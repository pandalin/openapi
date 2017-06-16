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
import com.jvv.openapi.intergration.social.group.GroupInfoClient;
import com.jvv.openapi.service.social.request.ModifyGroupRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/4/11
 * @time 14:30
 */
@OpenApiService (name = "ModifyGroup",desc = "设置群相关信息",responseType = ResponseTypeEnum.SYN)
public class ModifyGroupApiService extends AbstractApiService<ModifyGroupRequest,ApiResponse>{
	
	@Autowired
	private GroupInfoClient groupInfoClient;
	
	@Override
	protected void doService (ModifyGroupRequest request, ApiResponse response) {
		GroupInfoOrder order = new GroupInfoOrder ();
		BeanUtils.copyProperties (request,order);
		
		SimpleResult result = groupInfoClient.modifyGroup (order);
		response.setStatus (result.getStatus ().getCode ());
		response.setCode (result.getCode ());
		response.setMessage (result.getMessage ());
		response.setDetailMessage (result.getDescription ());
	}
}
