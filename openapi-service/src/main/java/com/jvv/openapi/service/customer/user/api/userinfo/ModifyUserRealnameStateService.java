package com.jvv.openapi.service.customer.user.api.userinfo;

import com.jvv.customer.facade.base.result.SimpleResult;
import com.jvv.customer.facade.user.order.UserInfoOrder;
import com.jvv.facade.notify.order.MsgManageOrder;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.intergration.customer.user.UserInfoClient;
import com.jvv.openapi.intergration.notify.MsgManageClient;
import com.jvv.openapi.service.customer.user.requset.userinfo.UserAuthenticationStateRequest;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/6/12
 * @time 15:33
 */
@OpenApiService(name = "modifyUserRealnameState", desc = "修改用户实名状态服务", responseType = ResponseTypeEnum.SYN)
public class ModifyUserRealnameStateService extends AbstractApiService<UserAuthenticationStateRequest,ApiResponse> {
	@Resource
	UserInfoClient client;
	@Resource
	MsgManageClient msgManageClient;
	
	@Override
	protected void doService (UserAuthenticationStateRequest request, ApiResponse response) {
		
		UserInfoOrder order = new UserInfoOrder ();
		order.setUserId (request.getUserId ());
		order.setAuthenticationState (request.getAuthenticationState ());
		SimpleResult result = client.modifyUserInfo (order);
		
		//******************同步老系统***************************
		if(order.getAuthenticationState ().intValue () == 1){
			MsgManageOrder msgOrder = new MsgManageOrder ();
			msgOrder.setReceiveUser (order.getUserId ());
			msgOrder.setContent ("恭喜您实名认证成功！");
			msgOrder.setMsgType (1L);
			msgOrder.setPush (false);
			
			msgManageClient.insertNewMsgManage (msgOrder);
		}
		//******************************************************
		
		response.setStatus (result.getStatus ().getCode ());
		response.setMessage (result.getMessage ());
		response.setDetailMessage (result.getMessage ());
		response.setCode (result.getCode ());
	}
}
