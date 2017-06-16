/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.sensms.request;

import com.jvv.gateway.facade.constants.enums.SmsTempEnum;
import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.meta.OpenApiField;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author linxm
 * @date
 * @time
 */
public class SendSmsRequest extends ApiRequest{
	@NotNull
	@OpenApiField(desc = "jsonStr", constraint = "jsonStr不能为空")
	protected String jsonStr;
	
	public String getJsonStr () {
		return jsonStr;
	}
	
	public void setJsonStr (String jsonStr) {
		this.jsonStr = jsonStr;
	}
}
