/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-20 13:25 创建
 *
 */
package com.jvv.openapi.common.util;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/20 13:25
 */

public class ExtendPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
	
	@Override
	protected String convertProperty(String propertyName, String propertyValue) {
		System.out.println(propertyName+"\t:\t"+propertyValue);
		return super.convertProperty(propertyName, propertyValue);
	}
}
