/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-23 20:58 创建
 *
 */
package com.jvv.openapi.core.service.meta;

import java.lang.annotation.*;

/**
 * 仅框架使用api
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/23 20:58
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FrameworkOnly {
}
