/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.api.loginfo;

import com.jvv.customer.facade.base.result.SimpleResult;
import com.jvv.customer.facade.user.order.UserLoginLogOrder;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.intergration.customer.user.UserLoginLogInfoClient;
import com.jvv.openapi.service.customer.user.requset.loginfo.UserLoginLogInfoCommitRequest;
import com.jvv.openapi.service.customer.user.response.SimpleResultResponseData;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA
 * 〈提交登陆日志接口〉 <p>
 * 〈App端调用该接口提交用户登陆日志〉
 *
 * @author Huangw
 * @date 2017/3/15
 * @time 14:53
 */
@OpenApiService(name = "userLoginLogInfoCommitService", desc = "上传用户登陆日志接口", responseType = ResponseTypeEnum.SYN)
public class UserLoginLogInfoCommitService extends AbstractApiService<UserLoginLogInfoCommitRequest,ApiResponse>{
	
	
	@Resource
	UserLoginLogInfoClient client;
	@Resource
	TokenUtils tokenUtils;
	/**
	 * 服务处理方法
	 * <p/>
	 * 如果抛出非ApiServiceException异常,对外响应内部错误
	 * <p/>
	 * 如果抛出ApiServiceException异常,会根据异常的信息返回给用户
	 * <p/>
	 *
	 * @param request
	 * @param response
	 */
	@Override
	protected void doService (UserLoginLogInfoCommitRequest request, ApiResponse response) {
		UserLoginLogOrder order = new UserLoginLogOrder ();
		String userId = tokenUtils.getUserIdByToken (request.getToken ());
		BeanUtils.copyProperties (request,order);
		//设备
		order.setEquipment (request.getDevice ());
		//app发行版本
		order.setAppVer (request.getBuildVersion ());
		//系统版本
		order.setSystemVer (request.getSystemVersion ());
		
		order.setUserId (userId);
		SimpleResult result = client.commitUserLoginLog (order);
		
		response.setStatus(result.getStatus().getCode());
		response.setMessage(result.getMessage());
		response.setDetailMessage(result.getMessage());
		
		SimpleResultResponseData simpleResultResponseData = new SimpleResultResponseData ();
		
		response.setDatas (simpleResultResponseData);
	}
}
