/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.api;


import com.jvv.customer.facade.user.info.UserInfoInfo;
import com.jvv.customer.facade.user.order.UserInfoOrder;
import com.jvv.customer.facade.user.result.UserInfoResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.AbstractResponseData;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.intergration.customer.user.UserInfoClient;
import com.jvv.openapi.service.customer.user.requset.UserInfoRequestFindUserListByPage;
import com.jvv.openapi.service.customer.user.response.UserDataReportResponseData;
import com.jvv.openapi.service.customer.user.response.UserInfoResponse;
import com.jvv.openapi.service.customer.user.response.UserInfoResponseData;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author zhaoyk
 * @date
 * @time
 */
@OpenApiService(name = "userInfoServiceFindUserListByPage", desc = "查找用户列表", responseType = ResponseTypeEnum.SYN)
public class UserInfoServiceFindUserListByPage extends AbstractApiService<UserInfoRequestFindUserListByPage, UserInfoResponse> {
	
	@Resource
	private UserInfoClient userInfoClient;
	
	@Override
	protected void doService(UserInfoRequestFindUserListByPage request, UserInfoResponse response) {
		
		UserInfoOrder order = new UserInfoOrder();
		BeanUtils.copyProperties (request , order);
		UserInfoResult result = userInfoClient.findUserListByPage (order , request.getStart () , request.getPageSize ());
		
		response.setStatus(result.getStatus().getCode());
		response.setMessage(result.getMessage());
		response.setDetailMessage(result.getMessage());
		
		List<UserInfoInfo> userInfos = result.getInfos();
		
		if (userInfos != null) {
			UserInfoResponseData responseDatas = new UserInfoResponseData ();
			responseDatas.setUserInfoInfos (userInfos);
			response.setDatas (responseDatas);
		}
	}
	
}
