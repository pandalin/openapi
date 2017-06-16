/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.api.userinfo;

import com.jvv.customer.facade.base.result.SimpleResult;
import com.jvv.customer.facade.user.order.UserInfoOrder;
import com.jvv.gateway.facade.synOldSystem.order.SynOldSystemOrder;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.intergration.customer.user.UserInfoClient;
import com.jvv.openapi.intergration.synOldSystem.SynOldSystemClient;
import com.jvv.openapi.service.customer.user.requset.userinfo.UserInfoRequest;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/4/20
 * @time 9:48
 */
@OpenApiService(name = "addRecommend", desc = "补填推荐人接口",
                responseType = ResponseTypeEnum.SYN)
public class AddRecommendApiService extends AbstractApiService<UserInfoRequest, ApiResponse> {
	@Resource
	TokenUtils tokenUtils;
	@Resource
	UserInfoClient userInfoClient;
	@Resource
	SynOldSystemClient synOldSystemClient;
	
	@Override
	protected void doService (UserInfoRequest request, ApiResponse response) {
		String userId = tokenUtils.getUserIdByToken (request.getToken ());
		
		UserInfoOrder order = new UserInfoOrder ();
		order.setUserId (userId);
		order.setUserPhone (request.getPhone ());
		
		SimpleResult result = userInfoClient.addRecommend (order);
		
		
		//******************同步老系统***************************
		Map<String, String> map = new HashMap<> ();
		map.put ("user_id", userId);
		map.put ("referee", order.getUserPhone ());
		SynOldSystemOrder synOldSystemOrder = new SynOldSystemOrder ();
		synOldSystemOrder.setSynSerivceName ("/m/synSupplementRecom");
		synOldSystemOrder.setSynParam (map);
		synOldSystemClient.syn (synOldSystemOrder);
		//******************************************************
		
		response.setStatus (result.getStatus ().getCode ());
		response.setMessage (result.getMessage ());
		response.setDetailMessage (result.getMessage ());
		response.setCode (result.getCode ());
		
	}
}
