/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-30 21:03 创建
 *
 */

package com.jvv.openapi.biz.service.login;

import com.jvv.openapi.domain.base.result.DefaultDomainResult;
import com.jvv.openapi.domain.login.LoginDomain;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/30 21:03
 */

public interface LoginService {

	public DefaultDomainResult login(LoginDomain domain);
}
