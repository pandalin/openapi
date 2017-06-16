/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.requset.loginfo;

import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.meta.OpenApiField;

import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/3/15
 * @time 19:46
 */
public class QueryUserLoginLogsRequest extends ApiRequest{
	
	@NotNull
	@OpenApiField(desc = "索引起始值", constraint = "必填")
	private Long start;
	
	@NotNull
	@OpenApiField(desc = "每页大小", constraint = "必填")
	private Integer pageSize;
	
	public Long getStart () {
		return start;
	}
	
	public void setStart (Long start) {
		this.start = start;
	}
	
	public Integer getPageSize () {
		return pageSize;
	}
	
	public void setPageSizze (Integer pageSizze) {
		this.pageSize = pageSizze;
	}
}
