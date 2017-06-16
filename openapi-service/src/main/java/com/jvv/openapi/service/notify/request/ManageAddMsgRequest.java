package com.jvv.openapi.service.notify.request;

import com.jvv.common.services.order.validation.Add;
import com.jvv.common.services.order.validation.Modify;
import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.meta.OpenApiField;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/6/12
 * @time 11:18
 */
public class ManageAddMsgRequest extends ApiRequest {
	
	
	@OpenApiField(desc = "消息id")
	protected String msgId;

	@NotNull
	@OpenApiField(desc = "消息类型 ( 1:系统通知 2:消息提醒)")
	protected Long msgType;
	
	@NotNull
	@OpenApiField(desc = "是否推送 (false:不推送 true:推送)")
	protected Boolean isPush;
	
	@NotNull
	@OpenApiField(desc = "推送内容")
	protected String content;
	
	@OpenApiField(desc = "推送时间")
	protected Date sendTime;

	@OpenApiField(desc = "目标用户 (1:VIP  3:普通用户 4:全部)")
	protected Long toUser;
	
	@OpenApiField(desc = "接收区域")
	protected String areaRange;
	
	@OpenApiField(desc = "跳转地址")
	protected String toUrl;
	
	@OpenApiField(desc = "备注")
	protected String msgRemark;
	
	@OpenApiField(desc = "主标题")
	protected String title;
	
	@OpenApiField(desc = "副标题")
	protected String attachedTitle;
	
	@OpenApiField(desc = "主图")
	protected String image;
	
	@OpenApiField(desc = "附加消息")
	protected String attachedMessage;
	
	@OpenApiField(desc = "推送给单个用户(userId)")
	protected String receiveUser;
	
	public String getMsgId () {
		return msgId;
	}
	
	public void setMsgId (String msgId) {
		this.msgId = msgId;
	}
	
	public Long getMsgType () {
		return msgType;
	}
	
	public void setMsgType (Long msgType) {
		this.msgType = msgType;
	}
	
	public Boolean getPush () {
		return isPush;
	}
	
	public void setPush (Boolean push) {
		isPush = push;
	}
	
	public String getContent () {
		return content;
	}
	
	public void setContent (String content) {
		this.content = content;
	}
	
	public Date getSendTime () {
		return sendTime;
	}
	
	public void setSendTime (Date sendTime) {
		this.sendTime = sendTime;
	}
	
	public Long getToUser () {
		return toUser;
	}
	
	public void setToUser (Long toUser) {
		this.toUser = toUser;
	}
	
	public String getAreaRange () {
		return areaRange;
	}
	
	public void setAreaRange (String areaRange) {
		this.areaRange = areaRange;
	}
	
	public String getToUrl () {
		return toUrl;
	}
	
	public void setToUrl (String toUrl) {
		this.toUrl = toUrl;
	}
	
	public String getMsgRemark () {
		return msgRemark;
	}
	
	public void setMsgRemark (String msgRemark) {
		this.msgRemark = msgRemark;
	}
	
	public String getTitle () {
		return title;
	}
	
	public void setTitle (String title) {
		this.title = title;
	}
	
	public String getAttachedTitle () {
		return attachedTitle;
	}
	
	public void setAttachedTitle (String attachedTitle) {
		this.attachedTitle = attachedTitle;
	}
	
	public String getImage () {
		return image;
	}
	
	public void setImage (String image) {
		this.image = image;
	}
	
	public String getAttachedMessage () {
		return attachedMessage;
	}
	
	public void setAttachedMessage (String attachedMessage) {
		this.attachedMessage = attachedMessage;
	}
	
	public String getReceiveUser () {
		return receiveUser;
	}
	
	public void setReceiveUser (String receiveUser) {
		this.receiveUser = receiveUser;
	}
}
