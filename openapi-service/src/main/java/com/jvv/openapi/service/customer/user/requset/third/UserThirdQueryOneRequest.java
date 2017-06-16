/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.requset.third;

import com.jvv.customer.facade.constants.validation.Add;
import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.meta.OpenApiField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author lxb
 * @date 2017/3/15
 * @time 10:06
 */
public class UserThirdQueryOneRequest extends ApiRequest {
	@NotNull
	@OpenApiField(desc = "三方账户Id", constraint = "必填")
	protected String openid;
	
	@NotNull
	@OpenApiField(desc = "三方账户类型", constraint = "必填")
	protected String thirdType;
	
	@OpenApiField(desc = "多微信公众平台时用户的唯一标识区分(记录的openid)", constraint = "非必填")
	protected String unionid;
	
	public String getOpenid () {
		return openid;
	}
	
	public void setOpenid (String openid) {
		this.openid = openid;
	}
	
	public String getThirdType () {
		return thirdType;
	}
	
	public void setThirdType (String thirdType) {
		this.thirdType = thirdType;
	}
	
	public String getUnionid () {
		return unionid;
	}

	public void setUnionid (String unionid) {
		this.unionid = unionid;
	}
}
