/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.api;

import com.jvv.facade.group.result.QueryIMGroupIdResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.intergration.social.group.GroupInfoClient;
import com.jvv.openapi.service.social.request.GetIMGroupIdByGroupNumRequest;
import com.jvv.openapi.service.social.response.topic.GetIMGroupIdByGroupNumResponseData;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/5/23
 * @time 11:05
 */
@OpenApiService(name = "getIMGroupIdByGroupNum", desc = "通过自定义群号获取IM群ID", responseType = ResponseTypeEnum.SYN)
public class GetIMGroupIdByGroupNumApiService extends AbstractApiService<GetIMGroupIdByGroupNumRequest,ApiResponse> {
	
	@Resource
	private GroupInfoClient groupInfoClient;
	
	@Override
	protected void doService (GetIMGroupIdByGroupNumRequest request, ApiResponse response) {
		QueryIMGroupIdResult result = groupInfoClient.getIMGroupIdByGroupNum (request.getGroupNum ());
		GetIMGroupIdByGroupNumResponseData data = new GetIMGroupIdByGroupNumResponseData ();
		
		if(result.getInfo ()!=null){
			data.setGroupId (result.getInfo ().getGroupId ());
			response.setDatas (data);
			response.injectResponse (result,response);
		}
		
	}
}
