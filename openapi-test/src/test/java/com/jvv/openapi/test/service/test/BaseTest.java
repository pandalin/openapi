/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.test.service.test;

import com.jvv.openapi.common.util.MD5Utils;
import com.jvv.openapi.test.utils.Md5Util;

import java.util.*;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author lxb
 * @date 2017/3/15
 * @time 16:02
 */
public class BaseTest {
	/**
	 *Map<String,String> map = new HashMap<String,String> ();
	 map.put ("buildVersion","4.3.1");
	 map.put ("device","xx");
	 map.put ("deviceId","12221122");
	 map.put("openid","22");
	 //map.put("id","9");
	 map.put("orderNo","PC784545854545888");
	 
	 map.put ("partnerId","20170315123001000001");
	 //map.put("publicKey","51face7d5d52497016e7865c052ac051");
	 map.put("service","thirdLogin");
	 //map.put("SecurityCode","54687");//待短信系统开通后 添加验证码验证
	 map.put ("signType","MD5");
	 map.put ("system","PC");
	 map.put ("systemVersion","4.1.2");
	 map.put ("thirdType","QQ");
	 map.put ("userPhone","11045805103");
	 
	 map.put("sign","78f8223dc95c900cca975bae39dcaf8a");
	 
	 map顺序排序，去除value拼接的字符串
	 * @param map
	 * @return
	 */
	public String sign(Map<String,String> map){
		map.put ("buildVersion","4.3.1");
		map.put ("device","xx");
		map.put ("deviceId","12221122");
		map.put ("partnerId","20170315123001000001");
		map.put("publicKey","51face7d5d52497016e7865c052ac051");
		map.put ("signType","MD5");
		map.put ("system","PC");
		map.put ("systemVersion","4.1.2");
		Integer orderNo=(int)(Math.random ()*9000)+1000;
		map.put("orderNo","LXBPC784545854540"+orderNo.toString ());
		//map.put("orderNo",orderNo.toString ());
		StringBuilder builder=new StringBuilder ("");
		for(String str:sort (map)){
			//System.out.println (str);
			builder.append (map.get (str));
		}
		//System.out.println (builder.toString ());
		return Md5Util.toMD5 (builder.toString ());
	}
	
	public List<String> sort(Map<String,String> map)   {
		List<String> list   =   new ArrayList<String> (map.keySet());
		Collections.sort(list, new   Comparator ()   {
			public   int   compare(Object   a,   Object   b)   {
				return   a.toString().compareTo(b.toString());
			}
		});
		return list;
	}
	
	public static void main(String[] args){
		new BaseTest ().sign (new HashMap<String, String> ());
	}
	
}
