/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.api;

import com.jvv.common.lang.beans.Copier;
import com.jvv.common.services.PageInfo;
import com.jvv.facade.sixdegree.info.SearchSixDegreeInfo;
import com.jvv.facade.sixdegree.info.SearchSixDegreeList;
import com.jvv.facade.sixdegree.order.SearchSixDegreeOrder;
import com.jvv.facade.sixdegree.result.SearchSixDegreeResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.intergration.social.sixDegree.UserTreeClient;
import com.jvv.openapi.service.social.request.SearchSixDegreeRequest;
import com.jvv.openapi.service.social.response.SearchSixDegreeResponseData;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/4/19
 * @time 11:16
 */
@OpenApiService (name="searchSixDegree",desc = "查询我的六度人脉",responseType = ResponseTypeEnum.SYN)
public class SearchSixDegreeApiService extends AbstractApiService<SearchSixDegreeRequest,ApiResponse> {
	
	@Resource
	private UserTreeClient userTreeClient;
	
	@Resource
	private TokenUtils tokenUtils;
	
	@Override
	protected void doService (SearchSixDegreeRequest request, ApiResponse response) {
		String userId = tokenUtils.getUserIdByToken (request.getToken ());
		SearchSixDegreeOrder order = new SearchSixDegreeOrder ();
		Copier.copy (request,order);
		order.setUserId (userId);
		PageInfo pageInfo = new PageInfo ();
		pageInfo.setPageNo (request.getPageNo ());
		pageInfo.setPageSize (request.getPageSize ());
		order.setPageInfo (pageInfo);
		
		SearchSixDegreeResult result = userTreeClient.searchSixDegree (order);
		//统一向response对象中注入code,status,message,detailMessage等参数
		response.injectResponse (result,response);
		
		SearchSixDegreeList info = result.getInfo ();
		if(info!=null){
			List<SearchSixDegreeInfo> list = info.getSearchSixDegreeInfoList ();
			SearchSixDegreeResponseData data = new SearchSixDegreeResponseData ();
			data.setSearchSixDegreeInfoList (list);
			response.setDatas (data);
		}
	}
}
