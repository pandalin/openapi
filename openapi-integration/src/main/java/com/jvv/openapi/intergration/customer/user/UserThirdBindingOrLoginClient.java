/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.intergration.customer.user;

import com.jvv.customer.facade.base.result.SimpleResult;
import com.jvv.customer.facade.user.api.UserThirdBindingApi;
import com.jvv.customer.facade.user.order.UserThirdBindingOrder;
import com.jvv.customer.facade.user.result.UserInfoResult;
import com.jvv.customer.facade.user.result.UserThirdBindingResult;
import com.jvv.openapi.intergration.Client;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author lxb
 * @date 2017/3/15
 * @time 9:20
 */
@Component
public class UserThirdBindingOrLoginClient extends Client {
	
	public UserThirdBindingResult queryOne(UserThirdBindingOrder order){
		//UserThirdBindingApi userThirdBindingApi=getDubboClien (UserThirdBindingApi.class,DUBBO_DEFUALT_GROUP,"1.0");
		UserThirdBindingApi userThirdBindingApi=getDubboClient (UserThirdBindingApi.class);
		return userThirdBindingApi.query (order);
		
	}
	
	public UserThirdBindingResult findByUserId(UserThirdBindingOrder order){
//		UserThirdBindingApi userThirdBindingApi=getDubboClien (UserThirdBindingApi.class,DUBBO_DEFUALT_GROUP,"1.0");
		UserThirdBindingApi userThirdBindingApi=getDubboClient (UserThirdBindingApi.class);
		return userThirdBindingApi.findByUserid (order);
	}
	
	public SimpleResult remove(UserThirdBindingOrder order){
//		UserThirdBindingApi userThirdBindingApi=getDubboClien (UserThirdBindingApi.class,DUBBO_DEFUALT_GROUP,"1.0");
		UserThirdBindingApi userThirdBindingApi=getDubboClient (UserThirdBindingApi.class);
		return userThirdBindingApi.removeThirdBinding (order);
	}
	
	public UserInfoResult binding(UserThirdBindingOrder order){
//		UserThirdBindingApi userThirdBindingApi=getDubboClien (UserThirdBindingApi.class,DUBBO_DEFUALT_GROUP,"1.0");
		UserThirdBindingApi userThirdBindingApi=getDubboClient (UserThirdBindingApi.class);
		return userThirdBindingApi.bingding (order);
	}
	
	public UserInfoResult thirdLogin(UserThirdBindingOrder order){
//		UserThirdBindingApi userThirdBindingApi=getDubboClien (UserThirdBindingApi.class,DUBBO_DEFUALT_GROUP,"1.0");
		UserThirdBindingApi userThirdBindingApi=getDubboClient (UserThirdBindingApi.class);
		return  userThirdBindingApi.thirdLogin (order);
	}
	
	
}
