/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-30 21:04 创建
 *
 */

package com.jvv.openapi.biz.service.login.impl;

import com.jvv.openapi.biz.service.login.LoginService;
import com.jvv.openapi.domain.base.result.DefaultDomainResult;
import com.jvv.openapi.domain.login.LoginDomain;
import org.springframework.stereotype.Service;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/30 21:04
 */

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	@Override
	public DefaultDomainResult login(LoginDomain domain) {
		
		domain.setUserName("zhangsan");
		domain.setUserId("201511312234");
		domain.setRealName("张三");
		domain.setNickName("三哥");
		
		domain.setMobileNo("1388888888");
		
		return new DefaultDomainResult();
	}
}
