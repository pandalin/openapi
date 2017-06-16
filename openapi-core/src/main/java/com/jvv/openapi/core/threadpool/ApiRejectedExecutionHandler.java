/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-23 20:55 创建
 *
 */
package com.jvv.openapi.core.threadpool;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 如果线程池处理不过来,交给调用线程执行
 * 
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/23 20:55
 */

public class ApiRejectedExecutionHandler implements RejectedExecutionHandler {
	
	public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
		if (!e.isShutdown()) {
			r.run();
		}
	}
}
