/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-23 21:09 创建
 *
 */
package com.jvv.openapi.core.service.base;

import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.listener.ApiEventPublisher;
import com.jvv.openapi.core.service.listener.event.ServiceEvent;

/**
 * ApiService 服务处理框架接口
 *
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/23 21:09
 */

public interface ApiService<REQ extends ApiRequest, RES extends ApiResponse>
																				extends
																				ApiEventPublisher<ServiceEvent> {
	
	void service(REQ request, RES response);
	
	REQ getRequestBean();
	
	RES getResponseBean();
	
}
