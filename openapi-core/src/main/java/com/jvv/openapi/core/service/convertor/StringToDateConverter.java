/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-24 20:32 创建
 *
 */
package com.jvv.openapi.core.service.convertor;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import com.jvv.openapi.core.service.ApiConstants;
import com.jvv.openapi.core.service.ParamFormatException;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/24 20:32
 */

public class StringToDateConverter implements Converter<String, Date> {
	
	private static Logger logger = LoggerFactory.getLogger(StringToDateConverter.class);
	
	@Override
	public Date convert(String source) {
		if (source == null || source.equals("")) {
			return null;
		}
		try {
			return new SimpleDateFormat(ApiConstants.DATA_FORMAT).parse(source);
		} catch (Exception e) {
			logger.warn("StringToDate转换失败,source:" + source, e);
			throw new ParamFormatException("", source, ApiConstants.DATA_FORMAT);
		}
		
	}
	
}
