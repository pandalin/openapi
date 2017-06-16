/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-24 19:42 创建
 *
 */
package com.jvv.openapi.core.service.marshall;

import com.jvv.openapi.core.service.entity.ApiRequest;

/**
 * 请求报文组装接口
 *
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/24 19:42
 */

public interface ApiRequestUnMarshall<REQ> {
	
	public ApiRequest unmarshall(REQ request, ApiRequest apiRequest);
	
	public String getProtocol();
}
