/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-24 20:02 创建
 *
 */
package com.jvv.openapi.core.service.marshall.crypt.impl;

import com.jvv.openapi.core.service.ApiServiceException;
import com.jvv.openapi.core.service.auth.realm.AuthInfoRealm;
import com.jvv.openapi.core.service.base.ApiServiceResultCode;
import com.jvv.openapi.core.service.marshall.crypt.ApiMarshallCryptService;
import com.jvv.openapi.core.util.CryptoUtils;
import com.jvv.openapi.core.util.EncodeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/24 20:02
 */
@Service
public class ApiMarshallCryptServiceImpl implements ApiMarshallCryptService {
	
	private static final Logger logger = LoggerFactory.getLogger(ApiMarshallCryptServiceImpl.class);
	
	@Autowired
	private AuthInfoRealm authInfoRealm;
	
	/**
	 * 无编码和向量AES解密
	 */
	@Override
	public String encrypt(String property, String text, String key) {
		try {
			byte[] securityKey = getSecurityKey(key);
			byte[] encrypt = CryptoUtils.aesEncrypt(text.getBytes("UTF-8"), securityKey);
			return EncodeUtils.encodeBase64(encrypt);
		} catch (Exception e) {
			logger.warn("数据项[{}]加密失败:{}", property, e.getMessage());
			throw new ApiServiceException(ApiServiceResultCode.PARAMETER_ERROR, "数据项" + property
																				+ "加密失败.");
		}
	}
	
	/**
	 * 无编码和向量AES加密
	 * <p/>
	 * 返回：密文的HexString格式
	 */
	@Override
	public String decrypt(String property, String text, String key) {
		try {
			byte[] securityKey = getSecurityKey(key);
			byte[] data = EncodeUtils.decodeBase64(text);
			return CryptoUtils.aesDecrypt(data, securityKey);
		} catch (Exception e) {
			logger.warn("数据项[{}]解密失败:{}", property, e.getMessage());
			throw new ApiServiceException(ApiServiceResultCode.PARAMETER_ERROR, "数据项" + property
																				+ "解密失败.");
		}
	}
	
	protected byte[] getSecurityKey(String key) {
		String securityKey = (String) authInfoRealm.getAuthenticationInfo(key);
		try {
			return securityKey.substring(0, 16).getBytes(EncodeUtils.DEFAULT_ENCODING);
		} catch (UnsupportedEncodingException e) {
			throw new ApiServiceException(e);
		}
	}
}
