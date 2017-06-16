/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.requset;

import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.meta.OpenApiField;

import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date
 * @time
 */
public class VipUserRankRequest extends ApiRequest{
	
	@OpenApiField(desc = "用户ID")
	private String token;
	/**
	 * 查询时间区间(用于获取榜单)
	 * @author liujf
	 * @date  17/3/10
	 * */
	@NotNull
	@OpenApiField(desc = "分页起始索引")
	protected Long start;
	
	@NotNull
	@OpenApiField(desc = "每页总数")
	protected Integer pageSize;
	
	@NotNull
	@OpenApiField(desc = "查询起始时间")
	protected String startTime;
	
	@NotNull
	@OpenApiField(desc = "结束时间")
	protected String endTime;
	
	public String getStartTime () {
		return startTime;
	}
	
	public void setStartTime (String startTime) {
		this.startTime = startTime;
	}
	
	public String getEndTime () {
		return endTime;
	}
	
	public void setEndTime (String endTime) {
		this.endTime = endTime;
	}
	
	public String getToken () {
		return token;
	}
	
	public void setToken (String token) {
		this.token = token;
	}
	
	public Long getStart () {
		return start;
	}
	
	public void setStart (Long start) {
		this.start = start;
	}
	
	public Integer getPageSize () {
		return pageSize;
	}
	
	public void setPageSize (Integer pageSize) {
		this.pageSize = pageSize;
	}
}
