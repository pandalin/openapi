/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-26 16:54 创建
 *
 */
package com.jvv.openapi.facade.test.api;

import com.jvv.openapi.facade.test.order.TestOrder;
import com.jvv.openapi.facade.test.result.TestResult;

import javax.jws.WebService;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/26 16:54
 */
@WebService
public interface TestFacade {

	public TestResult test(TestOrder order);
}
