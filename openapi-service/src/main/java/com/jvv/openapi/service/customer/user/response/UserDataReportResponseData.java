/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.response;

import com.jvv.customer.facade.user.info.UserDataReportInfo;
import com.jvv.customer.facade.user.info.UserInfoInfo;
import com.jvv.openapi.core.service.entity.AbstractResponseData;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author zhaoyk
 * @date
 * @time
 */
public class UserDataReportResponseData extends AbstractResponseData {
	//========== properties ==========
	/**
	 * 统计时间
	 */
	protected Date countDate;
	/**
	 * 当日活跃人数
	 */
	protected Long activityCountDay;
	/**
	 * 当日实名认证人数
	 */
	protected Long realnameCountDay;
	/**
	 * 当日总注册人数
	 */
	protected Long registerCountDay;
	/**
	 * 平台总用户人数
	 */
	protected Long userCount;
	/**
	 * 平台实名认证总人数
	 */
	protected Long realnameCount;
	
	protected List<UserDataReportInfo> userDataReports;
	
	
	//========== getters and setters ==========
	/**
	 * 返回 统计时间
	 */
	public Date getCountDate() {
		return countDate;
	}
	
	/**
	 * 设置 统计时间
	 */
	public void setCountDate(Date countDate) {
		this.countDate = countDate;
	}
	/**
	 * 返回 当日活跃人数
	 */
	public Long getActivityCountDay() {
		return activityCountDay;
	}
	
	/**
	 * 设置 当日活跃人数
	 */
	public void setActivityCountDay(Long activityCountDay) {
		this.activityCountDay = activityCountDay;
	}
	/**
	 * 返回 当日实名认证人数
	 */
	public Long getRealnameCountDay() {
		return realnameCountDay;
	}
	
	/**
	 * 设置 当日实名认证人数
	 */
	public void setRealnameCountDay(Long realnameCountDay) {
		this.realnameCountDay = realnameCountDay;
	}
	/**
	 * 返回 当日总注册人数
	 */
	public Long getRegisterCountDay() {
		return registerCountDay;
	}
	
	/**
	 * 设置 当日总注册人数
	 */
	public void setRegisterCountDay(Long registerCountDay) {
		this.registerCountDay = registerCountDay;
	}
	/**
	 * 返回 平台总用户人数
	 */
	public Long getUserCount() {
		return userCount;
	}
	
	/**
	 * 设置 平台总用户人数
	 */
	public void setUserCount(Long userCount) {
		this.userCount = userCount;
	}
	/**
	 * 返回 平台实名认证总人数
	 */
	public Long getRealnameCount() {
		return realnameCount;
	}
	
	/**
	 * 设置 平台实名认证总人数
	 */
	public void setRealnameCount(Long realnameCount) {
		this.realnameCount = realnameCount;
	}
	
	public List<UserDataReportInfo> getUserDataReports () {
		return userDataReports;
	}
	
	public void setUserDataReportInfo (List<UserDataReportInfo> userDataReports) {
		this.userDataReports = userDataReports;
	}
}
