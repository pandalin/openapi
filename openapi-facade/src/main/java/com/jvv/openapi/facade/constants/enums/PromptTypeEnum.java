/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2017-03-13 20:40 创建
 *
 */
package com.jvv.openapi.facade.constants.enums;

/**
 * @author turalyon@jinvovo.com
 */
public enum PromptTypeEnum {
	/**
	 * 警示框
	 */
	ALERT ("ALERT", "警示框"),
	/**
	 * 弹出框
	 */
	POPUP ("POPUP", "弹出框"),

	//TODO 其他模式
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
	 * 构造一个<code>PromptTypeEnum</code>枚举对象
	 *
	 * @param code
	 * @param message
	 */
	private PromptTypeEnum(String code, String message) {
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
	 * @return PromptTypeEnum.java
	 */
	public static PromptTypeEnum getByCode(String code) {
		for (PromptTypeEnum _enum : values()) {
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
	public static java.util.List<PromptTypeEnum> getAllEnum() {
		java.util.List<PromptTypeEnum> list = new java.util.ArrayList<PromptTypeEnum>();
		for (PromptTypeEnum _enum : values()) {
			list.add(_enum);
		}
		return list;
	}
	
	/**
	 * 获取全部枚举值
	 *
	 * @return List<String>
	 */
	public static java.util.List<String> getAllEnumCode() {
		java.util.List<String> list = new java.util.ArrayList<String>();
		for (PromptTypeEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
	
	/**
	 * 判断给定的枚举，是否在列表中
	 *
	 * @param values 列表
	 * @return
	 */
	public boolean isInList(PromptTypeEnum... values) {
		for (PromptTypeEnum e : values) {
			if (this == e) {
				return true;
			}
		}
		return false;
	}
}
