/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-22 20:28 创建
 *
 */
package com.jvv.openapi.core.service.enums;

import com.jvv.openapi.core.service.ApiConstants;
import com.jvv.openapi.core.service.base.ServiceValidator;
import com.jvv.openapi.core.service.validator.UrlValidator;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/22 20:28
 */

public enum ResponseTypeEnum implements ServiceValidator {
	/**
	 * 描述
	 */
	/**
	 * 请求直接响应
	 */
	SYN("SYN", "同步服务") {
		@Override
		public void validate(Map<String, String> requestData) {
			
		}
	},
	/**
	 * 请求需要异步通知确认
	 */
	ASNY("ASNY", "异步服务") {
		@Override
		public void validate(Map<String, String> requestData) {
			String name = ApiConstants.NOTIFY_URL;
			if (StringUtils.isNotEmpty(requestData.get(name))) {
				UrlValidator.checkOpenAPIUrl (requestData.get (name), name);
			}
		}
	},
	/**
	 * 请求响应为重定向
	 */
	REDIRECT("REDIRECT", "重定向服务") {
		@Override
		public void validate(Map<String, String> requestData) {
			String name = ApiConstants.REDIRECT_URL;
			if (StringUtils.isNotEmpty(requestData.get(name))) {
				UrlValidator.checkOpenAPIUrl (requestData.get (name), name);
			}
			name = ApiConstants.NOTIFY_URL;
			if (StringUtils.isNotEmpty(requestData.get(name))) {
				UrlValidator.checkOpenAPIUrl(requestData.get(name), name);
			}
		}
	};
	
	/**
	 * 枚举值
	 */
	private final String code;
	
	/**
	 * 枚举描述
	 */
	private final String message;
	
	/**
	 * 构造一个<code>ResponseTypeEnum</code>枚举对象
	 *
	 * @param code
	 * @param message
	 */
	private ResponseTypeEnum(String code, String message) {
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
	 * @return ResponseTypeEnum.java
	 */
	public static ResponseTypeEnum getByCode(String code) {
		for (ResponseTypeEnum _enum : values()) {
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
	public java.util.List<ResponseTypeEnum> getAllEnum() {
		java.util.List<ResponseTypeEnum> list = new java.util.ArrayList<ResponseTypeEnum>();
		for (ResponseTypeEnum _enum : values()) {
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
		for (ResponseTypeEnum _enum : values()) {
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
	public boolean isInList(ResponseTypeEnum... values) {
		for (ResponseTypeEnum e : values) {
			if (this == e) {
				return true;
			}
		}
		return false;
	}
}
