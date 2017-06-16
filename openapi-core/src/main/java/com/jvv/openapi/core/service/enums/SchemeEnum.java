/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-22 20:26 创建
 *
 */
package com.jvv.openapi.core.service.enums;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/22 20:26
 */

public enum SchemeEnum {
	/**
	 * 描述
	 */
	ALL("all", "http/https"),
	
	HTTP("http", "http"),
	
	HTTPS("https", "https");
	;
	
	/**
	 * 枚举值
	 */
	private final String code;
	
	/**
	 * 枚举描述
	 */
	private final String message;
	
	/**
	 * 构造一个<code>SchemeEnum</code>枚举对象
	 *
	 * @param code
	 * @param message
	 */
	private SchemeEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
	/**
	 * @return Returns the code.
	 */
	public String getCode() {
		return code;
	}
	
	/**
	 * @return Returns the message.
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * @return Returns the code.
	 */
	public String code() {
		return code;
	}
	
	/**
	 * @return Returns the message.
	 */
	public String message() {
		return message;
	}
	
	/**
	 * 通过枚举<code>code</code>获得枚举
	 *
	 * @param code
	 *
	 * @return SchemeEnum.java
	 */
	public static SchemeEnum getByCode(String code) {
		for (SchemeEnum _enum : values()) {
			if (_enum.getCode().equalsIgnoreCase(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 *
	 * @return List<LocalCacheEnum>
	 */
	public java.util.List<SchemeEnum> getAllEnum() {
		java.util.List<SchemeEnum> list = new java.util.ArrayList<SchemeEnum>();
		for (SchemeEnum _enum : values()) {
			list.add(_enum);
		}
		return list;
	}
	
	/**
	 * 获取全部枚举值
	 *
	 * @return List<String>
	 */
	public java.util.List<String> getAllEnumCode() {
		java.util.List<String> list = new java.util.ArrayList<String>();
		for (SchemeEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
	
	/**
	 * 判断给定的枚举，是否在列表中
	 *
	 * @param values 列表
	 *
	 * @return
	 */
	public boolean isInList(SchemeEnum... values) {
		for (SchemeEnum e : values) {
			if (this == e) {
				return true;
			}
		}
		return false;
	}
}
