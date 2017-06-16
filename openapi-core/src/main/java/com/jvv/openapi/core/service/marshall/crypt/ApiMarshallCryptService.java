/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-24 20:01 创建
 *
 */
package com.jvv.openapi.core.service.marshall.crypt;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/24 20:01
 */

public interface ApiMarshallCryptService {
	
	String encrypt(String property, String text, String key);
	
	String decrypt(String property, String text, String key);
	
}
