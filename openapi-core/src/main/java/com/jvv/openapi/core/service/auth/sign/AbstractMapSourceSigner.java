/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-23 22:07 创建
 *
 */
package com.jvv.openapi.core.service.auth.sign;

import com.jvv.openapi.core.service.ApiConstants;
import com.jvv.openapi.core.service.ServiceConfigs;
import com.jvv.openapi.core.service.base.ApiServiceResultCode;
import com.jvv.openapi.core.util.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/23 22:07
 */

public abstract class AbstractMapSourceSigner implements Signer<Map<String, String>> {
	private static final Logger logger = LoggerFactory.getLogger(AbstractMapSourceSigner.class);

	public static final String SECURITY_CODE_KEY = ApiConstants.SECURITY_CODE_KEY;

	@Resource
	protected ServiceConfigs serviceConfigs;

	@Override
	public String sign(Map<String, String> stringStringMap, Object key) {
		return doSign(stringStringMap, key).getF();
	}
	
	@Override
	public void verify(String sign, String key, Map<String, String> stringStringMap)
			throws ApiServiceSignException {
		Pair<String, String> signPair = doSign(stringStringMap, key);
		if (!sign.equals(signPair.getF())) {
			logger.info("待签名字符串[{}]的签名结果：{}", signPair.getS(), signPair.getF());
			throw new ApiServiceSignException(ApiServiceResultCode.UN_AUTHENTICATED_ERROR);
		}
	}
	
	protected Pair<String, String> doSign(Map<String, String> stringStringMap, Object key) {
		stringStringMap.put(SECURITY_CODE_KEY, (String) key);

		String waitToSignStr = doStringToSign(stringStringMap);

		String signature = doSign(waitToSignStr, "");
		Pair<String, String> pair = new Pair<String, String>(signature, waitToSignStr);
		return pair;
	}
	
	protected String doStringToSign(Map<String, String> stringStringMap) {
		String waitToSignStr = null;
		Map<String, String> sortedMap = new TreeMap<String, String>(stringStringMap);
		if (sortedMap.containsKey(ApiConstants.SIGN)) {
			sortedMap.remove(ApiConstants.SIGN);
		}
		StringBuilder stringToSign = new StringBuilder();
		if (sortedMap.size() > 0) {
			logger.debug("签名:{}", sortedMap);

			if (ApiConstants.SIGN_CONTEXT_TYPE_ONLY_VALUE.equalsIgnoreCase(serviceConfigs.getSignContextType())) {
				for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
					// 注意：这里没有判断空字符串是为了兼容历史规范
					if (entry.getValue() != null) {
						//只签名 Value
						stringToSign.append(entry.getValue());
					}
				}
			} else {
				for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
					// 注意：这里没有判断空字符串是为了兼容历史规范
					if (entry.getValue() != null) {
						stringToSign.append(entry.getKey()).append("=").append(entry.getValue())
								.append("&");
					}
				}
				//&Key=Value式签名需要删掉
				stringToSign.deleteCharAt(stringToSign.length() - 1);
			}
			waitToSignStr = stringToSign.toString();
			logger.debug("待签名字符串:{}", waitToSignStr);
		}
		return waitToSignStr;
	}
	
	protected abstract String doSign(String waitToSignStr, String key);
}
