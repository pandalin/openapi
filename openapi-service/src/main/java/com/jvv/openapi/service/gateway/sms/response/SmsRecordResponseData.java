/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.gateway.sms.response;

import com.jvv.openapi.core.service.entity.AbstractResponseData;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author linxm
 * @date 2017/3/22
 * @time 14:01
 */
public class SmsRecordResponseData extends AbstractResponseData {
	
	/**
	 * 时间段内发送短信总量
	 */
	private int totalCount;
	/**
	 * 时间段内发送短信成功总量
	 */
	private int sucCount;
	/**
	 * 时间段内发送短信失败总量
	 */
	private int failCount;
	/**
	 * 历史发送短信总量
	 */
	private int oldTotalCount;
	/**
	 * 历史发送短信成功总量
	 */
	private int oldSucCount;
	/**
	 * 历史发送短信失败总量
	 */
	private int oldFailCount;
	
	/**
	 * 渠道类型
	 */
	private String channelType;
	
	/**
	 * 查询的开始日期
	 */
	private String beginDate;
	/**
	 * 查询的结束日期
	 */
	private String endDate;
	
	public int getTotalCount () {
		return totalCount;
	}
	
	public void setTotalCount (int totalCount) {
		this.totalCount = totalCount;
	}
	
	public int getSucCount () {
		return sucCount;
	}
	
	public void setSucCount (int sucCount) {
		this.sucCount = sucCount;
	}
	
	public int getFailCount () {
		return failCount;
	}
	
	public void setFailCount (int failCount) {
		this.failCount = failCount;
	}
	
	public int getOldTotalCount () {
		return oldTotalCount;
	}
	
	public void setOldTotalCount (int oldTotalCount) {
		this.oldTotalCount = oldTotalCount;
	}
	
	public int getOldSucCount () {
		return oldSucCount;
	}
	
	public void setOldSucCount (int oldSucCount) {
		this.oldSucCount = oldSucCount;
	}
	
	public int getOldFailCount () {
		return oldFailCount;
	}
	
	public void setOldFailCount (int oldFailCount) {
		this.oldFailCount = oldFailCount;
	}
	
	public String getChannelType () {
		return channelType;
	}
	
	public void setChannelType (String channelType) {
		this.channelType = channelType;
	}
	
	public String getBeginDate () {
		return beginDate;
	}
	
	public void setBeginDate (String beginDate) {
		this.beginDate = beginDate;
	}
	
	public String getEndDate () {
		return endDate;
	}
	
	public void setEndDate (String endDate) {
		this.endDate = endDate;
	}
}
