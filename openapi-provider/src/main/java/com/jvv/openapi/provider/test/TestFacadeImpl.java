/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-26 16:56 创建
 *
 */
package com.jvv.openapi.provider.test;

import com.jvv.openapi.biz.service.test.TestService;
import com.jvv.openapi.common.exception.OpenApiException;
import com.jvv.openapi.domain.base.result.DefaultDomainResult;
import com.jvv.openapi.domain.test.TestDomain;
import com.jvv.openapi.facade.test.api.TestFacade;
import com.jvv.openapi.facade.test.order.TestOrder;
import com.jvv.openapi.facade.test.result.TestResult;
import com.jvv.openapi.provider.base.AbstractFacadeImpl;
import com.jvv.openapi.provider.test.convertor.TestFacadeConvertor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/26 16:56
 */
@Service("testFacade")
public class TestFacadeImpl extends AbstractFacadeImpl implements TestFacade {
	@Resource
	private TestService testService;
	@Resource
	private TestFacadeConvertor testFacadeConvertor;
	
	@Override
	public TestResult test(TestOrder order) {
		logger.info("收到Facade请求！！！order={]", order);
		TestResult result = new TestResult();

		TestDomain domain = new TestDomain();
		try {
			chechOrder(order);
			testFacadeConvertor.convert(order, domain);
			
			//流程处理结果
			DefaultDomainResult domainResult = testService.test(domain);
			testFacadeConvertor.convert(domain, result);

		} catch (OpenApiException e) {
			handlerExceprion(e,result);
		} catch (Exception e) {
			handlerExceprion(e,result);
		}

		logger.info("[测试]处理完成，result={}\n\n", result);
		return result;
	}
}
