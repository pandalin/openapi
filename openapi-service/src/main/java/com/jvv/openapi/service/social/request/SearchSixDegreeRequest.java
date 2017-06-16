/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.request;

import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.meta.OpenApiField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/4/19
 * @time 11:05
 */
public class SearchSixDegreeRequest extends ApiRequest {
	
	/**
	 * 用户ID
	 */
	@NotBlank
	@OpenApiField(desc = "用户ID")
	protected String token;
	
	/**
	 * 查询上下几度
	 * 上几度为：+x
	 * 下几度：-x
	 */
	@NotNull
	@OpenApiField(desc = "父级度数")
	protected Integer parentLevel;
	
	/**
	 * 勾选时间限定：flag=true
	 * 没有勾选 ：  flag=false
	 * 如果不传，默认是true，勾选状态
	 */
	@OpenApiField(desc = "勾选时间标识")
	protected Boolean flag;
	
	@NotNull
	@OpenApiField(desc = "分页参数，当前页")
	protected int pageNo;
	
	@NotNull
	@OpenApiField(desc = "分页参数，每页条数")
	protected int pageSize;
	
	public String getToken () {
		return token;
	}
	
	public void setToken (String token) {
		this.token = token;
	}
	
	public Integer getParentLevel () {
		return parentLevel;
	}
	
	public void setParentLevel (Integer parentLevel) {
		this.parentLevel = parentLevel;
	}
	
	public Boolean getFlag () {
		return flag;
	}
	
	public void setFlag (Boolean flag) {
		this.flag = flag;
	}
	
	public int getPageNo () {
		return pageNo;
	}
	
	public void setPageNo (int pageNo) {
		this.pageNo = pageNo;
	}
	
	public int getPageSize () {
		return pageSize;
	}
	
	public void setPageSize (int pageSize) {
		this.pageSize = pageSize;
	}
}
