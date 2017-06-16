/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-24 19:39 创建
 *
 */
package com.jvv.openapi.core.service.marshall;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/24 19:39
 */

public interface ApiMarshall<S, T> {
	
	T marshall(S s);
}
