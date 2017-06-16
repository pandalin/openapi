/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.api.loginOut;

import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.facade.constants.enums.Status;
import com.jvv.openapi.service.customer.user.requset.loginOut.UserLoginOutRequest;


import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA
 * 〈用户退出登录〉 <p>
 * 〈用户退出登录〉
 *
 * @author liaotianyu
 * @date 2017/3/22
 * @time 15:41
 */
@OpenApiService (name = "loginOut" ,desc = "退出登录" , responseType = ResponseTypeEnum.SYN)
public class UserLoginOutApiService extends AbstractApiService<UserLoginOutRequest, ApiResponse> {
	@Resource
	TokenUtils tokenUtils;
	
	@Override
	protected void doService (UserLoginOutRequest request, ApiResponse response) {
			/*通过token获取userId*/
			String userId = tokenUtils.getUserIdByToken(request.getToken());
		    /*从redis中移除userId*/
			tokenUtils.clean(userId);
		    response.setStatus(Status.SUCCESS.getCode());
			response.setDatas (null);
	}
}
