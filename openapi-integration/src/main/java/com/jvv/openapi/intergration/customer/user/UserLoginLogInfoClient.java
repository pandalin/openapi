/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.intergration.customer.user;

import com.jvv.customer.facade.base.result.SimpleResult;
import com.jvv.customer.facade.demo.api.DemoUserApi;
import com.jvv.customer.facade.demo.order.DemoUserOrder;
import com.jvv.customer.facade.user.api.UserLoginInfoApi;
import com.jvv.customer.facade.user.order.UserLoginLogOrder;
import com.jvv.customer.facade.user.result.UserLoginLogResult;
import com.jvv.openapi.intergration.Client;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA
 * 〈远程调用客户端〉 <p>
 * 〈调用登陆日志相关业务〉
 *
 * @author Huangw
 * @date 2017/3/15
 * @time 14:57
 */
@Component
public class UserLoginLogInfoClient extends Client{
	/**
	 * 提交登陆日志业务
	 * @param order UserLoginLogOrder
	 * @return
	 */
	public SimpleResult commitUserLoginLog(UserLoginLogOrder order){
		
		UserLoginInfoApi api = getDubboClient (UserLoginInfoApi.class);
		
		return api.commitUserLoginLog (order);
		
	}
	
	
	/**
	 * 查询所有登陆日志
	 * @param start 起始索引值
	 * @param pageSize 每页包含数量
	 * */
	public UserLoginLogResult queryUserLoginLogs(Long start, Integer pageSize){
		
		UserLoginInfoApi api = getDubboClient (UserLoginInfoApi.class);
		
		return api.queryUserLoginLogs (start, pageSize);
	}
}
