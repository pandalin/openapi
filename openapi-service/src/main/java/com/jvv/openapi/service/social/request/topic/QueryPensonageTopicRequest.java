/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.request.topic;

import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.meta.OpenApiField;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/5/18
 * @time 14:43
 */
public class QueryPensonageTopicRequest extends ApiRequest {
	/**
	 * 用户id
	 */
	@NotNull
	@OpenApiField(desc = "token")
	protected String token;
	
	/**
	 * 查询类型
	 */
	@NotNull
	@OpenApiField(desc = "被查看的用户ID")
	protected String toUserId;
	
	/**
	 * 时间点
	 */
	@OpenApiField(desc = "时间点")
	protected Long date;
	
	/**
	 * 页码；1开始;必须大于0
	 *
	 */
	@NotNull
	@OpenApiField(desc = "当前页")
	protected Integer pageNo;
	
	/**
	 * 每页大小；必须大于0
	 *
	 */
	@NotNull
	@OpenApiField(desc = "每页最大数")
	protected Integer pageSize;
	
	public String getToken () {
		return token;
	}
	
	public void setToken (String token) {
		this.token = token;
	}
	
	public String getToUserId () {
		return toUserId;
	}
	
	public void setToUserId (String toUserId) {
		this.toUserId = toUserId;
	}
	
	public Long getDate () {
		return date;
	}
	
	public void setDate (Long date) {
		this.date = date;
	}
	
	public Integer getPageNo () {
		return pageNo;
	}
	
	public void setPageNo (Integer pageNo) {
		this.pageNo = pageNo;
	}
	
	public Integer getPageSize () {
		return pageSize;
	}
	
	public void setPageSize (Integer pageSize) {
		this.pageSize = pageSize;
	}
}
