/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */

package com.jvv.openapi.doc.builder;

import com.google.common.collect.Lists;
import com.jvv.openapi.doc.ApidocContext;
import com.jvv.openapi.doc.output.ApiDocumentOutputer;
import com.jvv.openapi.doc.output.ApiDocumentOutputerFactory;
import com.jvv.openapi.doc.output.ApiOutputerEnum;
import com.jvv.openapi.doc.output.impl.ApiDocumentHtmlOutputer;
import com.jvv.openapi.doc.parser.ApiDocumentParser;
import com.jvv.openapi.doc.persist.db.domain.ApiServiceDoc;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;

/**
 * Created by zhangpu on 2015/1/29.
 */
@Service
public class ApiDocBuilderImpl implements ApiDocBuilder {

	private static final Logger logger = LoggerFactory.getLogger(ApiDocBuilderImpl.class);
	List<String> packageList = Lists.newArrayList();
	@Resource
	private ApiDocumentParser apiDocumentParser;

	@Resource
	private ApiDocumentOutputerFactory apiDocumentOutputerFactory;


	@Override
	public void HtmlBuilder(String output, ApidocContext apidocContext,List<ApiServiceDoc> docs) {
		ApiDocumentHtmlOutputer outputer = (ApiDocumentHtmlOutputer) apiDocumentOutputerFactory
				.getOutputer(ApiOutputerEnum.Html);
		long startTime = System.currentTimeMillis();
		if (StringUtils.isNotBlank(output)) {
			outputer.setOutputPath(output);
		}

		//输出文档
		doOutput(outputer, docs, apidocContext);

		logger.info("文档生成完成......耗时：" + (System.currentTimeMillis() - startTime) +"ms");

	}



	protected List<ApiServiceDoc> getApiDocs(String packagePartern) {
		return apiDocumentParser.parse(packagePartern);
	}

	public void getChildrenPackage(String path) {
		File file = new File(path);
		if (file.exists() && file.isDirectory()) {
			File[] tempList = file.listFiles();
			if (tempList.length > 0) {
				for (int i = 0; i < tempList.length; i++) {
					if (tempList[i].isDirectory()) {
						getChildrenPackage(tempList[i].getPath());
					} else if (tempList[i].isFile() && !packageList.contains(file.getPath())) {
						packageList.add(file.getPath());
					}
				}
			}
		} else {
			throw new IllegalArgumentException("Directory " + path + " does not exist or is not a" +
											   " directory");
		}

	}

	protected String getRelativePackage(String path, String packagePartern) {
		if (StringUtils.contains(path, "\\api")) {
			path = StringUtils.substringAfter(path, "\\api");
			path = packagePartern + path;
			path = path + "/*";
			path = path.replaceAll("\\\\", "/");
		}
		return path;
	}

	private void doOutput(ApiDocumentOutputer outputer, List<ApiServiceDoc> docs, ApidocContext apidocContext) {
		try {
			outputer.output(docs, apidocContext);
		} catch (Exception e) {
			logger.error("ApiOutpuer处理异常: outpuer:{},message:{}", outputer.getName(), e.getMessage());
		}
	}

	public ApiDocumentParser getApiDocumentParser() {
		return apiDocumentParser;
	}

	public void setApiDocumentParser(ApiDocumentParser apiDocumentParser) {
		this.apiDocumentParser = apiDocumentParser;
	}

	public ApiDocumentOutputerFactory getApiDocumentOutputerFactory() {
		return apiDocumentOutputerFactory;
	}

	public void setApiDocumentOutputerFactory(ApiDocumentOutputerFactory apiDocumentOutputerFactory) {
		this.apiDocumentOutputerFactory = apiDocumentOutputerFactory;
	}

}
