/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-23 21:40 创建
 *
 */
package com.jvv.openapi.core.service.auth.realm.impl;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.jvv.openapi.core.service.auth.permission.Permission;
import com.jvv.openapi.core.service.auth.permission.PermissionResolver;
import com.jvv.openapi.core.service.auth.realm.AuthInfoRealm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.Resource;
import java.util.List;

/**
 * 缓存实现
 *
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/23 21:40
 */

public abstract class CacheableAuthInfoRealm implements AuthInfoRealm, InitializingBean {
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	PermissionResolver permissionResolver;
	
	protected static final String AUTHC_CACHE_KEY_POSTFIX = "authc";
	protected static final String AUTHZ_CACHE_KEY_POSTFIX = "authz";
	
	@Override
	public void afterPropertiesSet() throws Exception {
		
	}
	
	@Override
	public Object getAuthenticationInfo(String partnerId) {
		//启用缓存
		Object value = getSecurityCheckCode(partnerId);
		return value;
	}
	
	@Override
	public Object getAuthorizationInfo(String partnerId) {
		//启用缓存
		//		String key = partnerId + AUTHZ_CACHE_KEY_POSTFIX;
		List<String> permStrList = getAuthorizedServices(partnerId);
		// 如果没有查询到权限信息,不设置缓存,有可能是网络或者权限系统内部错误
		if (permStrList == null || permStrList.isEmpty()) {
			return null;
		}
		List<Permission> perms = Lists.newArrayList();
		for (String permStr : permStrList) {
			if (!Strings.isNullOrEmpty(permStr)) {
				perms.add(permissionResolver.resolvePermission(permStr));
			}
		}
		return perms;
	}
	
	/**
	 * 获取用户安全校验码
	 *
	 * @param partnerId
	 * @return
	 */
	public abstract String getSecurityCheckCode(String partnerId);
	
	/**
	 * 获取产品名称列表
	 *
	 * @param partnerId
	 * @return
	 */
	public abstract List<String> getAuthorizedServices(String partnerId);
}
