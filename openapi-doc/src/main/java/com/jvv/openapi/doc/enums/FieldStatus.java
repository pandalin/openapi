/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */

package com.jvv.openapi.doc.enums;

/**
 * 数据项状态 可选，必选，条件
 * <p/>
 * Created by zhangpu on 2015/4/10.
 */
public enum FieldStatus {

	/**
	 * 必选
	 */
	M("M", "必须"),
	/**
	 * 可选
	 */
	O("O", "可选"),

	/**
	 * 条件可选
	 */
	C("C", "条件可选");

	private String key;
	private String message;

	FieldStatus(String key, String message) {
		this.key = key;
		this.message = message;
	}

	public String getKey() {
		return key;
	}

	public String getMessage() {
		return message;
	}
}
