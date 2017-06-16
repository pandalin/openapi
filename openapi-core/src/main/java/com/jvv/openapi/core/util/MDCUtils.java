/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-25 21:26 创建
 *
 */
package com.jvv.openapi.core.util;

import org.apache.log4j.MDC;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/25 21:26
 */

public class MDCUtils {
	public static final String MDC_KEY = "logkey";
	
	public static void setLogKey(String key) {
		clear();
		MDC.put(MDC_KEY, "[" + key + "] ");
	}
	
	public static void clear() {
		MDC.clear();
	}
}
