/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.response;

import com.jvv.openapi.core.service.entity.AbstractResponseData;

/**
 * Created by IntelliJ IDEA
 * 〈重置密码返回的新密码〉 <p>
 * 〈重置密码返回的新密码〉
 *
 * @author linxm
 * @date 2017/3/16
 * @time 9:25
 */
public class UserResetPwdResponseData extends AbstractResponseData {
	
	/**
	 * 新密码
	 */
	private String newPwd;
	
	public String getNewPwd () {
		return newPwd;
	}
	
	public void setNewPwd (String newPwd) {
		this.newPwd = newPwd;
	}
}
