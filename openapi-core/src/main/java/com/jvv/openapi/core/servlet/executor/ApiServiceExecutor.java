/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-22 20:02 创建
 *
 */
package com.jvv.openapi.core.servlet.executor;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/22 20:02
 */

public interface ApiServiceExecutor<REQ, RES> {
	
	void execute(REQ request, RES response);
	
}
