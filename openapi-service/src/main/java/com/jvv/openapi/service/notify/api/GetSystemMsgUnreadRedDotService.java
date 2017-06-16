package com.jvv.openapi.service.notify.api;

import com.jvv.facade.notify.result.SystemMsgUnreadRedDotResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.intergration.notify.SystemMsgClient;
import com.jvv.openapi.service.notify.request.SimpleRequest;
import com.jvv.openapi.service.notify.response.SimpleResponseData;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/6/6
 * @time 18:25
 */
@OpenApiService(name = "getSystemMsgUnreadRedDot", desc = "获取系统消息页面未读消息红点标识状态", responseType = ResponseTypeEnum.SYN)
public class GetSystemMsgUnreadRedDotService extends AbstractApiService<SimpleRequest,ApiResponse> {
	
	@Resource
	TokenUtils tokenUtils;
	@Resource
	SystemMsgClient client;
	
	@Override
	protected void doService (SimpleRequest request, ApiResponse response) {
		
		
		String userId = tokenUtils.getUserIdByToken (request.getToken ());
		SystemMsgUnreadRedDotResult result = client.getSystemMsgUnreadRedDot (userId);
		
		response.injectResponse (result, response);
		
		SimpleResponseData data = new SimpleResponseData ();
		data.setInfo (result.getInfo ());
		
		response.setDatas (data);
		
	}
}
