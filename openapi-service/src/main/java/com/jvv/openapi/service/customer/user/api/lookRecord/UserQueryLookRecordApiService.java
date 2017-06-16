/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.api.lookRecord;

import com.jvv.customer.facade.user.info.UserLookRecordInfo;
import com.jvv.customer.facade.user.order.UserLookRecordOrder;
import com.jvv.customer.facade.user.result.UserLookRecordResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.intergration.customer.user.UserLookRecordClient;
import com.jvv.openapi.service.customer.user.requset.lookRecord.UserLookRecordRequest;
import com.jvv.openapi.service.customer.user.response.UserLookRecordResponseData;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date
 * @time
 */
@OpenApiService (name = "queryLookRecord",desc = "查询谁看过我用户列表",responseType = ResponseTypeEnum.SYN)
public class UserQueryLookRecordApiService extends AbstractApiService<UserLookRecordRequest,ApiResponse>{
	
	@Resource
	private UserLookRecordClient userLookRecordClient;
	@Resource
	private TokenUtils tokenUtils;
	
	@Override
	protected void doService (UserLookRecordRequest request, ApiResponse response) {
		UserLookRecordOrder order = new UserLookRecordOrder ();
		BeanUtils.copyProperties (request,order);
		String userId = tokenUtils.getUserIdByToken (request.getToken ());
		order.setUserId (userId);
		
		UserLookRecordResult result = userLookRecordClient.queryLookRecord (order);
		
		response.setStatus (result.getStatus ().getCode ());
		response.setMessage (result.getMessage ());
		response.setMessage (result.getMessage ());
		response.setCode (result.getCode ());
		List<UserLookRecordInfo> infos = result.getInfos ();
		if(infos!=null){
			UserLookRecordResponseData data = new UserLookRecordResponseData ();
			data.setUserLookRecordInfoList (infos);
			response.setDatas (data);
		}
		
	}
}
