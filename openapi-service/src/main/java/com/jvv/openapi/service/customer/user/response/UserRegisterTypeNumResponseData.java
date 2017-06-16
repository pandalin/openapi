/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.response;

import com.jvv.openapi.core.service.entity.AbstractResponseData;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author lxb
 * @date 2017/3/17
 * @time 17:10
 */
public class UserRegisterTypeNumResponseData extends AbstractResponseData {
	/**
	 * 空注册类型用户数量
	 */
	protected Integer nullType;
	/**
	 * app注册用户数量
	 */
	protected Integer app;
	/**
	 * 推广注册用户数量
	 */
	protected Integer poplarize;//POPLARIZE
	/**
	 * 其他注册渠道用户的数量
	 */
	protected Integer other;
	
	/**
	 * 注册总数量
	 */
	protected Integer num;
	
	public Integer getNullType () {
		return nullType;
	}
	
	public void setNullType (Integer nullType) {
		this.nullType = nullType;
	}
	
	public Integer getApp () {
		return app;
	}
	
	public void setApp (Integer app) {
		this.app = app;
	}
	
	public Integer getPoplarize () {
		return poplarize;
	}
	
	public void setPoplarize (Integer poplarize) {
		this.poplarize = poplarize;
	}
	
	public Integer getOther () {
		return other;
	}
	
	public void setOther (Integer other) {
		this.other = other;
	}
	
	public Integer getNum () {
		return num;
	}
	
	public void setNum (Integer num) {
		this.num = num;
	}
}
