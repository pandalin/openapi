/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */

package com.jvv.openapi.doc.parser;

import com.jvv.openapi.doc.persist.db.domain.ApiServiceDoc;

import java.util.List;

/**
 * API文档自动生成 接口定义
 * 
 * @author zhangpu
 *
 */
public interface ApiDocumentParser {

	List<ApiServiceDoc> parse(String packagePattern);

	
}
