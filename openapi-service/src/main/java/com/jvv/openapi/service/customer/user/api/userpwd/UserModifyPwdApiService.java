/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.api.userpwd;

import com.jvv.customer.facade.base.result.SimpleResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.intergration.customer.user.UserResetPwdClient;
import com.jvv.openapi.service.customer.user.requset.userpwd.UserModifyRequest;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA
 * 〈修改用户密码、安全码〉 <p>
 * 〈修改用户密码、安全码〉
 *
 * @author linxm
 * @date 2017/3/22
 * @time 18:03
 */
@OpenApiService(name = "modifyUserPwd", desc = "修改用户密码、安全码", responseType = ResponseTypeEnum.SYN)
public class UserModifyPwdApiService extends AbstractApiService<UserModifyRequest,ApiResponse> {
	
	@Resource
	private UserResetPwdClient userResetPwdClient;
	@Resource
	private TokenUtils tokenUtils;
	
	@Override
	protected void doService (UserModifyRequest request, ApiResponse response) {
		
		String userId = tokenUtils.getUserIdByToken (request.getToken ());
		
		SimpleResult result = userResetPwdClient.modifyUserPwd (userId, request.getOldPassword (),
		                                                        request.getPassword (), request.getConfirmPassword (),
		                                                        request.getSmsCode (),request.getPwdType ());
		response.setStatus(result.getStatus().getCode());
		response.setMessage(result.getMessage());
		response.setDetailMessage(result.getMessage());
		response.setCode(result.getCode());
		
	}
}
