/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2017-03-12 22:22 创建
 *
 */
package com.jvv.openapi.facade.base;

import com.jvv.openapi.facade.constants.validation.ValidateUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author turalyon@jinvovo.com
 */
public abstract class AbstractOrder implements Serializable {
	/**
	 * 校验Order
	 *
	 * @param groups
	 */
	public void check(Class<?>... groups) {
		ValidateUtils.check(this, groups);
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
