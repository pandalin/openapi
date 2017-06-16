package com.jvv.openapi.service.notify.api;

import com.jvv.facade.notify.order.QueryMsgManageOrder;
import com.jvv.facade.notify.order.SystemNewsOrder;
import com.jvv.facade.notify.result.MsgManageResult;
import com.jvv.facade.notify.result.SystemNewsResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.intergration.notify.MsgManageClient;
import com.jvv.openapi.intergration.notify.SystemMsgClient;
import com.jvv.openapi.service.notify.request.ManageQueryMsgListRequest;
import com.jvv.openapi.service.notify.request.QueryUserNewsListRequest;
import com.jvv.openapi.service.notify.response.SimpleResponseData;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/6/6
 * @time 16:37
 */
@OpenApiService(name = "manageQueryMsgList", desc = "后台查询消息列表", responseType = ResponseTypeEnum.SYN)
public class ManageQueryMsgListService extends AbstractApiService<ManageQueryMsgListRequest, ApiResponse> {
	
	@Resource
	MsgManageClient client;
	
	@Override
	protected void doService (ManageQueryMsgListRequest request, ApiResponse response) {
		
		QueryMsgManageOrder order = new QueryMsgManageOrder ();
		
		BeanUtils.copyProperties (request,order);
		
		MsgManageResult result = client.queryMsgManageList (order);
			
		response.injectResponse (result, response);
		
		SimpleResponseData data = new SimpleResponseData ();
		data.setList (result.getList ());
		data.setCount (result.getCount ());
		response.setDatas (data);
		
	}
}
