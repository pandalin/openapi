/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-23 20:52 创建
 *
 */
package com.jvv.openapi.core.threadpool;


/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/23 20:52
 */

public class ApiThreadPoolTaskExecutorFactory {
	private volatile static ApiThreadPoolTaskExecutor threadPoolTaskExecutor = null;

	public static ApiThreadPoolTaskExecutor getThreadPoolTaskExecutor() {
		if (threadPoolTaskExecutor == null) {
			synchronized (ApiThreadPoolTaskExecutorFactory.class) {
				if (threadPoolTaskExecutor == null) {
					init();
				}
			}
		}
		return threadPoolTaskExecutor;
	}

	private static void init() {
		threadPoolTaskExecutor = new ApiThreadPoolTaskExecutor();
		threadPoolTaskExecutor.setCorePoolSize(1);
		threadPoolTaskExecutor.setKeepAliveSeconds(300);
		threadPoolTaskExecutor.setMaxPoolSize(8);
		threadPoolTaskExecutor.setQueueCapacity(10);
		threadPoolTaskExecutor.setAwaitTerminationSeconds(30);
		threadPoolTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);
		threadPoolTaskExecutor.setAllowCoreThreadTimeOut(true);
		threadPoolTaskExecutor.setDaemon(false);
		threadPoolTaskExecutor.setRejectedExecutionHandler(new ApiRejectedExecutionHandler());
		threadPoolTaskExecutor.setThreadNamePrefix("openapi-listener-");
		threadPoolTaskExecutor.initialize();


//		ShutdownHooks.addShutdownHook (new Runnable () {
//			@Override
//			public void run () {
//				threadPoolTaskExecutor.destroy ();
//			}
//		}, "openapiThreadpoolShutDownHook");
	}
}
