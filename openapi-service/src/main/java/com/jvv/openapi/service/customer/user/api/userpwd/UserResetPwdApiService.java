/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.api.userpwd;

import com.jvv.customer.facade.user.info.UserResetPwdInfo;
import com.jvv.customer.facade.user.result.UserResetPwdResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.AbstractResponseData;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.intergration.customer.user.UserResetPwdClient;
import com.jvv.openapi.service.customer.user.requset.userpwd.UserResetPwdRequest;
import com.jvv.openapi.service.customer.user.response.UserResetPwdResponse;
import com.jvv.openapi.service.customer.user.response.UserResetPwdResponseData;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA
 * 〈重置密码service接口〉 <p>
 * 〈重置密码service接口〉
 *
 * @author linxm
 * @date 2017/3/16
 * @time 9:28
 */
@OpenApiService(name = "userResetPwd", desc = "重置用户密码", responseType = ResponseTypeEnum.SYN)
public class UserResetPwdApiService extends AbstractApiService<UserResetPwdRequest,UserResetPwdResponse> {
	
	@Resource
	private UserResetPwdClient userResetPwdClient;
	
	@Override
	protected void doService (UserResetPwdRequest request, UserResetPwdResponse response) {
		UserResetPwdResult resetPwdResult = userResetPwdClient.resetPwd (request.getUserId (),request.getRealname (),request.getIdcard (),request.getPwdType ());
		response.setStatus(resetPwdResult.getStatus().getCode());
		response.setMessage(resetPwdResult.getMessage());
		response.setDetailMessage(resetPwdResult.getMessage());
		response.setCode(resetPwdResult.getCode());
		UserResetPwdInfo resetPwdInfo = resetPwdResult.getInfo ();
		
		if (resetPwdInfo != null) {
			AbstractResponseData responseData = convertFrom(resetPwdInfo);
			response.setDatas(responseData);
		}
	}
	
	private AbstractResponseData convertFrom(UserResetPwdInfo resetPwdInfo) {
		UserResetPwdResponseData responseData = new UserResetPwdResponseData();
		responseData.setNewPwd (resetPwdInfo.getNewPwd ());
		return responseData;
	}
}