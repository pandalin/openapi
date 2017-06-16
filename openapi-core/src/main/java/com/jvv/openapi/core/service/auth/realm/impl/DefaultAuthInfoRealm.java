/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-23 21:42 创建
 *
 */
package com.jvv.openapi.core.service.auth.realm.impl;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.jvv.openapi.core.service.ApiServiceException;
import com.jvv.openapi.core.service.auth.repository.MerchantRepository;
import com.jvv.openapi.core.service.base.ApiServiceResultCode;
import com.jvv.openapi.dal.entity.MerchantDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/23 21:42
 */

@Service
public class DefaultAuthInfoRealm extends CacheableAuthInfoRealm {

	@Autowired
	private MerchantRepository merchantRepository;

	/**
	 * 获取商户安全校验码
	 *
	 * @param partnerId
	 * @return
	 */
	public String getSecurityCheckCode(String partnerId) {
		try {
			MerchantDO merchantDO = merchantRepository.loadFromCache(partnerId);
			if (merchantDO == null) {
				throw new ApiServiceException(ApiServiceResultCode.PARTNER_NOT_REGISTER,
						String.format("商户[%s]不存在", partnerId));
			}
			return merchantDO.getSecurityCode();
		} catch (ApiServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("获取用户安全校验码失败", e);
			throw new ApiServiceException(ApiServiceResultCode.INTERNAL_ERROR, "获取用户安全校验码失败:"
																			   + e.getMessage());
		}
	}
	
	/**
	 * 获取商户授权的权限列表.
	 *
	 * @param partnerId
	 * @return
	 */
	public List<String> getAuthorizedServices(String partnerId) {
		
		try {
			List<String> list = Lists.newArrayList();
			list.add("*");
			return list;
		} catch (Exception e) {
			logger.error("获取用户产品列表失败", e);
			throw new ApiServiceException(ApiServiceResultCode.INTERNAL_ERROR, "获取用户产品列表失败:"
																			   + e.getMessage());
		}
	}
	
	private static void parseProductions(List<String> list, String productions) {
		if (!Strings.isNullOrEmpty(productions)) {
			String[] prods = productions.split(",");
			for (String prod : prods) {
				if (!Strings.isNullOrEmpty(prod)) {
					list.add(prod);
				}
			}
		}
	}
}
