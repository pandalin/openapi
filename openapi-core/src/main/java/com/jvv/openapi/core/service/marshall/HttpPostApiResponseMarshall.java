/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-24 20:00 创建
 *
 */
package com.jvv.openapi.core.service.marshall;

import com.jvv.openapi.core.service.ApiConstants;
import com.jvv.openapi.core.service.base.ApiService;
import com.jvv.openapi.core.service.base.InternalApiContextHolder;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ProtocolsEnum;
import com.jvv.openapi.core.service.marshall.json.JsonMarshallor;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 响应报文组装
 *
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/24 20:00
 */

@Service
public class HttpPostApiResponseMarshall extends AbstractResponseMarshall<String>
																					implements
																					ApiResponseMarshall<String> {
	
	@Override
	protected String doMarshall(Map<String, Object> responseData) {
		return JsonMarshallor.INSTANCE.marshall(responseData);
	}
	
	@Override
	protected void doBeforeMarshall(ApiResponse apiResponse, Map data) {
		ApiService apiService = InternalApiContextHolder.getApiContext().getApiService();
		if (apiService == null) {
			// 框架执行层异常，未到服务处理层
			return;
		}
		
		data.remove(ApiConstants.VERSION);
		data.remove(ApiConstants.PROTOCOL);
		data.remove(ApiConstants.SERVICE);
		data.remove(ApiConstants.PARTNER_ID);
	}
	
	@Override
	public String getProtocol() {
		return ProtocolsEnum.HTTP_POST.getCode();
	}
}
