/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-23 22:12 创建
 *
 */
package com.jvv.openapi.core.service.auth.sign;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import com.jvv.openapi.core.service.enums.SignTypeEnum;

/**
 * Sha1Hex 签名和验签
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/23 22:12
 */

@Service
public class Sha1Signer extends AbstractMapSourceSigner {
	
	@Override
	protected String doSign(String waitToSignStr, String key) {
		return DigestUtils.sha1Hex(waitToSignStr + key);
	}
	
	@Override
	public SignTypeEnum getSinType() {
		return SignTypeEnum.Sha1Hex;
	}
}