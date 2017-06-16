/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-18 21:39 创建
 *
 */
package com.jvv.openapi.assemble;


/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/18 21:39
 */

public class TomcatBootStrap {
	static {
//		System.setProperty("ylh.appName" , "openapi");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new TomcatBootstrapHelper (11001, false, "local").start();
	}
}
