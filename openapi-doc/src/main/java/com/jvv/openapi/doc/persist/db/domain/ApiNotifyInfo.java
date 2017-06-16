/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */

/*
 * 修订记录：
 * zhike 2016年1月12日 下午4:52:41 创建
 */
package com.jvv.openapi.doc.persist.db.domain;

/**
 *
 *
 * @author zhike@jinvovo.com
 * @data   2016年1月12日
 */
public class ApiNotifyInfo extends AbstractDomain{

	private static final long serialVersionUID = 1L;

	private String orderNo;

	private String notifyInfo;

	public String getOrderNo() {
		return this.orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getNotifyInfo() {
		return this.notifyInfo;
	}

	public void setNotifyInfo(String notifyInfo) {
		this.notifyInfo = notifyInfo;
	}
}

    