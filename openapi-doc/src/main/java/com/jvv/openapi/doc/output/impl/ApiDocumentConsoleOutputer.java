/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */

package com.jvv.openapi.doc.output.impl;

import com.alibaba.fastjson.JSON;
import com.jvv.openapi.doc.ApidocContext;
import com.jvv.openapi.doc.output.ApiDocumentOutputer;
import com.jvv.openapi.doc.output.ApiOutputerEnum;
import com.jvv.openapi.doc.persist.db.domain.ApiServiceDoc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * JDBC输出实现
 * <p/>
 * Created by zhangpu on 2015/2/26.
 */
@Service
public class ApiDocumentConsoleOutputer implements ApiDocumentOutputer<String> {
	private static final Logger logger = LoggerFactory.getLogger(ApiDocumentConsoleOutputer.class);

	@Override
	public String output(List<ApiServiceDoc> apiServiceDocs, ApidocContext apidocContext) {
		String console = JSON.toJSONString(apiServiceDocs, true);
		logger.info(console);
		return console;
	}

	@Override
	public String getName() {
		return ApiOutputerEnum.Console.name();
	}
}
