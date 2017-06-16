/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-24 19:57 创建
 *
 */
package com.jvv.openapi.core.service.marshall;

import com.jvv.openapi.core.service.ApiConstants;
import com.jvv.openapi.core.service.base.ApiService;
import com.jvv.openapi.core.service.base.InternalApiContextHolder;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ProtocolsEnum;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/24 19:57
 */

@Service
public class HttpNotifyMarshall extends AbstractResponseMarshall<Map<String, String>>
																						implements
																						ApiResponseMarshall<Map<String, String>> {
	
	@Override
	public Map<String, String> marshall(Object response) {
		ApiResponse apiResponse = (ApiResponse) response;
		ObjectAccessor objectAccessor = ObjectAccessor.of(apiResponse);
		Map<String, String> signData = perSignData(apiResponse, objectAccessor);
		doLogger(apiResponse, signData);
		return doMarshall(signData);
	}
	
	@Override
	protected Map<String, String> doMarshall(Map responseData) {
		return responseData;
	}
	
	@Override
	protected void doBeforeMarshall(ApiResponse apiResponse, Map data) {
		ApiService apiService = InternalApiContextHolder.getApiContext().getApiService();
		if (apiService == null) {
			// 框架执行层异常，未到服务处理层
			return;
		}
		
		data.remove(ApiConstants.SERVICE);
		data.remove(ApiConstants.VERSION);
		
		data.remove(ApiConstants.RESULT_CODE);
		data.remove(ApiConstants.RESULT_MESSAGE);
		
		data.remove(ApiConstants.PROTOCOL);
		data.remove(ApiConstants.PARTNER_ID);
	}
	
	@Override
	public String getProtocol() {
		return ProtocolsEnum.HTTP_POST.getCode();
	}
}
