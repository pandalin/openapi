/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-22 20:37 创建
 *
 */
package com.jvv.openapi.core.service.validator;

import com.jvv.openapi.core.exception.FrameworkException;
import com.jvv.openapi.core.service.base.ApiServiceResultCode;
import com.jvv.openapi.core.service.enums.SchemeEnum;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/22 20:37
 */

public class UrlValidator {
	private static org.apache.commons.validator.routines.UrlValidator httpUrlValidator = null;
	
	static {
		String[] schemes = { SchemeEnum.HTTP.getCode(), SchemeEnum.HTTPS.getCode() };
		httpUrlValidator = new org.apache.commons.validator.routines.UrlValidator(schemes);
	}
	
	public static boolean isHttpUrl(String str) {
		
		return httpUrlValidator.isValid(str);
	}
	
	public static void checkOpenAPIUrl(String str, String name) {
		if (isHttpUrl(str)) {
			// 暂时屏蔽对URL中?的限制 on 20151022
			//			if (str.contains("?")) {
			//				throw new ApiServiceException(ApiServiceResultCode.PARAMETER_ERROR, "必须传入格式正确的" + name + "参数,请求参数不能包含?");
			//			}
		} else {
			throw new FrameworkException(ApiServiceResultCode.PARAMETER_ERROR,
				"必须传入格式正确的" + name + "参数[如：连续两个'/';非通用域名;包含有汉字等]");
		}
		
	}
}
