/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.intergration.social.friend;

import com.jvv.common.services.result.SimpleResult;
import com.jvv.facade.social.friend.api.UserFriendApi;
import com.jvv.facade.social.friend.info.UserInfoFriendInfo;
import com.jvv.facade.social.friend.info.UserInfoInfo;
import com.jvv.facade.social.friend.order.CheckMutualFriendOrder;
import com.jvv.facade.social.friend.order.UserFriendOrder;
import com.jvv.facade.social.friend.order.UserFriendSimpleOrder;
import com.jvv.facade.social.friend.order.UserInfoFriendOrder;
import com.jvv.facade.social.friend.result.CheckMutualFriendResult;
import com.jvv.facade.social.friend.result.UserFriendResult;
import com.jvv.facade.social.friend.result.UserInfoFriendResult;
import com.jvv.facade.social.friend.result.UserInfoFriendTreeResult;
import com.jvv.openapi.intergration.Client;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * 〈远程调用客户端〉 <p>
 * 〈调用关注、粉丝 列表相关业务〉
 *
 * @author Huangw
 * @date 2017/4/7
 * @time 9:50
 */
@Component
public class UserFriendClient extends Client{
	/**
	 *  关注、粉丝列表
	 * @param order UserFriendOrder
	 * @return
	 */
	public UserFriendResult getUserFriendList(UserFriendOrder order){
		
		UserFriendApi api = getDubboClient (UserFriendApi.class);
		return api.getUserFriendList (order);
	}
	
	/**
	 * 查看共同的好友
	 * @param order
	 * @return
	 * */
	public CheckMutualFriendResult checkMutualFriend(CheckMutualFriendOrder order){
		UserFriendApi api = getDubboClient (UserFriendApi.class);
		return api.checkMutualFriend (order);
	}
	
	public UserInfoFriendTreeResult findFriendSimpleInfo (UserFriendSimpleOrder order){
		UserFriendApi api = getDubboClient (UserFriendApi.class);
		return api.findFriendSimpleInfo (order);
	}
	
	
	/**
	 * 通过手机搜索用户
	 * */
	public UserInfoFriendResult findUserByPhone(UserInfoFriendOrder order){
		UserFriendApi api = getDubboClient (UserFriendApi.class);
		return api.findUserByPhone (order);
		
	}
	
	/**
	 *   添加关注
	 */
	public UserInfoFriendResult addUserFriend(UserInfoFriendOrder order){
		
		UserFriendApi api = getDubboClient (UserFriendApi.class);
		return api.addUserFriend (order);
	}
	
	/**
	 *   取消关注 userId friendId
	 */
	public UserInfoFriendResult removeUserFriend(UserInfoFriendOrder order){
		UserFriendApi api = getDubboClient (UserFriendApi.class);
		return api.removeUserFriend (order);
	}
	
	/**
	 *   批量关注userId   friendId用逗号隔开
	 */
	public SimpleResult addUserFriendBatch(UserInfoFriendOrder order){
		UserFriendApi api = getDubboClient (UserFriendApi.class);
		return api.addUserFriendBatch (order);
	}
	
	/**
	 *   查看用户资料  userid 查看者id friendId 被查看者Id
	 */
	public UserInfoFriendTreeResult findUserInfoFriendByUserIdAndFriendId(UserInfoFriendOrder order){
		UserFriendApi api = getDubboClient (UserFriendApi.class);
		return api.findUserInfoFriendByUserIdAndFriendId (order);
	}
	/**
	 * 随机推荐20个好友
	 * */
	public UserInfoFriendResult findIntroduceUser(UserInfoFriendOrder order){
		UserFriendApi api = getDubboClient (UserFriendApi.class);
		return api.findIntroduceUser (order);
	}
	
	/**
	 * 设置备注
	 * */
	public SimpleResult modifyRemarkName(UserInfoFriendOrder order){
		UserFriendApi api = getDubboClient (UserFriendApi.class);
		return api.modifyRemarkName (order);
	}
	
	/**
	 * 查看与对方关系
	 * */
	public UserInfoFriendResult findFriendType(UserInfoFriendOrder order){
		UserFriendApi api = getDubboClient (UserFriendApi.class);
		return api.findFriendType (order);
	}
	
	public UserInfoFriendResult findMsgFriend(String userId){
		UserFriendApi api = getDubboClient (UserFriendApi.class);
		return api.findUserFriendRequest (userId);
	}
}

