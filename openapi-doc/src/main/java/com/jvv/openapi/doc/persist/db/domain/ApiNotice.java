/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */

/*
 * 修订记录：
 * zhike 2016年1月18日 下午1:41:59 创建
 */
package com.jvv.openapi.doc.persist.db.domain;

import java.util.Date;

/**
 *
 *
 * @author zhike@jinvovo.com
 * @data 2016年1月18日
 */
public class ApiNotice extends AbstractDomain {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 通知内容
	 */
	private String notice;
	
	/**
	 * 是否有效
	 */
	private int isEnabled;
	
	/**
	 * 创建时间
	 */
	private Date createDate;
	
	public String getNotice() {
		return this.notice;
	}
	
	public void setNotice(String notice) {
		this.notice = notice;
	}
	
	public int getIsEnabled() {
		return this.isEnabled;
	}
	
	public void setIsEnabled(int isEnabled) {
		this.isEnabled = isEnabled;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
