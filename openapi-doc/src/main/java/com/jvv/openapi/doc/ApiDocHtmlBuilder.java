/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */

package com.jvv.openapi.doc;

import com.jvv.openapi.doc.builder.ApiDocBuilder;
import com.jvv.openapi.doc.parser.ApiDocumentParser;
import com.jvv.openapi.doc.persist.db.domain.ApiServiceDoc;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author xinqing@jinvovo.com
 *
 * @date   2015年7月20日
 */
public class ApiDocHtmlBuilder {
	public static void main(String[] args){
		//整合到项目中，通过管理页面运行生成doc，或者每次修改服务接口后，手动生成doc
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath*:spring/openapi-services.xml");
		ApiDocumentParser parser =  context.getBean(ApiDocumentParser.class);
		List<ApiServiceDoc> docs = parser.parse("classpath*:com/jvv/openapi/**/*.class");

		for(ApiServiceDoc doc:docs){
			System.out.println(doc);
		}

		String output = "file:///d:/doc";


		ApiDocBuilder apiDocBuilder =  context.getBean(
				ApiDocBuilder.class);
		ApidocContext apicontext = new ApidocContext();
		apicontext.setSubTitle("金窝窝");
//		apicontext.appendLink("Openfire文档", "help/openfire_spec.htm");
//		apicontext.appendLink("APP原型", "http://acooly.wicp.net/1119/rp/");
//		apicontext.appendLink("APP下载(测试)", "http://www.1119e.com:8080/app/index.html");
		apiDocBuilder.HtmlBuilder(output, apicontext,docs);
	}
}
