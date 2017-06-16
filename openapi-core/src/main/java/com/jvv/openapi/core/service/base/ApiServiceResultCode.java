/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-22 21:19 创建
 *
 */
package com.jvv.openapi.core.service.base;

import com.jvv.openapi.common.exception.ResultCode;

/**
 * 2×× 　　表示请求成功地接收
 * 3×× 　　为完成请求客户需进一步细化请求
 * 4×× 　　客户错误
 * 5×× 　　服务器错误
 *
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/22 21:19
 */

public class ApiServiceResultCode extends ResultCode {

	////////4×× 　　客户错误  /////////////////
	public static ApiServiceResultCode PARAMETER_ERROR = new ApiServiceResultCode(
		"400", "参数错误");
	public static ApiServiceResultCode UNSUPPORTED_SECHEME = new ApiServiceResultCode(
			"403", "不支持的请求协议");
	public static ApiServiceResultCode ILLEGAL_REQUEST = new ApiServiceResultCode(
			"404", "非法请求");

	public static ApiServiceResultCode PARAM_FORMAT_ERROR = new ApiServiceResultCode(
			"408", "参数格式错误");

	public static ApiServiceResultCode UN_AUTHENTICATED_ERROR = new ApiServiceResultCode(
		"409", "认证(签名)错误");


	public static ApiServiceResultCode REQUEST_GID_NOT_EXSIT = new ApiServiceResultCode(
			"410", "GID对应的原始请求不存在");

	/////////////////////5×× 　　服务器错误 /////////////
	/**
	 * 合作伙伴id没有在openapi中注册
	 */
	public static ApiServiceResultCode PARTNER_NOT_REGISTER = new ApiServiceResultCode(
			"510", "商户没有注册");


	/**
	 * 合作伙伴id没有产品
	 */
	public static ApiServiceResultCode PARTNER_NOT_PRODUCT = new ApiServiceResultCode(
			"520", "商户没有配置产品");


	public static ApiServiceResultCode SERVICE_NOT_FOUND_ERROR = new ApiServiceResultCode(
		"4530", "服务不存在");
	
	public static ApiServiceResultCode UN_AUTHORIZED_ERROR = new ApiServiceResultCode(
		"531", "未授权的服务");


	
	public static ApiServiceResultCode REDIRECT_URL_NOT_EXIST = new ApiServiceResultCode(
		"570", "跳转服务需设置redirectUrl");




	

	
	public static ApiServiceResultCode FIELD_NOT_UNIQUE = new ApiServiceResultCode(
			"590", "对象字段重复");
	
	public static ApiServiceResultCode NOTIFY_ERROR = new ApiServiceResultCode("600",
		"通知失败");




	public ApiServiceResultCode(String code, String message) {
		super(code, message);
	}
	
}
