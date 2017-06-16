/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.requset.reminder;

import com.jvv.customer.facade.constants.validation.Add;
import com.jvv.customer.facade.constants.validation.Modify;
import com.jvv.customer.facade.constants.validation.Query;
import com.jvv.customer.facade.constants.validation.Remove;
import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.meta.OpenApiField;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date
 * @time
 */
public class UserReminderSettingRequest extends ApiRequest{
	/**
	 * 用户id
	 */
	@NotBlank(groups = {Add.class, Remove.class, Query.class, Modify.class}, message = "token")
	@OpenApiField(desc = "用户ID", constraint = "必填")
	protected String token;
	/**
	 * 系统消息通知无声模式  0: 未开启无声      1:开启无声
	 */
	@OpenApiField(desc = "无声模式")
	protected Integer sysSilent;
	/**
	 * 夜间模式 0:不是夜间模式 1:夜间模式
	 */
	@OpenApiField(desc = "夜间模式")
	protected Integer nightMode;
	/**
	 * 退出接收任然接收消息通知
	 */
	@OpenApiField(desc = "推出仍然接收消息通知")
	protected Integer alwaysReceive;
	/**
	 * 点赞提醒  0:不提醒  1:提醒
	 */
	@OpenApiField(desc = "点赞提醒")
	protected Integer praiseReminder;
	/**
	 * 好友申请提醒
	 */
	@OpenApiField(desc = "好友申请")
	protected Integer applyFriendReminder;
	/**
	 * 陌生人消息提醒  0:不提醒  1:提醒
	 */
	@OpenApiField(desc = "陌生人消息提醒")
	protected Integer strangerReminder;
	/**
	 * 聊天消息无声模式  0: 未开启无声   1:开启无声
	 */
	@OpenApiField(desc = "无声模式")
	protected Integer chatSilent;
	
	/**
	 * '约会提醒   0:关闭    1:打开'
	 */
	//appointment_reminder
	@OpenApiField(desc = "约会提醒")
	protected Integer appointmentReminder;
	
	public String getToken () {
		return token;
	}
	
	public void setToken (String token) {
		this.token = token;
	}
	
	public Integer getSysSilent () {
		return sysSilent;
	}
	
	public void setSysSilent (Integer sysSilent) {
		this.sysSilent = sysSilent;
	}
	
	public Integer getNightMode () {
		return nightMode;
	}
	
	public void setNightMode (Integer nightMode) {
		this.nightMode = nightMode;
	}
	
	public Integer getAlwaysReceive () {
		return alwaysReceive;
	}
	
	public void setAlwaysReceive (Integer alwaysReceive) {
		this.alwaysReceive = alwaysReceive;
	}
	
	public Integer getPraiseReminder () {
		return praiseReminder;
	}
	
	public void setPraiseReminder (Integer praiseReminder) {
		this.praiseReminder = praiseReminder;
	}
	
	public Integer getApplyFriendReminder () {
		return applyFriendReminder;
	}
	
	public void setApplyFriendReminder (Integer applyFriendReminder) {
		this.applyFriendReminder = applyFriendReminder;
	}
	
	public Integer getStrangerReminder () {
		return strangerReminder;
	}
	
	public void setStrangerReminder (Integer strangerReminder) {
		this.strangerReminder = strangerReminder;
	}
	
	public Integer getChatSilent () {
		return chatSilent;
	}
	
	public void setChatSilent (Integer chatSilent) {
		this.chatSilent = chatSilent;
	}
	
	public Integer getAppointmentReminder () {
		return appointmentReminder;
	}
	
	public void setAppointmentReminder (Integer appointmentReminder) {
		this.appointmentReminder = appointmentReminder;
	}
}
