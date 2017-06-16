/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-24 20:29 创建
 *
 */
package com.jvv.openapi.core.service.convertor;


import org.springframework.core.convert.support.DefaultConversionService;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/24 20:29
 */

public class ApiServiceConversionService extends DefaultConversionService {

	public static final ApiServiceConversionService INSTANCE = new ApiServiceConversionService();

	public ApiServiceConversionService() {
		super();
		addCustomConverters();
	}

	private void addCustomConverters() {
		addConverter(new DateToStringConverter());
//		addConverter(new MoneyToStringConverter());
		addConverter(new StringToDateConverter());
//		addConverter(new StringToMoneyConverter());

	}
}
