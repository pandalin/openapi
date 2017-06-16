/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.test.servlet;

import com.jvv.openapi.common.util.MD5Utils;
import org.apache.log4j.MDC;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author linxm
 * @date 2017/3/14
 * @time 13:08
 */
public class Test extends Thread {
	
	private int i;
	
	public Test(int i) {
		this.i = i;
	}
	
	@Override
	public void run () {
		MDC.put ("username","123".toString ());
		System.out.println ("1");
	}
	
	public static void main (String[] args) {
		
		System.out.println (MD5Utils.getMD5 ("chongqi24200iphone6ADADA-498934-KDJJKJK123123.12312,123123.1231wubangxinA95D40FA-3BBC-4ED5-A499-2DD1494FA75214762017031512300100000192912351face7d5d52497016e7865c052ac051testIOS10.2vip456"));
	}
}
