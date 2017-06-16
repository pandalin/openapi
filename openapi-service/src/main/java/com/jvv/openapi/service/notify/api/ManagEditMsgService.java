package com.jvv.openapi.service.notify.api;

import com.jvv.common.services.CommonResultCode;
import com.jvv.common.services.result.ResultCodeable;
import com.jvv.common.services.result.SimpleResult;
import com.jvv.facade.notify.order.MsgManageOrder;
import com.jvv.facade.notify.result.MsgManageResult;
import com.jvv.openapi.common.exception.ResultCode;
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
@OpenApiService(name = "manageEditMsg", desc = "编辑推送消息任务", responseType = ResponseTypeEnum.SYN)
public class ManagEditMsgService extends AbstractApiService<ManageAddMsgRequest , ApiResponse> {
	
	@Resource
	MsgManageClient client;
	
	@Override
	protected void doService (ManageAddMsgRequest request, ApiResponse response) {
		SimpleResult result = new SimpleResult ();
		if(request.getMsgId () == null || "".equals (request.getMsgId ())){
			result.setToFail (CommonResultCode.NULL_ARGUMENT_EXCEPTION, "msgId不能为空");
		}else {
			MsgManageResult msgManageResult = client.queryMsgManageById (request.getMsgId ());
			if(msgManageResult.getInfo () == null){
				result.setToFail (CommonResultCode.ILLEGAL_ARGUMENT_EXCEPTION,"该msgId不存在");
			}else {
				MsgManageOrder order = new MsgManageOrder ();
				BeanUtils.copyProperties (request, order);
				result = client.modifyMsgManage (order);
			}
		}
		
		response.injectResponse (result, response);
	}
}
