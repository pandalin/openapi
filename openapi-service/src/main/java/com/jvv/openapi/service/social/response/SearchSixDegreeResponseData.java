/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.response;

import com.jvv.facade.sixdegree.info.SearchSixDegreeInfo;
import com.jvv.openapi.core.service.entity.AbstractResponseData;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/4/19
 * @time 11:08
 */
public class SearchSixDegreeResponseData extends AbstractResponseData{
	
	List<SearchSixDegreeInfo> searchSixDegreeInfoList;
	
	public List<SearchSixDegreeInfo> getSearchSixDegreeInfoList () {
		return searchSixDegreeInfoList;
	}
	
	public void setSearchSixDegreeInfoList (
			List<SearchSixDegreeInfo> searchSixDegreeInfoList) {
		this.searchSixDegreeInfoList = searchSixDegreeInfoList;
	}
	
}
