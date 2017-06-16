/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.api.loginfo;

import com.jvv.customer.facade.user.result.UserLoginLogResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.intergration.customer.user.UserLoginLogInfoClient;
import com.jvv.openapi.service.customer.user.requset.loginfo.QueryUserLoginLogsRequest;
import com.jvv.openapi.service.customer.user.response.UserLoginLogsResponseData;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/3/15
 * @time 19:35
 */
@OpenApiService(name = "queryUserLoginLogsService", desc = "查询用户所有登陆日志", responseType = ResponseTypeEnum.SYN)
public class QueryUserLoginLogsService extends AbstractApiService<QueryUserLoginLogsRequest,ApiResponse> {
	@Resource
	UserLoginLogInfoClient client;
	
	@Override
	protected void doService (QueryUserLoginLogsRequest request, ApiResponse response) {
		
		UserLoginLogResult result = client.queryUserLoginLogs (request.getStart (), request.getPageSize ());
		response.setStatus(result.getStatus().getCode());
		response.setMessage(result.getMessage());
		response.setDetailMessage(result.getMessage());
		
		//UserLoginLogsResponse userLoginLogsResponse = new UserLoginLogsResponse ();
		UserLoginLogsResponseData userLoginLogsResponseData = new UserLoginLogsResponseData ();
		userLoginLogsResponseData.setList (result.getInfos ());
		response.setDatas (userLoginLogsResponseData);
		
	}
}
