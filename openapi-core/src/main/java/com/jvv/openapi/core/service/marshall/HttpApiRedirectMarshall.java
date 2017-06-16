/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-24 19:55 创建
 *
 */
package com.jvv.openapi.core.service.marshall;

import com.jvv.openapi.core.service.ApiConstants;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.entity.ISign;
import com.jvv.openapi.core.service.enums.ProtocolsEnum;
import com.jvv.openapi.core.util.ServletUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 跳转下层服务报文组装
 *
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/24 19:55
 */

@Service("httpApiRedirectMarshall")
public class HttpApiRedirectMarshall extends AbstractResponseMarshall<String> implements ApiResponseMarshall<String> {

	@Override
	public String marshall(Object response) {
		ApiResponse apiResponse = (ApiResponse) response;
		Map<String, String> responseData = ObjectAccessor.of(apiResponse).getAllDataExcludeTransient();
		doSign(apiResponse, responseData);
		if(apiResponse instanceof ISign) {
			ISign signObject = (ISign)apiResponse;
			signObject.setSign (responseData.get (ApiConstants.SIGN));
		}
		doLogger(apiResponse, responseData);
		return doMarshall(responseData);
	}

	protected String getLogLabel(ApiResponse apiResponse) {
		String labelPostfix = (StringUtils.isNotBlank (apiResponse.getService ()) ? "[" + apiResponse.getService() + "]:"
				: ":");
		return "服务跳转" + labelPostfix;
	}

	@Override
	protected String doMarshall(Map responseData) {
		return ServletUtils.buildQueryString ((Map<String, String>) responseData);
	}

	@Override
	protected void doBeforeMarshall(ApiResponse apiResponse, Map data) {

	}

	@Override
	public String getProtocol() {
		return ProtocolsEnum.HTTP_POST.getCode ();
	}
}
