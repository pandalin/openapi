/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.response;

import com.jvv.facade.group.info.QueryGroupInfo;
import com.jvv.facade.group.info.QueryGroupList;
import com.jvv.openapi.core.service.entity.AbstractResponseData;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/4/6
 * @time 17:16
 */
public class QueryGroupResponseData extends AbstractResponseData{
	
	private List<QueryGroupInfo> queryGroupInfoList;
	
	public List<QueryGroupInfo> getQueryGroupInfoList () {
		return queryGroupInfoList;
	}
	
	public void setQueryGroupInfoList (List<QueryGroupInfo> queryGroupInfoList) {
		this.queryGroupInfoList = queryGroupInfoList;
	}
}
