/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-24 21:22 创建
 *
 */
package com.jvv.openapi.core.service.auth.sign.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.jvv.openapi.core.service.auth.ApiServiceAuthException;
import com.jvv.openapi.core.service.auth.sign.Signer;
import com.jvv.openapi.core.service.auth.sign.SignerFactory;

/**
 * 签名工厂实现
 *
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/24 21:22
 */

@Service("signerFactory")
public class SignerFactoryImpl<T> implements SignerFactory<T>, ApplicationContextAware,
									InitializingBean {
	
	private static final Logger logger = LoggerFactory.getLogger(SignerFactoryImpl.class);
	
	private ApplicationContext applicationContext;
	
	private Map<String, Signer<T>> signerMap;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void afterPropertiesSet() throws Exception {
		signerMap = Maps.newHashMap();
		Map<String, Signer> signers = applicationContext.getBeansOfType(Signer.class);
		for (Map.Entry<String, Signer> entry : signers.entrySet()) {
			String signName = entry.getValue().getSinType().name();
			signerMap.put(signName, entry.getValue());
			logger.info("加载{}签名处理器:{}", signName, entry.getValue().getClass().getName());
		}
	}
	
	@Override
	public Signer<T> getSigner(String signType) {
		Signer<T> signer = signerMap.get(signType);
		if (signer == null) {
			throw new ApiServiceAuthException("不支持的signType[" + signType + "]");
		}
		return signer;
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
