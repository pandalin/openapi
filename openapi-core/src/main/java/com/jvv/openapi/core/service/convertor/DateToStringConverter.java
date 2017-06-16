/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-24 20:30 创建
 *
 */
package com.jvv.openapi.core.service.convertor;

import com.jvv.openapi.core.service.ApiConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/24 20:30
 */

public class DateToStringConverter implements Converter<Date, String> {

	private static Logger logger = LoggerFactory.getLogger (DateToStringConverter.class);

	@Override
	public String convert(Date source) {
		if (source == null) {
			return null;
		}
		try {
			return new SimpleDateFormat (ApiConstants.DATA_FORMAT).format(source);
		} catch (Exception e) {
			logger.warn("StringToDate转换失败,source:" + source, e);
			return null;
		}
	}
}
