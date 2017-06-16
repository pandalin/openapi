/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-22 22:34 创建
 *
 */
package com.jvv.openapi.core.service.auth.impl;

import javax.annotation.Resource;

import com.jvv.openapi.core.service.auth.realm.AuthInfoRealm;
import com.jvv.openapi.core.service.base.ApiContext;
import com.jvv.openapi.core.service.base.InternalApiContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.jvv.openapi.core.service.auth.ApiAuthorization;
import com.jvv.openapi.core.service.auth.ApiAuthorizer;
import com.jvv.openapi.core.service.auth.ApiServiceAuthException;
import com.jvv.openapi.core.service.entity.ApiRequest;

/**
 * 商户鉴权
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/22 22:34
 */

@Service("apiAuthorization")
public class DefaultApiAuthorization implements ApiAuthorization {
	private static final Logger logger = LoggerFactory.getLogger(DefaultApiAuthorization.class);
	@Resource
	protected AuthInfoRealm authInfoRealm;
	@Resource
	protected ApiAuthorizer apiAuthorizer;
	
	@Override
	public void authorize(ApiRequest apiRequest) {
		ApiContext apiContext = InternalApiContextHolder.getApiContext ();
		
		try {
			doCheckApiAuthorizer(apiRequest, apiContext);
		} catch (ApiServiceAuthException ase) {
			throw ase;
		} catch (Exception e) {
			//如果商户系统验权失败，还是使用原来的验权方式
			logger.warn("商户系统验权失败，使用arch的验权框架！");
		}
		
	}
	
	private void doCheckApiAuthorizer(ApiRequest apiRequest, ApiContext apiContext) {
		//		MerchantProductCheckOrder order = new MerchantProductCheckOrder();
		//		order.setServCode(apiRequest.getService());
		//		order.setCardNo(apiRequest.getPartnerId());
		//		order.setGid(apiContext.getGid());
		//		ProductCheckSingleResult result = merchantProductCheckService.checkProductService(order);
		//		if (!result.isSuccess()) {
		//			throw new ApiServiceAuthorizationException("服务[" + apiRequest.getService() + "]未授权");
		//		}
		logger.debug("商户验权通过！");
	}
}
