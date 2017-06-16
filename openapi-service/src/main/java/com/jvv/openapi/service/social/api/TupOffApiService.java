/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.api;

import com.jvv.common.lang.StringUtils;
import com.jvv.common.lang.beans.Copier;
import com.jvv.common.services.result.SimpleResult;
import com.jvv.facade.social.friend.order.UserTipOffOrder;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.intergration.customer.user.UserTupOffClient;
import com.jvv.openapi.service.social.request.TupOffRequest;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/4/25
 * @time 10:14
 */
@OpenApiService(name = "userTupOff", desc = "用户举报", responseType = ResponseTypeEnum.SYN)
public class TupOffApiService extends AbstractApiService<TupOffRequest,ApiResponse> {
	
	@Resource
	UserTupOffClient client;
	@Resource
	TokenUtils tokenUtils;
	
	@Override
	protected void doService (TupOffRequest request, ApiResponse response) {
		
		String userId = tokenUtils.getUserIdByToken (request.getToken ());
		UserTipOffOrder order = new UserTipOffOrder ();
		
		if (StringUtils.isNotEmpty(request.getImgList ())) {
			List<String> list = StringUtils.stringSplitToList(request.getImgList (),",");
			order.setImgList (list);
		}
		
		Copier.copy (request,order);
		SimpleResult result = client.addUserTupOffService (order);
		
		response.setStatus (result.getStatus ().getCode ());
		response.setMessage (result.getMessage ());
		response.setDetailMessage (result.getDescription ());
		response.setCode (result.getCode ());
	}
}
