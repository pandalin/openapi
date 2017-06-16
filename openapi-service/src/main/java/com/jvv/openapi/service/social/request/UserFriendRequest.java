/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.request;

import com.jvv.common.services.order.validation.Query;
import com.jvv.facade.constants.enums.UserFriendTypeEnum;
import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.meta.OpenApiField;
import com.jvv.openapi.core.service.meta.OpenApiService;

import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/4/7
 * @time 11:36
 */
public class UserFriendRequest extends ApiRequest {
	@NotNull
	@OpenApiField(desc = "token" ,constraint = "必填")
	private String token;
	
	@OpenApiField(desc = "关键字")
	private String keyWord;
		
	@OpenApiField(desc = "查询好友列表时，更新时间")
	private Long updateTime;
	
	@OpenApiField(desc = "当前页数")
	private Integer pageNo;
	
	@OpenApiField(desc = "每页数量")
	private Integer pageSize;
	
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
	
	public String getToken () {
		return token;
	}
	
	public void setToken (String token) {
		this.token = token;
	}
	
	public String getKeyWord () {
		return keyWord;
	}
	
	public void setKeyWord (String keyWord) {
		this.keyWord = keyWord;
	}
	
	public Long getUpdateTime () {
		return updateTime;
	}
	
	public void setUpdateTime (Long updateTime) {
		this.updateTime = updateTime;
	}
}
