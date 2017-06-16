/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-23 20:32 创建
 *
 */
package com.jvv.openapi.core.service.listener;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/23 20:32
 */

public interface Sortable {
	int HIGHEST_PRECEDENCE = Integer.MIN_VALUE;
	
	int LOWEST_PRECEDENCE = Integer.MAX_VALUE;
	
	/**
	 * 数字越小越先被执行
	 * @return
	 */
	int getOrder();
}
