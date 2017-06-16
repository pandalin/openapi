/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.intergration.customer.user;

import com.jvv.customer.facade.base.result.SimpleResult;
import com.jvv.customer.facade.user.api.UserParamApi;
import com.jvv.customer.facade.user.order.UserParamOrder;
import com.jvv.customer.facade.user.result.UserParamResult;
import com.jvv.openapi.intergration.Client;
import com.jvv.openapi.intergration.DubboClientFactory;
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
public class UserParamClient extends Client {
	
	/***
	 * 调用远程客户端。得到UserParam相关facade
	 * 返回result参数
	 * */
	/***
	 * 通过id查询字典
	 * */
	public UserParamResult findById(Long id){
		UserParamApi userParamApi = getDubboClient (UserParamApi.class);
		UserParamOrder order = new UserParamOrder ();
		order.setId (id);
		
		UserParamResult result = userParamApi.findById (order);
		return result;
	}
	/***
	 * 修改字典参数
	 * */
	public SimpleResult modify(UserParamOrder order){
		UserParamApi api = getDubboClient (UserParamApi.class);
		SimpleResult result = api.modify (order);
		return result;
	}
	/***
	* 显示隐藏字典参数(取代删除)
	* */
	public SimpleResult showOrHide(UserParamOrder order){
		UserParamApi api = getDubboClient (UserParamApi.class);
		SimpleResult result = api.showOrHide (order);
		return result;
	}
	/***
	 * 新增字典参数
	 * */
	public SimpleResult create(UserParamOrder order){
		UserParamApi api = getDubboClient (UserParamApi.class);
		SimpleResult result = api.create (order);
		return result;
	}
	/***
	 * 获取字典列表
	* */
	public UserParamResult query(UserParamOrder order,Long start,int pageSize){
		UserParamApi api = getDubboClient (UserParamApi.class);
		//查询可用的字典参数
		UserParamResult result = api.queryBycode (order, start, pageSize);
		return result;
	}
	
}
