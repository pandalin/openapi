/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-20 09:43 创建
 *
 */
package com.jvv.openapi.domain.base.domain;

import com.jvv.openapi.common.exception.ResultCode;
import com.jvv.openapi.facade.constants.enums.Status;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/20 9:43
 */

public abstract class OpenApiDomainBase implements Serializable {
	
	private int id;
	
	/**
	 * 请求订流水号
	 */
	private String serialNo;
	
	/**
	 * 客户端类型 CONSIGNOR(货主)/DRIVER(司机)
	 */
	private String clientType;
	
	/**
	 * 商户ID,后期作为平台使用时，接入商户必填
	 */
	private String partnerId;
	
	/**
	 * 处理结果
	 */
	private Status status;
	
	private ResultCode resultCode;
	
	/**
	 * 数据新增时间
	 */
	private Date rawAddTime;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getSerialNo() {
		return serialNo;
	}
	
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	
	public String getClientType() {
		return clientType;
	}
	
	public void setClientType(String clientType) {
		this.clientType = clientType;
	}
	
	public String getPartnerId() {
		return partnerId;
	}
	
	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public ResultCode getResultCode() {
		return resultCode;
	}
	
	public void setResultCode(ResultCode resultCode) {
		this.resultCode = resultCode;
	}

	public Date getRawAddTime () {
		return rawAddTime;
	}

	public void setRawAddTime (Date rawAddTime) {
		this.rawAddTime = rawAddTime;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
