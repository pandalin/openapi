package com.jvv.openapi.service.notify.api;

import com.jvv.facade.notify.result.MsgManageResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.intergration.notify.MsgManageClient;
import com.jvv.openapi.service.notify.request.ManageMsgSimpleRequest;
import com.jvv.openapi.service.notify.response.SimpleResponseData;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/6/12
 * @time 10:34
 */
@OpenApiService(name = "manageQueryMsgById", desc = "后台根据id查询消息", responseType = ResponseTypeEnum.SYN)
public class ManageQueryMsgByIdService extends AbstractApiService<ManageMsgSimpleRequest,ApiResponse> {
	
	@Resource
	MsgManageClient client;
	
	@Override
	protected void doService (ManageMsgSimpleRequest request, ApiResponse response) {
		
		MsgManageResult result = client.queryMsgManageById (request.getMsgId ());
		
		response.injectResponse (result, response);
		SimpleResponseData data = new SimpleResponseData ();
		data.setInfo (result.getInfo ());
		
		response.setDatas (data);
		
	}
}
