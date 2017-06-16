package com.jvv.openapi.service.notify.api;

import com.jvv.common.services.result.SimpleResult;
import com.jvv.facade.notify.order.MsgManageOrder;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.intergration.notify.MsgManageClient;
import com.jvv.openapi.service.notify.request.ManageAddMsgRequest;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/6/12
 * @time 11:16
 */
@OpenApiService(name = "manageAddNewMsg", desc = "新增推送消息任务", responseType = ResponseTypeEnum.SYN)
public class ManageAddNewMsgService extends AbstractApiService<ManageAddMsgRequest , ApiResponse> {
	
	@Resource
	MsgManageClient client;
	
	@Override
	protected void doService (ManageAddMsgRequest request, ApiResponse response) {
		
		MsgManageOrder order = new MsgManageOrder ();
		BeanUtils.copyProperties (request, order);
		SimpleResult result = client.insertNewMsgManage (order);
		
		response.injectResponse (result, response);
	}
}
