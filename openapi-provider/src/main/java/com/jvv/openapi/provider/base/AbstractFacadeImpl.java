/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-26 16:57 创建
 *
 */
package com.jvv.openapi.provider.base;

import com.jvv.openapi.common.exception.CheckOrderException;
import com.jvv.openapi.common.exception.OpenApiException;
import com.jvv.openapi.facade.base.AbstractOrder;
import com.jvv.openapi.facade.base.OpenApiResultBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/26 16:57
 */

public abstract class AbstractFacadeImpl {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	public void chechOrder(AbstractOrder order, Class<?>... groups) {
		if (order == null) {
			throw new CheckOrderException("Order is Null");
		}
		try {
			order.check(groups);
		} catch (Exception e) {
			throw new CheckOrderException("Order is Null", e);
		}
	}
	
	public void handlerExceprion(OpenApiException exception, OpenApiResultBase result) {
		logger.info("业务处理异常！", exception);
	}
	
	public void handlerExceprion(Exception exception, OpenApiResultBase result) {
		logger.info("业务处理异常！", exception);
	}

}
