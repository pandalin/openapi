/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.api.userinfo;

import com.jvv.customer.facade.base.result.SimpleResult;
import com.jvv.customer.facade.user.order.UserInfoAndRemarkOrder;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.intergration.customer.user.UserInfoClient;
import com.jvv.openapi.service.customer.user.requset.userinfo.UserInfoAndRemarkRequest;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/3/20
 * @time 16:16
 */
@OpenApiService(name = "modifyUserInfoAndRemark", desc = "修改用户基础资料和扩展资料", responseType = ResponseTypeEnum.SYN)
public class UserInfoAndRemarkModityApiService extends AbstractApiService<UserInfoAndRemarkRequest,ApiResponse>{
	
	@Resource
	UserInfoClient userInfoClient;
	@Resource
	TokenUtils tokenUtils;
	
	@Override
	protected void doService (UserInfoAndRemarkRequest request, ApiResponse response) {
		
		SimpleResult result ;
		UserInfoAndRemarkOrder order = new UserInfoAndRemarkOrder ();
		BeanUtils.copyProperties (request,order);
		String userId = tokenUtils.getUserIdByToken (request.getToken ());
		order.setUserId (userId);
		if(request.getBirthday () != null){
			SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd");
			order.setBirthday (sdf.parse (request.getBirthday (),new ParsePosition (0)));
		}
		result = userInfoClient.modifyUserInfoAndRemark (order);
		
		response.setStatus(result.getStatus().getCode());
		response.setMessage(result.getMessage());
		response.setDetailMessage(result.getMessage());
	}
}
