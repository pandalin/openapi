/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.api;

import com.jvv.common.lang.StringUtils;
import com.jvv.common.services.PageInfo;
import com.jvv.facade.social.friend.order.UserNearByOrder;
import com.jvv.facade.social.friend.result.UserNearByResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.intergration.social.friend.FindNearByUserClient;
import com.jvv.openapi.service.social.request.FindNearByUserRequest;
import com.jvv.openapi.service.social.response.SimpleListResponseData;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/4/10
 * @time 14:25
 */
@OpenApiService(name = "findNearByUser", desc = "附近的人接口", responseType = ResponseTypeEnum.SYN)
public class FindNearByUserApiService extends AbstractApiService<FindNearByUserRequest, ApiResponse> {
	
	@Resource
	FindNearByUserClient client;
	@Resource
	TokenUtils tokenUtils;
	
	@Override
	protected void doService (FindNearByUserRequest request, ApiResponse response) {
		UserNearByOrder order = new UserNearByOrder ();
		BeanUtils.copyProperties (request, order);
		order.setUserId (tokenUtils.getUserIdByToken (request.getToken ()));
		if (StringUtils.isNotEmpty(request.getIdentity ())) {
			List<String> list = StringUtils.stringSplitToList(request.getIdentity (),",");
			order.setIdentityList (list);
		}
		PageInfo pageInfo = new PageInfo ();
		pageInfo.setPageNo (request.getPageNo ());
		pageInfo.setPageSize (request.getPageSize ());
		order.setPageInfo (pageInfo);
		
		UserNearByResult userNearByResult = client.findNearByUser (order);
		
		//返回结果注入相对应的response
		response.setStatus (userNearByResult.getStatus ().getCode ());
		response.setMessage (userNearByResult.getMessage ());
		response.setDetailMessage (userNearByResult.getDescription ());
		response.setCode (userNearByResult.getCode ());
		
		SimpleListResponseData data = new SimpleListResponseData ();
		data.setList (userNearByResult.getUserNearByInfoList ());
		response.setDatas (data);
		
	}
}
