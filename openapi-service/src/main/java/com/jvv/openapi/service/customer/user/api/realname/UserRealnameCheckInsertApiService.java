/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.api.realname;

import com.jvv.customer.facade.base.result.SimpleResult;
import com.jvv.customer.facade.user.order.UserRealnameCheckOrder;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.intergration.customer.user.UserRealnameCheckClient;
import com.jvv.openapi.service.customer.user.requset.realname.UserRealnameCheckRequest;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/3/16
 * @time 18:06
 */
@OpenApiService(name = "insertUserRealnameCheck", desc = "用户提交实名认证", responseType = ResponseTypeEnum.SYN)
public class UserRealnameCheckInsertApiService extends AbstractApiService<UserRealnameCheckRequest, ApiResponse> {
	@Resource
	UserRealnameCheckClient checkClient;
	@Resource
	TokenUtils tokenUtils;
	
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
		SimpleResult result = new SimpleResult ();
		String token = request.getToken () ;
		if (token == null || "".equals (token)){
			result.failure ("token不能为空！");
		}else {
			UserRealnameCheckOrder order = new UserRealnameCheckOrder ();
			BeanUtils.copyProperties (request,order);
			String userId = tokenUtils.getUserIdByToken (token);
			order.setUserId (userId);
			result = checkClient.insertUserRealnameCheck (order);
		}
		
		response.setStatus(result.getStatus().getCode());
		response.setMessage(result.getMessage());
		response.setDetailMessage(result.getMessage());
		
		/*SimpleResultResponseData simpleResultResponseData = new SimpleResultResponseData ();
		response.setDatas (simpleResultResponseData);*/
	}
}
