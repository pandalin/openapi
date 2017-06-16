/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-23 21:14 创建
 *
 */
package com.jvv.openapi.core.support;

import java.util.Map;

/**
 * 系统参数日志统一处理 接口
 *
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/23 21:14
 */

public interface LoggerHandler {
	void log(String label,Map<String, ?> data);
}
