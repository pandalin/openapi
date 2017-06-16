/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-23 21:55 创建
 *
 */
package com.jvv.openapi.core.service.auth.sign;

import com.jvv.openapi.core.service.enums.SignTypeEnum;

/**
 * 签名接口
 *
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/23 21:55
 */

public interface Signer<T> {
	
	String sign(T t, Object key);
	
	/**
	 * 认证失败抛出异常
	 * @param sign
	 * @param key
	 * @param t
	 * @throws ApiServiceSignException
	 */
	void verify(String sign, String key, T t) throws ApiServiceSignException;
	
	/**
	 *
	 * @return
	 */
	SignTypeEnum getSinType();
}
