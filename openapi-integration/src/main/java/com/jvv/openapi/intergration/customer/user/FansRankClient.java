/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.intergration.customer.user;

import com.jvv.customer.facade.user.api.FansRankApi;
import com.jvv.customer.facade.user.order.UserFansRankOrder;
import com.jvv.customer.facade.user.order.UserVipLogOrder;
import com.jvv.customer.facade.user.result.UserFansRankResult;
import com.jvv.customer.facade.user.result.UserVipLogResult;
import com.jvv.openapi.intergration.Client;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date
 * @time
 */
@Component
public class FansRankClient extends Client {
	
	public UserFansRankResult fansCountRank(UserFansRankOrder order, Long start, int pageSize){
		FansRankApi api = getDubboClient (FansRankApi.class);
		UserFansRankResult result = api.fansCountRank (order, start, pageSize);
		return result;
	}
	
	public UserVipLogResult vipCountRank(UserVipLogOrder order,Long start,int pageSize){
		FansRankApi api = getDubboClient (FansRankApi.class);
		UserVipLogResult result = api.vipCountRank (order, start, pageSize);
		return result;
	}
}
