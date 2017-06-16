/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-22 22:25 创建
 *
 */
package com.jvv.openapi.core.service.entity;

import com.jvv.openapi.core.exception.OrderCheckException;
import com.jvv.openapi.core.service.meta.OpenApiField;

import javax.validation.constraints.NotNull;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/22 22:25
 */

public class ApiRequest extends ApiSignInfo {

	@NotNull
	@OpenApiField(desc = "设备", constraint = "必填")
	private String device;

	@NotNull
	@OpenApiField(desc = "设备ID", constraint = "必填")
	private String deviceId;

	@NotNull
	@OpenApiField(desc = "设备系统", constraint = "必填，ANDROID/IOS/PC")
	private String system;

	@NotNull
	@OpenApiField(desc = "设备系统版本", constraint = "必填")
	private String systemVersion;

	@NotNull
	@OpenApiField(desc = "发行版本", constraint = "必填")
	private String buildVersion;


	@OpenApiField(desc = "用户地址", constraint = "选填")
	private String address;

	@OpenApiField(desc = "定位", constraint = "选填，经纬度")
	private String location;





	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getSystemVersion() {
		return systemVersion;
	}

	public void setSystemVersion(String systemVersion) {
		this.systemVersion = systemVersion;
	}

	public String getBuildVersion() {
		return buildVersion;
	}

	public void setBuildVersion(String buildVersion) {
		this.buildVersion = buildVersion;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * 参数校验,校验失败请抛出OrderCheckException
	 */
	public void check() throws OrderCheckException {

	}
}
