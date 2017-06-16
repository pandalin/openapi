package com.jvv.openapi.intergration.notify;

import com.jvv.common.services.result.SimpleResult;
import com.jvv.facade.notify.api.MsgManageApi;
import com.jvv.facade.notify.order.MsgManageOrder;
import com.jvv.facade.notify.order.QueryMsgManageOrder;
import com.jvv.facade.notify.result.MsgManageResult;
import com.jvv.openapi.intergration.Client;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/6/12
 * @time 10:48
 */
@Component
public class MsgManageClient extends Client {
	
	/**
	 * 查询推送消息列表-后台管理
	 * */
	public MsgManageResult queryMsgManageList(QueryMsgManageOrder order){
		MsgManageApi api = getDubboClient (MsgManageApi.class);
		return api.queryMsgManageList (order);
	}
	
	/**
	 * 后台----通过MsgId获取推送信息
	 * @param msgId 信息编号
	 * */
	public MsgManageResult queryMsgManageById(String msgId){
		MsgManageApi api = getDubboClient (MsgManageApi.class);
		return api.queryMsgManageById (msgId);
	}
	
	
	/**
	 * 新增推送消息任务
	 *
	 * 推送方式：如果需要立即推送，就不传推送时间
	 *         否则需要传入推送时间给quartz定时器
	 * */
	public SimpleResult insertNewMsgManage(MsgManageOrder order){
		MsgManageApi api = getDubboClient (MsgManageApi.class);
		return api.insertNewMsgManage (order);
	}
	
	/**
	 * 修改推送消息
	 * */
	public SimpleResult modifyMsgManage(MsgManageOrder order){
		MsgManageApi api = getDubboClient (MsgManageApi.class);
		return api.modifyMsgManage (order);
	}
	
	/**
	 * 删除推送消息
	 * */
	public SimpleResult removeMsgManage(String msgId){
		MsgManageApi api = getDubboClient (MsgManageApi.class);
		return api.removeMsgManage (msgId);
	}
}
