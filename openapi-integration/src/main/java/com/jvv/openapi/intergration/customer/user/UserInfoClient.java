/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.intergration.customer.user;

import com.jvv.customer.facade.base.result.SimpleResult;
import com.jvv.customer.facade.user.api.UserInfoApi;
import com.jvv.customer.facade.user.order.UserIdentityOrder;
import com.jvv.customer.facade.user.order.UserInfoAndRemarkOrder;
import com.jvv.customer.facade.user.order.UserInfoOrder;
import com.jvv.customer.facade.user.result.UserEncounterInfoResult;
import com.jvv.customer.facade.user.result.UserInfoLocateRemarkResult;
import com.jvv.customer.facade.user.result.UserInfoResult;
import com.jvv.openapi.intergration.Client;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author zhaoyk
 * @date
 * @time
 */

@Component
public class UserInfoClient extends Client{
	
	public UserInfoResult findUserListByPage(UserInfoOrder userInfoOrder , Long start , Integer pageSize){
		UserInfoApi api = getDubboClient (UserInfoApi.class);
		return api.findUserListByPage (userInfoOrder , start , pageSize);
	}
	
	public UserInfoResult findUserInfoByUserId(UserInfoOrder userInfoOrder){
		UserInfoApi api = getDubboClient (UserInfoApi.class);
		return api.findUserInfoByUserId (userInfoOrder);
	}
	
	public SimpleResult modifyUserIdentity(UserIdentityOrder order){
		UserInfoApi api = getDubboClient (UserInfoApi.class);
		return api.modifyUserIdentity (order);
	}
	
	/**
	 * 修改用户资料和扩展资料
	 */
	public SimpleResult modifyUserInfoAndRemark (UserInfoAndRemarkOrder order) {
		UserInfoApi api = getDubboClient (UserInfoApi.class);
		return api.modifyUserInfoAndRemark (order);
	}
	
	/**
	 * 根据userId获取用户详细资料
	 * */
	public UserInfoLocateRemarkResult findUserInfoLocateRemarkByUserId(String id){
		
		UserInfoApi api = getDubboClient (UserInfoApi.class);
		return api.findUserInfoLocateRemarkByUserId (id);
	}

	/**
	 * 查邂逅要的用户资料
	 * @param userId
	 * @return
	 */
	public UserEncounterInfoResult findUserEncounterDetailsByUserId(String userId) {
		UserInfoApi api = getDubboClient (UserInfoApi.class);
		return api.findUserEncounterDetailsByUserId (userId);
	}
	/**
	 * 补填推荐人
	 */
	
	public SimpleResult addRecommend (UserInfoOrder order){
		UserInfoApi api = getDubboClient (UserInfoApi.class);
		return api.addRecommend (order);
	}
	/**
	 * 修改用户信息
	 * */
	public SimpleResult modifyUserInfo(UserInfoOrder order){
		UserInfoApi api = getDubboClient (UserInfoApi.class);
		return api.modifyUserInfo (order);
	}
}
