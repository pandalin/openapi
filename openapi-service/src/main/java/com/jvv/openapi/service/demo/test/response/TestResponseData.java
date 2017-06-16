/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-27 11:15 创建
 *
 */
package com.jvv.openapi.service.demo.test.response;

import com.jvv.openapi.core.service.entity.AbstractResponseData;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/27 11:15
 */

public class TestResponseData extends AbstractResponseData {
	/**
	 * 用户ID
	 */
	protected String userId;
	/**
	 * 用户名
	 */
	protected String username;
	/**
	 * 商户状态:<br/>
	 * NORMAL:正常<br/>
	 * CHECKING:审核中 <br/>
	 * FROZEN:冻结<br/>
	 * EXPIRED:已到期<br/>
	 * DELIST:已解约
	 */
	protected String status;
	/**
	 * 联系人电话
	 */
	protected String phone;
	/**
	 * 联系人邮箱
	 */
	protected String email;

	private  int age = 12;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
