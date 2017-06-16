/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.requset;

import com.jvv.customer.facade.constants.validation.Add;
import com.jvv.customer.facade.constants.validation.Modify;
import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.meta.OpenApiField;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date
 * @time
 */
public class UserDealpwdErrorRequest extends ApiRequest{
	
	@NotNull
	@OpenApiField(desc = "token")
	private String token;
	
	@NotNull
	@OpenApiField(desc = "错误次数")
	private Long errCount;

	@OpenApiField(desc = "更新时间")
	private Date updateTime;
	
	public String getToken () {
		return token;
	}
	
	public void setToken (String token) {
		this.token = token;
	}
	
	public Long getErrCount () {
		return errCount;
	}
	
	public void setErrCount (Long errCount) {
		this.errCount = errCount;
	}
	
	public Date getUpdateTime () {
		return updateTime;
	}
	
	public void setUpdateTime (Date updateTime) {
		this.updateTime = updateTime;
	}
}
