/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.api;

import com.jvv.customer.facade.user.info.UserVipLogInfo;
import com.jvv.customer.facade.user.order.UserVipLogOrder;
import com.jvv.customer.facade.user.result.UserVipLogResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.intergration.customer.user.FansRankClient;
import com.jvv.openapi.service.customer.user.requset.VipUserRankRequest;
import com.jvv.openapi.service.customer.user.response.VipUserRankResponseData;
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
@OpenApiService(name = "getVipRank", desc = "获取直推vip用户榜单", responseType = ResponseTypeEnum.SYN)
public class VipUserRankApiService extends AbstractApiService<VipUserRankRequest,ApiResponse> {
	
	@Resource
	FansRankClient fansRankClient;
	@Resource
	TokenUtils tokenUtils;
	
	@Override
	protected void doService (VipUserRankRequest request, ApiResponse response) {
		UserVipLogOrder order = new UserVipLogOrder ();
		BeanUtils.copyProperties (request,order);
		String userId = tokenUtils.getUserIdByToken (request.getToken ());
		order.setUserId (userId);
		
		UserVipLogResult result = fansRankClient.vipCountRank (order, request.getStart (), request.getPageSize ());
		response.setStatus (result.getStatus ().getCode ());
		response.setMessage (result.getMessage ());
		response.setDetailMessage (result.getMessage ());
		response.setCode (result.getCode ());
		List<UserVipLogInfo> infos = result.getInfos ();
		if(infos!=null){
			VipUserRankResponseData datas = new VipUserRankResponseData ();
			datas.setUserVipLogInfoList (infos);
			response.setDatas (datas);
		}
		
	}
}
