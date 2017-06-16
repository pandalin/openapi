/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.intergration.customer.user;

import com.jvv.customer.facade.base.result.SimpleResult;
import com.jvv.customer.facade.user.api.UserLoginAndRegistApi;
import com.jvv.customer.facade.user.order.UserRegisterOrder;
import com.jvv.customer.facade.user.result.UserInfoResult;
import com.jvv.openapi.intergration.Client;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/3/17
 * @time 14:24
 */
@Component
public class UserLoginAndRegistClient extends Client {
	
	
	/**
	 * 登陆/注册（验证码）统一进入方法
	 * */
	public UserInfoResult loginOrRegister(UserRegisterOrder order){
		UserLoginAndRegistApi api = getDubboClient (UserLoginAndRegistApi.class,5000);
		return api.loginOrRegister (order);
	}
	/**
	 * 注册
	 * */
	public SimpleResult registeredUser(UserRegisterOrder order){
		
		UserLoginAndRegistApi api = getDubboClient (UserLoginAndRegistApi.class,5000);
		return api.registeredUser (order);
	}
	/**
	 * 登陆（账号密码）
	 * */
	public UserInfoResult loginByPassword(String userPhone,String password,String sysType ,String pushMsgid){
		UserLoginAndRegistApi api = getDubboClient (UserLoginAndRegistApi.class,5000);
		return api.loginByPassword (userPhone, password, sysType , pushMsgid);
	}
	
}
