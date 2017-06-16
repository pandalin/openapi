/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-23 22:14 创建
 *
 */
package com.jvv.openapi.core.service.auth.sign;

import com.jvv.openapi.core.service.enums.SignTypeEnum;
import com.jvv.openapi.core.util.CryptoUtils;
import org.springframework.stereotype.Service;

/**
 * HMACSHA1 签名和验签
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/23 22:14
 */
@Service
public class HmacSha1Signer extends AbstractMapSourceSigner {
	
	@Override
	protected String doSign(String waitToSignStr, String key) {
		return CryptoUtils.hmacSha1 (waitToSignStr, key);
	}
	
	@Override
	public SignTypeEnum getSinType() {
		return SignTypeEnum.HmacSha1Hex;
	}
}