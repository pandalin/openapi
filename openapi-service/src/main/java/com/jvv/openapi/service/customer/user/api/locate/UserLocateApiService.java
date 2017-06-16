/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.api.locate;

import com.jvv.customer.facade.user.result.UserLocateResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.facade.constants.enums.Status;
import com.jvv.openapi.intergration.customer.user.UserLocateClient;
import com.jvv.openapi.service.customer.user.requset.locate.UserLocateRequest;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author linxm
 * @date 2017/3/20
 * @time 10:52
 */
@OpenApiService (name = "saveUserLocate",desc = "保存用户地理位置信息",responseType = ResponseTypeEnum.SYN)
public class UserLocateApiService extends AbstractApiService<UserLocateRequest,ApiResponse> {
	
	@Resource
	private UserLocateClient userLocateClient;
	@Resource
	private TokenUtils tokenUtils;
	
	@Override
	protected void doService (UserLocateRequest request, ApiResponse response) {
		
		if (StringUtils.isNotEmpty (request.getLocation ())) {
			String userId = tokenUtils.getUserIdByToken (request.getToken ());
			String[] locateArr = org.springframework.util.StringUtils.commaDelimitedListToStringArray (request.getLocation ());
			UserLocateResult locateResult = userLocateClient.saveUserLocate (userId, locateArr[0], locateArr[1],request.getCityCode (),request.getCityName (),request.getCountyCode (),request.getCountyName (),request.getProvince());
			response.setStatus(locateResult.getStatus().getCode());
			response.setMessage(locateResult.getMessage());
			response.setDetailMessage(locateResult.getMessage());
		} else {
			response.setStatus(Status.FAIL.getCode ());
			response.setMessage("地理位置参数location不能为空");
			response.setDetailMessage("地理位置参数location不能为空");
		}
		
		
		
	}
}
