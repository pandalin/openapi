/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.api;


import com.jvv.customer.facade.user.info.UserDataReportInfo;
import com.jvv.customer.facade.user.result.UserDataReportResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.AbstractResponseData;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.intergration.customer.user.UserDataReportClient;
import com.jvv.openapi.service.customer.user.requset.UserDataReportRequestFindActiceAndRegistUser;
import com.jvv.openapi.service.customer.user.response.UserDataReportResponse;
import com.jvv.openapi.service.customer.user.response.UserDataReportResponseData;
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
@OpenApiService(name = "userDataReportServiceFindActive", desc = "查找日活跃用户", responseType = ResponseTypeEnum.SYN)
public class UserDataReportServiceFindActive extends AbstractApiService<UserDataReportRequestFindActiceAndRegistUser, UserDataReportResponse> {
	
	@Resource
	private UserDataReportClient userDataReportClient;
	
	@Override
	protected void doService(UserDataReportRequestFindActiceAndRegistUser request, UserDataReportResponse response) {
		
		UserDataReportResult result = userDataReportClient.findActiveAndRegistUser ();
		
		response.setStatus(result.getStatus().getCode());
		response.setMessage(result.getMessage());
		response.setDetailMessage(result.getMessage());
		
		List<UserDataReportInfo> userInfos = result.getInfos();
		
		
        if (userInfos != null) {
            UserDataReportResponseData responseDatas = new UserDataReportResponseData ();
            responseDatas.setUserDataReportInfo (userInfos);
            response.setDatas (responseDatas);
        }
	}
	
	private List<AbstractResponseData> convertFrom(List<UserDataReportInfo> userInfos) {
		List<AbstractResponseData> responseDatas = new ArrayList<AbstractResponseData> ();
		for (UserDataReportInfo info : userInfos){
			UserDataReportResponseData responseData = new UserDataReportResponseData();
			BeanUtils.copyProperties(info, responseData);
			responseDatas.add (responseData);
		}
		return responseDatas;
	}
	
}
