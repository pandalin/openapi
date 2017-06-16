/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */

/*
 * 修订记录：
 * zhike 2015年9月16日 下午1:04:56 创建
 */
package com.jvv.openapi.doc.persist.db.domain;

import org.hibernate.validator.constraints.NotBlank;

/**
 *
 *
 * @author zhike@jinvovo.com
 *
 */
public class ApiUser extends AbstractDomain {
	private static final long serialVersionUID = 1L;

	@NotBlank
	private String userName;

	@NotBlank
	private String partnerId;

	@NotBlank
	private String signKey;
	
	public String getUserName() {
		return this.userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPartnerId() {
		return this.partnerId;
	}
	
	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}
	
	public String getSignKey() {
		return this.signKey;
	}
	
	public void setSignKey(String signKey) {
		this.signKey = signKey;
	}
	
}
