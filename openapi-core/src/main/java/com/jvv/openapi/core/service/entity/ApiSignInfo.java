/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-27 10:51 创建
 *
 */
package com.jvv.openapi.core.service.entity;

import com.jvv.openapi.core.service.enums.SignTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiField;

import javax.validation.constraints.NotNull;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/27 10:51
 */

public abstract class ApiSignInfo extends ApiServiceInfo implements ISign {
	private static final long serialVersionUID = 7818566549720512606L;

	@NotNull
	@OpenApiField(desc = "签名类型", constraint = "必填")
	private String signType = SignTypeEnum.MD5.name();

	@NotNull
	@OpenApiField(desc = "签名", constraint = "必填")
	private String sign;


	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

}
