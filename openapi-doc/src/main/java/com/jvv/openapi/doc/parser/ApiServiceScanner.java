/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */

package com.jvv.openapi.doc.parser;

import java.util.List;

/**
 * Api服务扫描器
 * 
 * @author zhangpu
 *
 */
public interface ApiServiceScanner {

	List<Class<?>> scan(String packagePattern);

}
