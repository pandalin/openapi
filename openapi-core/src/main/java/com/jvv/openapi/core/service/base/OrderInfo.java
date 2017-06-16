/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2017-03-13 21:34 创建
 *
 */
package com.jvv.openapi.core.service.base;

import com.alibaba.fastjson.JSON;
import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.dal.entity.OrderInfoDO;
import org.springframework.beans.BeanUtils;

/**
 * @author turalyon@jinvovo.com
 */
public class OrderInfo extends OrderInfoDO {
	public static OrderInfo convertFrom(ApiRequest apiRequest) {
		if (apiRequest == null) {
			return null;
		}

		OrderInfo info = new OrderInfo();

		BeanUtils.copyProperties(apiRequest, info, "orderNo");
		info.setMerchantOrderNo(apiRequest.getOrderNo());
		info.setRequestParams(JSON.toJSONString(apiRequest));
		info.setServiceName(apiRequest.getService());
		info.setServiceVersion(apiRequest.getVersion());
		return info;
	}
}
