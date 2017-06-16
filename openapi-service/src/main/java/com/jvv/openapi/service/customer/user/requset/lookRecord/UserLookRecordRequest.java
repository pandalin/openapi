/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.requset.lookRecord;

import com.jvv.customer.facade.constants.validation.Query;
import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.meta.OpenApiField;
import io.swagger.annotations.ApiModelProperty;

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
public class UserLookRecordRequest extends ApiRequest{
	/**
	 * 接受被查看的用户ID
	 * */
	@NotNull(groups = {Query.class}, message = "被查看的用户ID不能为空")
	@OpenApiField(desc = "用户userId",constraint = "必填")
	protected String token;
	/**
	 * 查看者的用户ID
	 * */
	@OpenApiField(desc = "查看者的userId")
	protected String fromUserId;
	
	@OpenApiField(desc = "查看类型")
	protected Long lookType;
	
	@OpenApiField(desc = "是否为新查看")
	protected Byte isNewlook;
	
	public Long getLookType () {
		return lookType;
	}
	
	public void setLookType (Long lookType) {
		this.lookType = lookType;
	}
	
	public Byte getIsNewlook () {
		return isNewlook;
	}
	
	public void setIsNewlook (Byte isNewlook) {
		this.isNewlook = isNewlook;
	}
	
	public String getToken () {
		return token;
	}
	
	public void setToken (String token) {
		this.token = token;
	}
	
	public String getFromUserId () {
		return fromUserId;
	}
	
	public void setFromUserId (String fromUserId) {
		this.fromUserId = fromUserId;
	}
}
