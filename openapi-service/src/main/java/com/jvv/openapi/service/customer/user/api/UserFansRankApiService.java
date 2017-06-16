/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.api;

import com.jvv.customer.facade.user.info.UserFansRankInfo;
import com.jvv.customer.facade.user.info.UserVipLogInfo;
import com.jvv.customer.facade.user.order.UserFansRankOrder;
import com.jvv.customer.facade.user.order.UserVipLogOrder;
import com.jvv.customer.facade.user.result.UserFansRankResult;
import com.jvv.customer.facade.user.result.UserVipLogResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.intergration.customer.user.FansRankClient;
import com.jvv.openapi.service.customer.user.requset.UserFansRankRequest;
import com.jvv.openapi.service.customer.user.response.UserFansRankResponseData;
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
@OpenApiService(name = "getFansCountRank", desc = "获取窝粉榜单", responseType = ResponseTypeEnum.SYN)
public class UserFansRankApiService extends AbstractApiService<UserFansRankRequest,ApiResponse>{
	
	@Resource
	FansRankClient fansRankClient;
	
	@Override
	protected void doService (UserFansRankRequest request, ApiResponse response) {
		UserFansRankOrder order = new UserFansRankOrder ();
		BeanUtils.copyProperties (request, order);
		
		UserFansRankResult result = fansRankClient.fansCountRank (order, request.getStart (), request.getPageSize ());
		response.setStatus (result.getStatus ().getCode ());
		response.setMessage (result.getMessage ());
		response.setDetailMessage (result.getMessage ());
		response.setCode (result.getCode ());
		List<UserFansRankInfo> infos = result.getInfos ();
		if(infos!=null){
			UserFansRankResponseData datas = new UserFansRankResponseData ();
			datas.setUserFansRankInfoList (infos);
			response.setDatas (datas);
		}
	}
}
