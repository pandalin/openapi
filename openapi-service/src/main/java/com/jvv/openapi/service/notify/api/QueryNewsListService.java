package com.jvv.openapi.service.notify.api;

import com.jvv.facade.notify.order.SystemNewsOrder;
import com.jvv.facade.notify.result.MsgUnreadRedDotResult;
import com.jvv.facade.notify.result.SystemNewsResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.intergration.notify.SystemMsgClient;
import com.jvv.openapi.service.notify.request.QueryUserNewsListRequest;
import com.jvv.openapi.service.notify.request.SimpleRequest;
import com.jvv.openapi.service.notify.response.SimpleResponseData;
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
 * @date 2017/6/6
 * @time 16:37
 */
@OpenApiService(name = "queryUserNewsList", desc = "获取用户消息列表", responseType = ResponseTypeEnum.SYN)
public class QueryNewsListService extends AbstractApiService<QueryUserNewsListRequest, ApiResponse> {
	
	@Resource
	TokenUtils tokenUtils;
	@Resource
	SystemMsgClient client;
	
	@Override
	protected void doService (QueryUserNewsListRequest request, ApiResponse response) {
		
		String userId = tokenUtils.getUserIdByToken (request.getToken ());
		SystemNewsOrder order = new SystemNewsOrder ();
		
		BeanUtils.copyProperties (request,order);
		order.setUserId (userId);
		
		SystemNewsResult result = client.queryNewsList (order);
			
		response.injectResponse (result, response);
		
		SimpleResponseData data = new SimpleResponseData ();
		data.setList (result.getList ());
		
		response.setDatas (data);
		
	}
}
