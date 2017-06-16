/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.api;

import com.jvv.facade.group.info.CheckGroupInfo;
import com.jvv.facade.group.order.CheckGroupOrder;
import com.jvv.facade.group.result.CheckGroupResult;
import com.jvv.openapi.common.util.RedisUtils;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.intergration.social.group.GroupInfoClient;
import com.jvv.openapi.service.social.request.CheckGroupRequest;
import com.jvv.openapi.service.social.response.CheckGroupResponseData;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/4/7
 * @time 14:38
 */

@OpenApiService (name = "checkGroup",desc = "获取群资料",responseType = ResponseTypeEnum.SYN)
public class CheckGroupApiService extends AbstractApiService<CheckGroupRequest,ApiResponse> {

	@Autowired
	private GroupInfoClient groupInfoClient;
	@Autowired
	private TokenUtils tokenUtils;
	
	@Override
	protected void doService (CheckGroupRequest request, ApiResponse response) {
		CheckGroupOrder order = new CheckGroupOrder ();
		String userId = tokenUtils.getUserIdByToken (request.getToken ());
		BeanUtils.copyProperties (request,order);
		order.setUserId (userId);
		
		CheckGroupResult result = groupInfoClient.checkGroup (order);
		response.setStatus (result.getStatus ().getCode ());
		response.setMessage (result.getMessage ());
		response.setDetailMessage (result.getDescription ());
		response.setCode (result.getCode ());
		
		CheckGroupInfo info = result.getInfo ();
		CheckGroupResponseData data = new CheckGroupResponseData ();
		BeanUtils.copyProperties (info,data);
		response.setDatas (data);
	}
}
