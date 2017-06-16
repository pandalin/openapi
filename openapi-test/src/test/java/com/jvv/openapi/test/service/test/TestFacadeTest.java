/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-27 11:37 创建
 *
 */

package com.jvv.openapi.test.service.test;

import javax.annotation.Resource;

import com.jvv.openapi.facade.test.api.TestFacade;
import com.jvv.openapi.facade.test.order.TestOrder;
import com.jvv.openapi.facade.test.result.TestResult;
import com.jvv.openapi.test.OpenApiTestJunit4Test;
import org.junit.Test;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/27 11:37
 */
public class TestFacadeTest extends OpenApiTestJunit4Test {
	@Resource
	private TestFacade testServiceClient;


	@Test
	public void testTest(){
		TestOrder order = new TestOrder ();
		order.setUserName ("TestFacadeName");
		TestResult result = testServiceClient.test (order);
		System.out.println (result);
	}

}
