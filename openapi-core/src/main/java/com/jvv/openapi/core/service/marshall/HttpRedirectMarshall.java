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

import com.jvv.openapi.core.service.enums.ProtocolsEnum;
import com.jvv.openapi.core.util.ServletUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/24 20:00
 */

@Service
public class HttpRedirectMarshall implements ApiResponseMarshall<String> {
	
	@Override
	public String marshall(Object response) {
		return ServletUtils.buildQueryString((Map<String, String>) response);
	}
	
	@Override
	public String getProtocol() {
		return ProtocolsEnum.HTTP_POST.getCode();
	}
}
