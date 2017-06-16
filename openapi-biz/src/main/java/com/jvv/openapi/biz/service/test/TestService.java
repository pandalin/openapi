/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-26 12:17 创建
 *
 */
package com.jvv.openapi.biz.service.test;

import com.jvv.openapi.biz.service.base.BizServiceBase;
import com.jvv.openapi.domain.base.result.DefaultDomainResult;
import com.jvv.openapi.domain.test.TestDomain;
import org.springframework.stereotype.Component;

/**
 * 测试服务的业务逻辑层
 *
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/26 12:17
 */
@Component("testService")
public class TestService extends BizServiceBase {

	/**
	 * 测试服务
	 * @param domain
	 */
	public DefaultDomainResult test(TestDomain domain) {
		logger.info("进入Test 服务的Biz层！！domain={}", domain);
		DefaultDomainResult result = new DefaultDomainResult();

		logger.info("返回[登录]领域对象执行结果：result={}", result);
		return result;
	}
}
