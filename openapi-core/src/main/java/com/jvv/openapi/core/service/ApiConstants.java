/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-22 20:11 创建
 *
 */
package com.jvv.openapi.core.service;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/22 20:11
 */

public interface ApiConstants {

	/**签约内容的方式:*/
	/**URL_PARAM:age=5&name=zhangsan*/
	public static final String SIGN_VALUE_TYPE_URL_PARAM = "URL_PARAM";
	/**ONLY_VALUE:5zhangsan*/
	public static final String SIGN_CONTEXT_TYPE_ONLY_VALUE = "ONLY_VALUE";

	public static final String SECURITY_CODE_KEY="publickey";

	/** GID */
	public static final String GID = "gid";
	/** GID Biz Code */
	public static final String GID_BIZ_CODE = "API";
	/** 订单号 */
	public static final String ORDER_NO = "orderNo";
	/** 商户ID */
	public static final String PARTNER_ID = "partnerId";
	/** 易拉货商户ID */
	public static final String JVV_PARTNER_ID = "JVV_00000001";
	/** 设备ID */
	public static final String DEVICE_ID = "deviceId";
	/** 设备ID */
	public static final String SYSTEM = "system";

	/** 服务名 */
	public static final String SERVICE = "service";
	/** 版本字段 */
	public static final String VERSION = "version";
	
	public static final String PROTOCOL = "protocol";
	/** 签约类型 */
	public static final String SIGN_TYPE = "signType";
	/** 异步通知地址 */
	public static final String NOTIFY_URL = "notifyUrl";
	/** 异步通知地址 */
	public static final String REDIRECT_URL = "redirectUrl";
	/** 返回地址 */
	public static final String RETURN_URL = "returnUrl";
	/** 返回码 */
	public static final String RESULT_CODE = "code";
	public static final String SIGN = "sign";
	public static final String RESULT_MESSAGE = "resultMessage";
	public static final String DATA_FORMAT = "yyyy-MM-dd HH:mm:ss";
	/** 默认版本 */
	public static final String VERSION_DEFAULT = "1.0";
	
	public static final String WILDCARD_TOKEN = "*";
	/**
	 * 性能日志logger
	 */
	public static final String PERFORMANCE_LOGGER = "com.jvv.openapi_PERFORMANCE_LOGGER";
	
	public static final String WS_UNIFIED_NAMESPACE = "http://openapi.jinvovo.com";
	
}
