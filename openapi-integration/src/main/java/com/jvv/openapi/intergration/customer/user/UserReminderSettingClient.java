/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.intergration.customer.user;

import com.jvv.customer.facade.base.result.SimpleResult;
import com.jvv.customer.facade.user.api.UserReminderSettingApi;
import com.jvv.customer.facade.user.order.UserReminderSettingOrder;
import com.jvv.customer.facade.user.result.UserReminderSettingResult;
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
public class UserReminderSettingClient extends Client{
	
	/**
	 * 增加提醒设置信息
	 * */
	public SimpleResult add(UserReminderSettingOrder order){
		UserReminderSettingApi api = getDubboClient (UserReminderSettingApi.class);
		SimpleResult result = api.add (order);
		return result;
	}
	
	/**
	 * 移除一条用户设置信息
	 * @param order
	 * @return
	 */
	public SimpleResult remove(UserReminderSettingOrder order){
		UserReminderSettingApi api = getDubboClient (UserReminderSettingApi.class);
		SimpleResult result = api.remove (order);
		return result;
	}
	
	/**
	 * 通过用户id查询一个用户的提醒设置
	 * @param order
	 * @return
	 */
	public UserReminderSettingResult findByUserId(UserReminderSettingOrder order){
		UserReminderSettingApi api = getDubboClient (UserReminderSettingApi.class);
		UserReminderSettingResult result = api.findByUserId (order);
		return result;
	}
	
	/**
	 * 修改用户的提醒设置
	 * @param order
	 * @return
	 */
	public SimpleResult modify(UserReminderSettingOrder order){
		UserReminderSettingApi api = getDubboClient (UserReminderSettingApi.class);
		SimpleResult result = api.modify (order);
		return result;
	}
}
