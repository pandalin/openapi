/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.test.service.test;

import com.jvv.common.lang.CollectionUtils;
import com.jvv.openapi.test.utils.HttpClientUtils;
import org.junit.Test;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author lxb
 * @date 2017/4/12
 * @time 15:31
 */
public class GroupInfoTest extends BaseTest {
	
	@Test
	public void create (){
		HttpClientUtils httpClientUtils = new HttpClientUtils();
		Map<String,String> map = new HashMap<String,String> ();
		map.put("token","69f07d54bbbea840d83240205004041d");
		map.put("groupType","Public");
		String str=" [" +
				"        {" +
				"            \"Member_Account\": \"20170322001000000055\"" +
				"        }" +
				"    ]";
		map.put("memberList",str);
//		map.put("groupIntroduce","lxb测试");
		
		map.put("service","CreateGroup");
		
		map.put("sign",sign (map));
		map.remove ("publicKey");
		
		try {
			String response = httpClientUtils.doPost("http://192.168.1.136:11001/service", map);
			System.out.println(response);
		}catch (Exception e){
			System.out.println ("请求失败"+e.getMessage ());
		}
	}
	
	@Test
	public void query (){
		HttpClientUtils httpClientUtils = new HttpClientUtils();
		Map<String,String> map = new HashMap<String,String> ();
		map.put("token","085b97e599f7da04093c7d86771d8f9e");
		map.put("condition","1");
		map.put ("start","1");
		map.put ("pageSize","10");
		
		map.put("service","queryGroup");
		
		map.put("sign",sign (map));
		map.remove ("publicKey");
		
		try {
			String response = httpClientUtils.doPost("http://192.168.1.8:6080/service", map);
			System.out.println(response);
		}catch (Exception e){
			System.out.println ("请求失败");
		}
	}
	
	/**
	 * @TGS#2YLWERYES
	 *
	 * @TGS#25G5ERYEF
	 *
	 *
	 */
	@Test
	public void remove(){
		HttpClientUtils httpClientUtils = new HttpClientUtils();
		Map<String,String> map = new HashMap<String,String> ();
		map.put("token","69f07d54bbbea840d83240205004041d");
		map.put("groupId","@TGS#25VW3RZEG");
		
		map.put("service","removeGroup");
		
		map.put("sign",sign (map));
		map.remove ("publicKey");
		
		try {
			String response = httpClientUtils.doPost("http://192.168.1.8:6080/service", map);
			System.out.println(response);
		}catch (Exception e){
			System.out.println ("请求失败"+e.getMessage ());
		}
	}
	
	@Test
	public void modify(){
		HttpClientUtils httpClientUtils = new HttpClientUtils();
		Map<String,String> map = new HashMap<String,String> ();
		//CollectionUtils.isNotEmpty ();
		map.put("groupId","@TGS#2IOABSYEM");
		map.put("groupIntroduce","lxb修改信息0503");
//		map.put("groupName","");
//		map.put("isAllBanned","");
//		map.put("isVerifyJoin","");
//		map.put("groupHeadImg","");
		
		map.put("service","ModifyGroup");
		
		map.put("sign",sign (map));
		map.remove ("publicKey");
		
		try {
			String response = httpClientUtils.doPost("http://192.168.1.8:6080/service", map);
			System.out.println(response);
		}catch (Exception e){
			System.out.println ("请求失败");
		}
	}
	
	
	
	
	public static Boolean fun(char i){
		System.out.println (i);
		return true;
	}
	//ABDCBDCB
	public static void main (String[] args) {
		//    System.out.println (getConstellation (8,30));
		int i=0;
		for(fun('A');fun ('B') && i<2;fun ('C')){
			i++;
			fun ('D');
		}
		
		
	}
	//1718  1737
	
	
	
	
	
}
