package com.jvv.openapi.service.notify.api;

import com.jvv.common.services.CommonResultCode;
import com.jvv.common.services.result.SimpleResult;
import com.jvv.facade.notify.order.MsgManageOrder;
import com.jvv.facade.notify.result.MsgManageResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.intergration.notify.MsgManageClient;
import com.jvv.openapi.service.notify.request.ManageAddMsgRequest;
import com.jvv.openapi.service.notify.request.ManageMsgSimpleRequest;
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
@OpenApiService(name = "manageRemoveMsg", desc = "删除推送消息任务", responseType = ResponseTypeEnum.SYN)
public class ManagRemoveMsgService extends AbstractApiService<ManageMsgSimpleRequest, ApiResponse> {
	
	@Resource
	MsgManageClient client;
	
	@Override
	protected void doService (ManageMsgSimpleRequest request, ApiResponse response) {
		SimpleResult result = new SimpleResult ();
		MsgManageResult msgManageResult = client.queryMsgManageById (request.getMsgId ());
		if(msgManageResult.getInfo () == null){
			result.setToFail (CommonResultCode.ILLEGAL_ARGUMENT_EXCEPTION,"该msgId不存在");
		}else {
			result = client.removeMsgManage (request.getMsgId ());
		}
		response.injectResponse (result, response);
	}
}
