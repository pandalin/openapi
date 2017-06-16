/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-25 20:34 创建
 *
 */
package com.jvv.openapi.service.demo.test.api;

import com.jvv.customer.facade.demo.info.DemoUserInfo;
import com.jvv.customer.facade.demo.result.DemoUserResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.AbstractResponseData;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.intergration.demo.DemoClient;
import com.jvv.openapi.service.demo.test.request.TestRequest;
import com.jvv.openapi.service.demo.test.response.TestResponse;
import com.jvv.openapi.service.demo.test.response.TestResponseData;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;

/**
 * http://127.0.0.1:11001/service?service=test&system=IOS&clientType=DRIVER&serialNo=12341234123411414&deviceId=123456&sign=7ae19d1004ee2e261c17a0402e2fef29
 *
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/25 20:34
 */
@OpenApiService(name = "test", desc = "测试例子", responseType = ResponseTypeEnum.SYN)
public class TestApiSrevice extends AbstractApiService<TestRequest, TestResponse> {
	
	@Resource
	private DemoClient demoClient;

	@Override
	protected void doService(TestRequest request, TestResponse response) {

		DemoUserResult result = demoClient.getUserById(request.getUserId());

		response.setStatus(result.getStatus().getCode());
		response.setMessage(result.getMessage());
		response.setDetailMessage(result.getMessage());

		DemoUserInfo userInfo = result.getInfo();

		if (userInfo != null) {
			AbstractResponseData responseData = convertFrom(userInfo);
			response.setDatas(responseData);
		}
	}
	
	private AbstractResponseData convertFrom(DemoUserInfo userInfo) {
		TestResponseData responseData = new TestResponseData();
		BeanUtils.copyProperties(userInfo, responseData, "status");
		responseData.setStatus(userInfo.getStatus().getCode());
		return responseData;
	}
	
}
