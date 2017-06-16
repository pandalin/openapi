/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-24 20:04 创建
 *
 */
package com.jvv.openapi.core.service.marshall.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.*;

import java.lang.reflect.Type;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/24 20:04
 */


public class JsonMarshallor {
	/**
	 * 设置默认的时间格式 yyyy-MM-dd HH:mm:ss
	 */
	public static final String DEFAULT_DATE_FORMAT_STRING = "yyyy-MM-dd HH:mm:ss";
	/** 默认的日期格式 yyyy-MM-dd */
	public static final String SIMPLE_DATE_FORMAT_STRING = "yyyy-MM-dd";
	public static final JsonMarshallor INSTANCE = new JsonMarshallor();
	private Feature[] features;
	private ParserConfig parserConfig;

	private final SerializeConfig SERIALIZE_CONFIG = new SerializeConfig();

	private int featureValues = 0;

	private JsonMarshallor() {
		afterPropertiesSet();
	}

	public void afterPropertiesSet() {
//		SERIALIZE_CONFIG.put(Money.class, MoneySerializer.INSTANCE);
		parserConfig = new ParserConfig();
//		parserConfig.putDeserializer(Money.class, MoneyDeserializer.instance);
		features = new Feature[0];
		//取消SortFeidFastMatch特性.
		featureValues = (~Feature.SortFeidFastMatch.getMask()) & JSON.DEFAULT_PARSER_FEATURE;
	}

	/**
	 * 转换字符串为对象
	 * @param source 字符串
	 * @param clazz 类型
	 * @param <T> 返回对象
	 * @return
	 */
	public <T> T parse(String source, Type clazz) {
		return JSON.parseObject(source, clazz, parserConfig, featureValues, features);
	}

	/**
	 * 转换对象为json字符串
	 * @param object 原对象
	 * @return json字符串
	 */
	public String marshall(Object object) {
		if (object == null) {
			return "{}";
		}
		SerializeWriter out = new SerializeWriter();
		try {
			JSONSerializer serializer = getJsonSerializer(out);
			serializer.write(object);
			return out.toString();
		} finally {
			out.close();
		}
	}

	private JSONSerializer getJsonSerializer(SerializeWriter out) {
		JSONSerializer serializer = new JSONSerializer(out, SERIALIZE_CONFIG);
		serializer.config(SerializerFeature.WriteDateUseDateFormat, true);
		serializer.setDateFormat(DEFAULT_DATE_FORMAT_STRING);
		serializer.config(SerializerFeature.QuoteFieldNames, true);
		serializer.config(SerializerFeature.DisableCircularReferenceDetect, false);

		return serializer;
	}

	public void addSerializer(Class<?> clazz, ObjectSerializer objectSerializer) {
		SERIALIZE_CONFIG.put(clazz, objectSerializer);
	}
}
