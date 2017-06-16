/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.api;

import com.jvv.common.lang.beans.Copier;
import com.jvv.facade.sixdegree.info.FindSixDegreeDataInfo;
import com.jvv.facade.sixdegree.order.FindSixDegreeDataOrder;
import com.jvv.facade.sixdegree.result.FindSixDegreeDataResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.intergration.social.sixDegree.UserTreeClient;
import com.jvv.openapi.service.social.request.SixDegreeCountRequest;
import com.jvv.openapi.service.social.response.SixDegreeCountResponseData;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/4/19
 * @time 15:09
 */
@OpenApiService (name = "sixDegreeCount",desc = "我的六度人脉人数数据",responseType = ResponseTypeEnum.SYN)
public class SixDegreeCountApiService extends AbstractApiService<SixDegreeCountRequest,ApiResponse>{
	
	@Resource
	private UserTreeClient userTreeClient;
	
	@Resource
	private TokenUtils tokenUtils;
	
	@Override
	protected void doService (SixDegreeCountRequest request, ApiResponse response) {
		String userId = tokenUtils.getUserIdByToken (request.getToken ());
		FindSixDegreeDataOrder order = new FindSixDegreeDataOrder ();
		order.setUserId (userId);
		
		FindSixDegreeDataResult result = userTreeClient.findSixDegreeData (order);
		response.injectResponse (result,response);
		
		FindSixDegreeDataInfo info = result.getInfo ();
		if(info!=null){
			SixDegreeCountResponseData data = new SixDegreeCountResponseData ();
			Copier.copy (info,data);
			response.setDatas (data);
		}
		
		
	}
}
