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

import com.jvv.openapi.core.service.enums.SignTypeEnum;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

/**
 * MD5签名实现
 *
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/23 22:07
 */
@Service
public class  Md5Signer extends AbstractMapSourceSigner{

	@Override
	protected String doSign(String waitToSignStr, String key) {
		return DigestUtils.md5Hex (waitToSignStr + key);
	}

	@Override
	public SignTypeEnum getSinType() {
		return SignTypeEnum.MD5;
	}
}
