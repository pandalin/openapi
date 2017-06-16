/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.response;

import com.jvv.openapi.core.service.entity.AbstractResponseData;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/3/15
 * @time 19:38
 */
public class UserLoginLogsResponseData extends AbstractResponseData {
	/**
	 * 返回集合
	 * */
	
	private List list;
	
		
	public List getList () {
		return list;
	}
	
	public void setList (List infos) {
		this.list = infos;
	}
	
}
