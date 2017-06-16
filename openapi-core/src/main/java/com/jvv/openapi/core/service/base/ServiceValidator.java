/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-22 20:32 创建
 *
 */
package com.jvv.openapi.core.service.base;

import java.util.Map;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/22 20:32
 */

public interface ServiceValidator {
	void validate(Map<String, String> requestData);
}
