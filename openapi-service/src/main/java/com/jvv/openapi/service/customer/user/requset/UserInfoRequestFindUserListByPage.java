/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.requset;

import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.meta.OpenApiField;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author zhaoyk
 * @date
 * @time
 */
public class UserInfoRequestFindUserListByPage extends ApiRequest {
	
	@OpenApiField(desc = "用户Id")
	private String userId;
	
	/**
	 * 手机号
	 */
	@OpenApiField(desc = "电话")
	protected String userPhone;
	/**
	 * 昵称
	 */
	@OpenApiField(desc = "昵称")
	protected String nickname;
	
	@OpenApiField(desc = "起始索引")
	private Long start = 0L;
	
	@OpenApiField(desc = "页数")
	private Integer pageSize = 10;
	
	public String getUserId() {
		
		return userId;
	}
	
	public void setUserId(String userId) {
		
		this.userId = userId;
	}
	
	public Long getStart () {
		return start;
	}
	
	public void setStart (Long start) {
		this.start = start;
	}
	
	public String getUserPhone () {
		return userPhone;
	}
	
	public void setUserPhone (String userPhone) {
		this.userPhone = userPhone;
	}
	
	public String getNickname () {
		return nickname;
	}
	
	public void setNickname (String nickname) {
		this.nickname = nickname;
	}
	
	public Integer getPageSize () {
		return pageSize;
	}
	
	public void setPageSize (Integer pageSize) {
		this.pageSize = pageSize;
	}
}