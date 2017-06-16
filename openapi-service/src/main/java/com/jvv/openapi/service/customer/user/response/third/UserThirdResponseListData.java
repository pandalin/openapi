/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.response.third;

import com.jvv.openapi.core.service.entity.AbstractResponseData;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author lxb
 * @date 2017/3/15
 * @time 14:06
 */
public class UserThirdResponseListData extends AbstractResponseData {
	/**
	 * 返回的是info信息集合
	 */
	List<UserThirdResponseData> list;
	
	public List<UserThirdResponseData> getList () {
		return list;
	}
	
	public void setList (List<UserThirdResponseData> list) {
		this.list = list;
	}
}
