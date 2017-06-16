/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-24 21:22 创建
 *
 */
package com.jvv.openapi.core.service.auth.sign;

/**
 * 签名对象工厂
 *
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/24 21:22
 */

public interface SignerFactory<T> {
	Signer<T> getSigner(String signType);
}
