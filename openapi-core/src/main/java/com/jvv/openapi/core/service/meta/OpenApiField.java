/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-22 20:18 创建
 *
 */
package com.jvv.openapi.core.service.meta;

import java.lang.annotation.*;

/**
 * 标识此字段为openapi的字段. openapi通过此annotation生成文档.
 *
 * 不标注此annotation的字段不参与Marshall/Unmarshall
 * 
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/22 20:18
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OpenApiField {
	/**
	 * 字段描述信息
	 *
	 * @return
	 */
	String desc() default "";

	/**
	 * 字段限制信息
	 *
	 * @return
	 */
	String constraint() default "";

	/**
	 * 字段需要加密(AES)
	 *
	 * @return
	 */
	boolean security() default false;

	/**
	 * 字段demo
	 *
	 * @return
	 */
	String demo() default "";
}
