/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2017-03-13 12:16 创建
 *
 */
package com.jvv.openapi.common.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author turalyon@jinvovo.com
 */
public class GidGenerater {
	/**
	 * 补全字符串时所用字符
	 */
	private static final char PADDING_CHAR = '0';

	/**
	 * 默认物理地址，如果获取mac失败，用此物理地址
	 */
	private static final String DEFAULT_MAC = "00:00:00:00:00:00";

	private static Random rand = new Random();

	private static final String $SERVER_ID = getServerID();

	public static final String DEFAULT_BIZ_CODE = "GID";

	/**
	 * 生成默认的GID
	 *
	 * @return
	 */
	public static String generateGid() {
		return generateGid(DEFAULT_BIZ_CODE);
	}

	public static String generateGid(String bizCode) {
		if (StringUtils.isEmpty(bizCode)) {
			bizCode = DEFAULT_BIZ_CODE;
		}
		bizCode = StringUtils.left(bizCode, 3);
		bizCode = rpad(bizCode, '0', 3);
		Date now = new Date();
		return concat(bizCode.toUpperCase(),
				formatDate(now, "yyyyMMddHHmmssSSS"), "0", $SERVER_ID,
				padding(Integer.toString(rand.nextInt(1000000)), 7, PADDING_CHAR));
	}
	/**
	 * 将给定时间按照 指定的格式转换为字符串
	 *
	 * @param date
	 * @param pattern
	 *
	 * @return
	 */
	public static String formatDate(Date date, String pattern) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		return dateFormat.format(date);
	}

	/**
	 * 填充字符串
	 *
	 * @param str 待填充字符串
	 * @param len 填充后的位数
	 * @param padding 填充字符
	 */
	private static String padding(String str, int len, char padding) {
		if (str.length() < len) {
			StringBuilder sb = new StringBuilder(len);
			int toPadLen = len - str.length();
			for (int i = 1; i <= toPadLen; i++) {
				sb.append(padding);
			}
			sb.append(str);
			return sb.toString();
		} else {
			return str;
		}
	}

	/**
	 * @param length
	 *
	 * @return
	 * @name Rpad
	 * @author zhyang
	 * @date 2011-7-8
	 * @description 右填充字符串
	 */
	public static String rpad(String str, char c, int length) {
		StringBuilder sb = new StringBuilder();
		sb.append(str);
		for (int i = length - str.length(); i > 0; i--) {
			sb.append(c);
		}
		return sb.toString();
	}

	private static String getServerID() {
		//随机生成长度为5的serverId
		return MD5Utils.getMD5(getMAC() + rand.nextInt(100000) + getIp()).substring(5, 12)
				.toUpperCase();
		//logger.warn("随机生成{}位serverid:{}", SERVER_ID_LEN, serverId);
	}

	private static String getMAC() {
		String mac;
		try {
			mac = IPUtils.getMACAddress();
			mac = mac.replace("-", ":");
		} catch (Exception e) {
			mac = DEFAULT_MAC;
			//logger.info("获取mac失败，使用默认物理地址:{}", mac);
		}
		return mac;
	}

	private static String getIp() {
		return IPUtils.getFirstNoLoopbackIPV4Address();
	}
	/**
	 * 字符串拼接
	 * @param strs
	 * @return
	 */
	public static String concat(String... strs) {
		StringBuilder sb = new StringBuilder(1024);
		if (strs != null) {
			for (String str : strs) {
				sb.append(str);
			}
		}
		return sb.toString();
	}
}
