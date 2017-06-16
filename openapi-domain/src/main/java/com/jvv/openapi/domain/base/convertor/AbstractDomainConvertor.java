/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-27 14:31 创建
 *
 */

package com.jvv.openapi.domain.base.convertor;

import com.jvv.openapi.dal.entity.Entity;
import com.jvv.openapi.domain.base.domain.OpenApiDomainBase;
import org.springframework.beans.BeanUtils;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/27 14:31
 */

public abstract class AbstractDomainConvertor<D extends OpenApiDomainBase, DO extends Entity> {
	
	public DO convert(D domain, DO dbDo) {
		BeanUtils.copyProperties(domain,dbDo);
		return dbDo;
	}
	
	public D convert(DO dbDo, D domain) {
		BeanUtils.copyProperties(dbDo,domain);
		return domain;
	}
}
