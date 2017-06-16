/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.intergration.social.sixDegree;

import com.jvv.facade.sixdegree.api.UserTreeApi;
import com.jvv.facade.sixdegree.order.FindSixDegreeDataOrder;
import com.jvv.facade.sixdegree.order.SearchSixDegreeOrder;
import com.jvv.facade.sixdegree.result.FindSixDegreeDataResult;
import com.jvv.facade.sixdegree.result.SearchSixDegreeResult;
import com.jvv.openapi.intergration.Client;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/4/19
 * @time 11:11
 */
@Component
public class UserTreeClient extends Client{
	
	public SearchSixDegreeResult searchSixDegree(SearchSixDegreeOrder order){
		UserTreeApi api = getDubboClient (UserTreeApi.class);
		return api.searchSixDegree (order);
	}
	
	public FindSixDegreeDataResult findSixDegreeData(FindSixDegreeDataOrder order){
		UserTreeApi api = getDubboClient (UserTreeApi.class);
		return api.findSixDegreeData (order);
	}
	
}
