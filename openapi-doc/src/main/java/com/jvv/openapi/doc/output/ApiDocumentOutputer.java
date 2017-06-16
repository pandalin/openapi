/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */

package com.jvv.openapi.doc.output;

import com.jvv.openapi.doc.ApidocContext;
import com.jvv.openapi.doc.persist.db.domain.ApiServiceDoc;

import java.util.List;

/**
 * API文档输出接口 Created by zhangpu on 2015/1/27.
 */
public interface ApiDocumentOutputer<T> {

	T output(List<ApiServiceDoc> apiServiceDocs, ApidocContext apidocContext);

	String getName();

}
