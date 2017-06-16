/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2017-03-13 19:02 创建
 *
 */
package com.jvv.openapi.facade.constants.enums;

/**
 * @author turalyon@jinvovo.com
 */
public enum MerchantStatusEnum {
	/**
	 * 描述
	 */
	NORMAL ("NORMAL", "message"),

	//TODO 其他状态，业务系统自定义

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
	 * 构造一个<code>MerchantStatusEnum</code>枚举对象
	 *
	 * @param code
	 * @param message
	 */
	private MerchantStatusEnum(String code, String message) {
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
	 * @return MerchantStatusEnum.java
	 */
	public static MerchantStatusEnum getByCode(String code) {
		for (MerchantStatusEnum _enum : values()) {
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
	public static java.util.List<MerchantStatusEnum> getAllEnum() {
		java.util.List<MerchantStatusEnum> list = new java.util.ArrayList<MerchantStatusEnum>();
		for (MerchantStatusEnum _enum : values()) {
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
		for (MerchantStatusEnum _enum : values()) {
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
	public boolean isInList(MerchantStatusEnum... values) {
		for (MerchantStatusEnum e : values) {
			if (this == e) {
				return true;
			}
		}
		return false;
	}
}
