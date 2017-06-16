/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-23 20:54 创建
 *
 */
package com.jvv.openapi.core.threadpool;

import com.jvv.openapi.core.service.base.InternalApiContextHolder;
import org.apache.log4j.MDC;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.jvv.openapi.core.service.ApiConstants;
import com.jvv.openapi.core.service.base.ApiContext;
import com.jvv.openapi.core.service.base.ApiContextHolder;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/23 20:54
 */

public class ApiThreadPoolTaskExecutor extends ThreadPoolTaskExecutor {
	
	@Override
	public void execute(final Runnable task) {
		final String gid = (String) MDC.get(ApiConstants.GID);
		final ApiContext apiContext = ApiContextHolder.getApiContext();
		final String callerThreadName = Thread.currentThread().getName();
		super.execute(new Runnable() {
			@Override
			public void run() {
				if (gid != null) {
					MDC.put(ApiConstants.GID, gid);
				}
				if (apiContext != null) {
					InternalApiContextHolder.setApiContext (apiContext);
				}
				try {
					task.run();
				} finally {
					//如果线程池队列满后,由当提交任务线程执行任务不能清空线程变量
					String currentThreadName = Thread.currentThread().getName();
					if (!currentThreadName.equals(callerThreadName)) {
						MDC.clear();
						InternalApiContextHolder.clear();
					}
				}
			}
		});
	}
}
