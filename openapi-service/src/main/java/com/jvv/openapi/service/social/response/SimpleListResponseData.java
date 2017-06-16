/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.response;

import com.jvv.facade.social.friend.info.UserNearByInfo;
import com.jvv.openapi.core.service.entity.AbstractResponseData;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/4/10
 * @time 14:47
 */
public class SimpleListResponseData extends AbstractResponseData {
	private List list;
	
	public List getList () {
		return list;
	}
	
	public void setList (List list) {
		this.list = list;
	}
}
