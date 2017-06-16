/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.api.realname;

import com.jvv.customer.facade.user.result.UserRealnameCheckResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.intergration.customer.user.UserRealnameCheckClient;
import com.jvv.openapi.service.customer.user.requset.realname.UserRealnameCheckRequest;
import com.jvv.openapi.service.customer.user.response.UserRealnameCheckResponseData;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/3/17
 * @time 9:40
 */
@OpenApiService(name = "queryUserRealnameCheckList", desc = "获取用户实名认证列表", responseType = ResponseTypeEnum.SYN)
public class QueryUserRealnameCheckApiService extends AbstractApiService<UserRealnameCheckRequest, ApiResponse> {
	@Resource
	UserRealnameCheckClient checkClient;
	
	/**
	 * 服务处理方法
	 * <p/>
	 * 如果抛出非ApiServiceException异常,对外响应内部错误
	 * <p/>
	 * 如果抛出ApiServiceException异常,会根据异常的信息返回给用户
	 * <p/>
	 *
	 * @param request
	 * @param response
	 */
	@Override
	protected void doService (UserRealnameCheckRequest request, ApiResponse response) {
		UserRealnameCheckResult result;
		
		result = checkClient.selectUserRealnameCheck (request.getRealname (), request.getStatus (),
		                                    request.getStart (),request.getPageSize ());
		
		response.setStatus(result.getStatus().getCode());
		response.setMessage(result.getMessage());
		response.setDetailMessage(result.getMessage());
		
		UserRealnameCheckResponseData userRealnameCheckResponseData = new UserRealnameCheckResponseData ();
		userRealnameCheckResponseData.setList (result.getInfos ());
		response.setDatas (userRealnameCheckResponseData);
		
	}
}
