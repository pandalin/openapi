/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-23 21:15 创建
 *
 */
package com.jvv.openapi.core.support;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

/**
 * 接口参数日志处理
 * 
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/23 21:15
 */

@Service("parameterLoggerHandler")
public class ParameterLoggerHandler implements LoggerHandler {
	
	private static final Logger logger = LoggerFactory.getLogger("ParamsLogger");
	public static final String DEF_MASK_KEYS = "cardNo,idcard,mobileNo,userName";
	public static final String DEF_IGNORE_KEYS = "password,pass,passwd";
	/**
	 * 需要mask的参数key，多个使用（逗号）分隔
	 */
	@Value("${system.logger.maskkeys}")
	private String maskKeys;
	
	/**
	 * 需要忽略的参数key，多个使用（逗号）分隔
	 */
	@Value("${system.logger.ignorekeys}")
	private String ignoreKeys;
	
	private String maskChars = "*";
	
	private Set<String> masks;
	private Set<String> ignores;
	
	@Override
	public void log(String label, Map<String, ?> data) {
		if (data == null || data.size() == 0) {
			logger.info(StringUtils.trimToEmpty(label) + "{}", "{}");
			return;
		}
		Map<String, String> logData = Maps.newTreeMap();
		for (Map.Entry<String, ?> entry : data.entrySet()) {
			if (entry.getValue() == null) {
				logData.put(entry.getKey(), null);
				continue;
			}
			if (needIgnore(entry.getKey())) {
				logData.put(entry.getKey(), doMaskIgnore(entry.getValue()));
			} else if (needMask(entry.getKey())) {
				logData.put(entry.getKey(), doMask(entry.getValue()));
			} else {
				logData.put(entry.getKey(), entry.getValue().toString());
			}
		}
		logger.info(StringUtils.trimToEmpty(label) + logData.toString());
	}
	
	protected boolean needMask(String key) {
		boolean needToMask = false;
		for (String maskKey : getMasks()) {
			if (StringUtils.containsIgnoreCase(key, maskKey)) {
				needToMask = true;
				break;
			}
		}
		return needToMask;
	}
	
	protected boolean needIgnore(String key) {
		boolean needToIgnore = false;
		for (String k : getIgnores()) {
			if (StringUtils.containsIgnoreCase(key, k)) {
				needToIgnore = true;
				break;
			}
		}
		return needToIgnore;
	}
	
	protected String doMask(Object object) {
		String logValue = object.toString();
		int maskLen = logValue.length() / 2;
		return StringUtils.rightPad(StringUtils.substring(logValue, 0, maskLen), logValue.length(),
			maskChars);
	}
	
	protected String doMaskIgnore(Object object) {
		String logValue = object.toString();
		return StringUtils.leftPad("", logValue.length(), maskChars);
	}
	
	protected Set<String> getMasks() {
		if (masks == null) {
			synchronized (this) {
				if (masks == null) {
					masks = Sets.newHashSet(StringUtils.split(DEF_MASK_KEYS, ","));
					if (StringUtils.isNotBlank(maskKeys)) {
						masks.addAll(Sets.newHashSet(StringUtils.split(maskKeys, ",")));
					}
					logger.info("初始化加载 mask keys：{}", masks);
				}
			}
		}
		return masks;
	}
	
	protected Set<String> getIgnores() {
		if (ignores == null) {
			synchronized (this) {
				if (ignores == null) {
					ignores = Sets.newHashSet(StringUtils.split(DEF_IGNORE_KEYS, ","));
					if (StringUtils.isNotBlank(ignoreKeys)) {
						ignores.addAll(Sets.newHashSet(StringUtils.split(ignoreKeys, ",")));
					}
					logger.info("初始化加载 ignore keys：{}", ignores);
				}
			}
		}
		return ignores;
	}
	
	public void setMaskKeys(String maskKeys) {
		this.maskKeys = maskKeys;
	}
	
	public void setIgnoreKeys(String ignoreKeys) {
		this.ignoreKeys = ignoreKeys;
	}
	
}
