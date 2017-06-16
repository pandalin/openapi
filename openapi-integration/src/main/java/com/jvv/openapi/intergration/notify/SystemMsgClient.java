package com.jvv.openapi.intergration.notify;

import com.jvv.facade.notify.api.SystemMsgApi;
import com.jvv.facade.notify.order.SystemNewsOrder;
import com.jvv.facade.notify.result.MsgUnreadRedDotResult;
import com.jvv.facade.notify.result.SystemMsgUnreadRedDotResult;
import com.jvv.facade.notify.result.SystemNewsResult;
import com.jvv.openapi.intergration.Client;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/6/6
 * @time 15:57
 */
@Component
public class SystemMsgClient extends Client {
	/**
	 * 获取首页未读消息红点标识
	 * */
	public MsgUnreadRedDotResult getUnreadRedDot(String userId){
		SystemMsgApi api = getDubboClient (SystemMsgApi.class);
		return api.getUnreadRedDot (userId);
	}
	
	/**
	 * 获取系统消息主页未读红点
	 * */
	public SystemMsgUnreadRedDotResult getSystemMsgUnreadRedDot(String userId){
		SystemMsgApi api = getDubboClient (SystemMsgApi.class);
		return api.getSystemMsgUnreadRedDot (userId);
	}
	
	/**
	 * 获取消息列表（系统消息、通知消息）
	 * */
	public SystemNewsResult queryNewsList(SystemNewsOrder order){
		SystemMsgApi api = getDubboClient (SystemMsgApi.class);
		return api.queryNewsList (order);
	}
}
