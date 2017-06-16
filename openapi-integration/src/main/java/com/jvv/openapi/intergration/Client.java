/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2017-03-13 22:17 创建
 *
 */
package com.jvv.openapi.intergration;

import com.jvv.openapi.common.exception.OpenApiBizException;
import com.jvv.openapi.common.exception.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author turalyon@jinvovo.com
 */
public abstract class Client {
	
	@Value("#{integration['dubbo.registry.version']}")
	private String dubbo_default_version;
	
	@Value ("#{integration['dubbo.registry.group']}")
	private String dubbo_default_group;
	
	public String DUBBO_DEFAULT_VERSION = dubbo_default_version;
	public String DUBBO_DEFAULT_GROUP = dubbo_default_group;

	@Autowired
	private DubboClientFactory dubboClientFactory;

	protected <T> T getDubboClien(Class<T> clazz,String group,String version){
		return dubboClientFactory.getClient(clazz,group,version);
	}
	
	protected <T> T getDubboClient(Class<T> clazz){
		try {
			return getDubboClien(clazz,dubbo_default_group,dubbo_default_version);
		} catch (Exception e) {
			throw new OpenApiBizException (ResultCode.INTERNAL_ERROR);
		}
		
	}
	
	protected <T> T getDubboClient(Class<T> clazz,int timeout){
		try {
			return dubboClientFactory.getClient(clazz,dubbo_default_group,dubbo_default_version,timeout);
		} catch (Exception e) {
			throw new OpenApiBizException (ResultCode.INTERNAL_ERROR);
		}
		
	}
}
