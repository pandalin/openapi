/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */

package com.jvv.openapi.doc.enums;

import java.util.ArrayList;
import java.util.List;


public enum MessageType {

	Request("Request","请求"),

	Response("Response","响应"),

	Return("Return","同步通知"),

	Redirect("Redirect","跳转通知"),
	
	Notify("Notify","异步通知");
	
	/** 枚举值 */
	private final String code;
	
	/** 枚举描述 */
	private final String message;

	MessageType(String code, String message) {
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
	 * @return DeductResultEnum
	 */
	public static MessageType getByCode(String code) {
		for (MessageType _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<DeductResultEnum>
	 */
	public static List<MessageType> getAllEnum() {
		List<MessageType> list = new ArrayList<MessageType>();
		for (MessageType _enum : values()) {
			list.add(_enum);
		}
		return list;
	}
	
	/**
	 * 获取全部枚举值
	 * 
	 * @return List<String>
	 */
	public List<String> getAllEnumCode() {
		List<String> list = new ArrayList<String>();
		for (MessageType _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
}
