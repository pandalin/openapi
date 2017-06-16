/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-22 20:24 创建
 *
 */
package com.jvv.openapi.core.service.meta;

import com.jvv.openapi.core.service.enums.ApiBizTypeEnum;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.enums.SchemeEnum;
import org.springframework.stereotype.Service;

import java.lang.annotation.*;

/**
 * openapi 服务类定义
 *
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/22 20:24
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Service
public @interface OpenApiService {
	/**
	 * 服务名称
	 *
	 * @return
	 */
	String name();
	
	/**
	 * 服务版本
	 *
	 * @return
	 */
	String version() default "1.0";
	
	/**
	 * 服务描述
	 *
	 * @return
	 */
	String desc();
	
	/**
	 * 服务响应类型,默认为同步响应
	 *
	 * @return
	 */
	ResponseTypeEnum responseType() default ResponseTypeEnum.SYN;
	
	/**
	 * 访问通讯协议
	 *
	 * @return
	 */
	SchemeEnum scheme() default SchemeEnum.ALL;
	
	/**
	 * 所属子系统
	 *
	 * @return
	 */
	String owner() default "unknown";
	
	/**
	 * 业务类型
	 *
	 * @return
	 */
	ApiBizTypeEnum bizType() default ApiBizTypeEnum.TRADE;
}