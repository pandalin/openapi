/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.response.reminder;

import com.jvv.openapi.core.service.entity.AbstractResponseData;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date
 * @time
 */
public class UserReminderSettingResponseData extends AbstractResponseData {
	/**
	 * 用户id
	 */
	protected String userid;
	/**
	 * 系统消息通知无声模式  0: 未开启无声      1:开启无声
	 */
	protected Integer sysSilent;
	/**
	 * 夜间模式 0:不是夜间模式 1:夜间模式
	 */
	protected Integer nightMode;
	/**
	 * 退出接收任然接收消息通知
	 */
	protected Integer alwaysReceive;
	/**
	 * 点赞提醒  0:不提醒  1:提醒
	 */
	protected Integer praiseReminder;
	/**
	 * 好友申请提醒
	 */
	protected Integer applyFriendReminder;
	/**
	 * 陌生人消息提醒  0:不提醒  1:提醒
	 */
	protected Integer strangerReminder;
	/**
	 * 聊天消息无声模式  0: 未开启无声   1:开启无声
	 */
	protected Integer chatSilent;
	/**
	 * '约会提醒   0:关闭    1:打开'
	 */
	protected Integer appointmentReminder;
	
	public String getUserid () {
		return userid;
	}
	
	public void setUserid (String userid) {
		this.userid = userid;
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
