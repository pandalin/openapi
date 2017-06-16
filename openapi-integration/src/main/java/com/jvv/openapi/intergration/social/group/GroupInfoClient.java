/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.intergration.social.group;

import com.jvv.common.services.result.SimpleResult;
import com.jvv.facade.group.api.GroupInfoApi;
import com.jvv.facade.group.order.CheckGroupOrder;
import com.jvv.facade.group.order.GroupInfoOrder;
import com.jvv.facade.group.order.QueryGroupOrder;
import com.jvv.facade.group.result.CheckGroupResult;
import com.jvv.facade.group.result.QueryGroupResult;
import com.jvv.facade.group.result.QueryIMGroupIdResult;
import com.jvv.openapi.intergration.Client;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/4/6
 * @time 16:32
 */
@Component
public class GroupInfoClient extends Client{
	
	/**
	 * 按条件查找群（群号码和群名称）
	 * */
	public QueryGroupResult queryGroup(QueryGroupOrder order){
		GroupInfoApi api = getDubboClient (GroupInfoApi.class);
		return api.queryGroup (order);
	}
	
	/**
	 * 查看群信息
	 * */
	public CheckGroupResult checkGroup(CheckGroupOrder order){
		GroupInfoApi api = getDubboClient (GroupInfoApi.class);
		return api.checkGroup(order);
	}
	
	/**
	 * 移除群
	 * @param order
	 * @return
	 */
	public SimpleResult removeGroup(GroupInfoOrder order){
		GroupInfoApi api=getDubboClient (GroupInfoApi.class,5000);
		return api.removeGroup (order);
	}
	
	/**
	 * 创建群
	 * @param order
	 * @return
	 */
	public CheckGroupResult createGroup(GroupInfoOrder order){
		GroupInfoApi api=getDubboClient (GroupInfoApi.class);
		return api.createGroup (order);
	}
	
	/**
	 * 修改群信息
	 * @param order
	 * @return
	 */
	public SimpleResult modifyGroup(GroupInfoOrder order){
		GroupInfoApi api=getDubboClient (GroupInfoApi.class,5000);
		return api.modifyGroup (order);
	}
	
	public QueryIMGroupIdResult getIMGroupIdByGroupNum(Long groupNum){
		GroupInfoApi api = getDubboClient (GroupInfoApi.class);
		return api.getIMGroupIdByGroupNum (groupNum);
	}
}
