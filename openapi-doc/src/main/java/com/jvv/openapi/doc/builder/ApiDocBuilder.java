/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */

package com.jvv.openapi.doc.builder;

import com.jvv.openapi.doc.ApidocContext;
import com.jvv.openapi.doc.persist.db.domain.ApiServiceDoc;

import java.util.List;

/**
 * Created by zhangpu on 2015/1/29.
 */
public interface ApiDocBuilder {

	void HtmlBuilder(String output, ApidocContext apidocContext, List<ApiServiceDoc> docs);
}
