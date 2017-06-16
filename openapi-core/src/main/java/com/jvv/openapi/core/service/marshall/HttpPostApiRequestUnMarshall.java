/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-24 19:59 创建
 *
 */
package com.jvv.openapi.core.service.marshall;

import com.google.common.base.Strings;
import com.jvv.openapi.core.service.ApiConstants;
import com.jvv.openapi.core.service.base.ApiContextHolder;
import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.enums.ProtocolsEnum;
import com.jvv.openapi.core.service.marshall.crypt.ApiMarshallCryptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/24 19:59 增加对部分隐私加密信息解密功能
 */

@Service
public class HttpPostApiRequestUnMarshall implements ApiRequestUnMarshall<HttpServletRequest> {
	private static final Logger logger = LoggerFactory
		.getLogger (HttpPostApiRequestUnMarshall.class);
	
	@Autowired
	private ApiMarshallCryptService apiMarshallCryptService;
	
	@Override
	public ApiRequest unmarshall(HttpServletRequest request, ApiRequest apiRequest) {
		Map<String, String> requestData = ApiContextHolder.getApiContext().getRequestData();
		ObjectAccessor<ApiRequest> objectAccessor = ObjectAccessor.of(apiRequest);
		String value = null;
		String partnerId = requestData.get(ApiConstants.PARTNER_ID);
		for (Map.Entry<String, String> entry : requestData.entrySet()) {
			value = entry.getValue();
			if (!Strings.isNullOrEmpty(value)) {
				if (objectAccessor.isSecurityField(entry.getKey())) {
					value = apiMarshallCryptService.decrypt(entry.getKey(), value, partnerId);
				}
				objectAccessor.setPropertyValue(entry.getKey(), value);
			}
		}
		return apiRequest;
	}
	
	@Override
	public String getProtocol() {
		return ProtocolsEnum.HTTP_POST.toString();
	}
}
