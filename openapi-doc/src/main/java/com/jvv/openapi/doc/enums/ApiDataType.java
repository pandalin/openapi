/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */

package com.jvv.openapi.doc.enums;

/**
 * API item 数据类型
 * 
 * @author zhangpu
 *
 */
public enum ApiDataType {

	/**
	 * 字符型
	 */
	S("S"),

	/**
	 * 固定长度字符
	 */
	FS("FS"),
	/**
	 * 数字型
	 */
	N("N"),
	/**
	 * 货币型
	 */
	M("M"),
	/**
	 * Decimal型
	 */
	D("D"),

	/**
	 * JSON串
	 */
	JSON("JSON"),

	/**
	 * JSON数组
	 */
	JSON_ARRAY("JSON_ARRAY");


	private String code;

	private ApiDataType(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
