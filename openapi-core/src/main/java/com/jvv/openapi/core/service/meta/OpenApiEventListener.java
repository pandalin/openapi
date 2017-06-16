/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-22 20:23 创建
 *
 */
package com.jvv.openapi.core.service.meta;

import org.springframework.stereotype.Service;

import java.lang.annotation.*;

/**
 * 服务监听器注解
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/22 20:23
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Service
public @interface OpenApiEventListener {

	/**
	 * 是否是全局监听器,默认false
	 * @return
	 */
	boolean global() default false;

	/**
	 * 是否异步,默认false
	 * @return
	 */
	boolean asyn() default false;
}
