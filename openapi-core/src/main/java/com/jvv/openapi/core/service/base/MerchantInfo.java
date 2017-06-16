/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2017-03-13 20:57 创建
 *
 */
package com.jvv.openapi.core.service.base;

import com.jvv.openapi.dal.entity.MerchantDO;
import org.springframework.beans.BeanUtils;

/**
 * @author turalyon@jinvovo.com
 */
public class MerchantInfo extends MerchantDO {

	public static MerchantInfo convertFrom(MerchantDO dbDo){
		if(dbDo==null){
			return null;
		}

		MerchantInfo info = new MerchantInfo();

		BeanUtils.copyProperties(dbDo,info);

		return info;
	}
}
