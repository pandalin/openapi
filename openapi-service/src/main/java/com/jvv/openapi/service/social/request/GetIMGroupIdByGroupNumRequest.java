/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.request;

import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.meta.OpenApiField;

import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/5/23
 * @time 11:07
 */
public class GetIMGroupIdByGroupNumRequest extends ApiRequest {
	
	@NotNull
	@OpenApiField(desc = "自定义群号",constraint = "必填")
	private Long groupNum;
	
	public Long getGroupNum () {
		return groupNum;
	}
	
	public void setGroupNum (Long groupNum) {
		this.groupNum = groupNum;
	}
}
