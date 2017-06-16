/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.requset.locate;

import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.meta.OpenApiField;

import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA
 * 〈地理位置请求参数，经纬度在ApiRequest的location中〉 <p>
 * 〈地理位置请求参数〉
 *
 * @author linxm
 * @date 2017/3/20
 * @time 11:02
 */
public class UserLocateRequest extends ApiRequest {
	
	@NotNull
	@OpenApiField(desc = "用户ID", constraint = "必填")
	private String token;
	
	/**
	 * 城市代码
	 */
	@OpenApiField(desc = "城市代码", constraint = "非必填")
	private String cityCode;
	/**
	 * 城市名称
	 */
	@OpenApiField(desc = "城市名称", constraint = "非必填")
	private String cityName;
	/**
	 * 区县代码
	 */
	@OpenApiField(desc = "区县代码", constraint = "非必填")
	private String countyCode;
	/**
	 * 区县名称
	 */
	@OpenApiField(desc = "区县名称", constraint = "非必填")
	private String countyName;

	@OpenApiField(desc = "省份", constraint = "非必填")
	private String province;
	
	public String getToken () {
		return token;
	}
	
	public void setToken (String token) {
		this.token = token;
	}
	
	public String getCityCode () {
		return cityCode;
	}
	
	public void setCityCode (String cityCode) {
		this.cityCode = cityCode;
	}
	
	public String getCityName () {
		return cityName;
	}
	
	public void setCityName (String cityName) {
		this.cityName = cityName;
	}
	
	public String getCountyCode () {
		return countyCode;
	}
	
	public void setCountyCode (String countyCode) {
		this.countyCode = countyCode;
	}
	
	public String getCountyName () {
		return countyName;
	}
	
	public void setCountyName (String countyName) {
		this.countyName = countyName;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
}
