package com.jvv.openapi.service.notify.api;

import com.jvv.common.services.result.SimpleResult;
import com.jvv.facade.notify.result.MsgUnreadRedDotResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.AbstractResponseData;
import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.intergration.notify.SystemMsgClient;
import com.jvv.openapi.service.notify.request.SimpleRequest;
import com.jvv.openapi.service.notify.response.SimpleResponseData;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/6/6
 * @time 16:37
 */
@OpenApiService(name = "getUnReadRedDot", desc = "获取首页未读消息红点标识状态", responseType = ResponseTypeEnum.SYN)
public class GetUnReadRedDotService extends AbstractApiService<SimpleRequest, ApiResponse> {
	
	@Resource
	TokenUtils tokenUtils;
	@Resource
	SystemMsgClient client;
	
	@Override
	protected void doService (SimpleRequest request, ApiResponse response) {
		
		String userId = tokenUtils.getUserIdByToken (request.getToken ());
		MsgUnreadRedDotResult result = client.getUnreadRedDot (userId);
		
		response.injectResponse (result, response);
		
		SimpleResponseData data = new SimpleResponseData ();
		Map<String,Boolean> map = new HashMap ();
		map.put ("redDotState",result.getRedDotStatus ());
		data.setInfo (map);
		
		response.setDatas (data);
		
	}
}
