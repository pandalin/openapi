/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-22 20:40 创建
 *
 */
package com.jvv.openapi.common.exception;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/22 20:40
 */

public class ResultCode {
	
	public static ResultCode EXECUTE_SUCCESS = new ResultCode("200", "成功");

	public static ResultCode EXECUTE_PROCESSING = new ResultCode("300", "处理中");

	public static ResultCode INVALID_ARGUMENTS = new ResultCode("400", "请求参数非法");

	public static ResultCode ORDER_NO_NOT_UNIQUE = new ResultCode("410", "商户订单号不唯一");


	public static ResultCode DATABASE_EXCEPTION= new ResultCode("490", "数据库异常");

	public static ResultCode INTERNAL_ERROR = new ResultCode("500", "内部错误");

	public static ResultCode NOT_LOGIN = new ResultCode("10001", "用户未登陆");

	/** 编码 */
	private String code;
	/** 描述信息 */
	private String message;


	public ResultCode(String code, String message) {
		setCode(code);
		setMessage(message);
	}
	
	public String getCode() {
		return code;
	}
	
	protected void setCode(String code) {
		this.code = code;
	}
	
	public String getMessage() {
		return message;
	}
	
	protected void setMessage(String message) {
		this.message = message;
	}
}
