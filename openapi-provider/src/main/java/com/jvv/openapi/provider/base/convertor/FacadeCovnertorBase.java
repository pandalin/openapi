/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-28 22:18 创建
 *
 */

package com.jvv.openapi.provider.base.convertor;

import com.jvv.openapi.common.base.CovnertorBase;
import com.jvv.openapi.domain.base.domain.OpenApiDomainBase;
import org.springframework.beans.BeanUtils;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/28 22:18
 */

public abstract class FacadeCovnertorBase extends CovnertorBase {
	public void convert(com.jvv.openapi.facade.base.OpenApiOrderBase order, OpenApiDomainBase domain) {
		BeanUtils.copyProperties(order, domain);
	}
	
	public void convert(OpenApiDomainBase domain, com.jvv.openapi.facade.base.OpenApiResultBase result) {
		BeanUtils.copyProperties(domain, result);
	}
}
