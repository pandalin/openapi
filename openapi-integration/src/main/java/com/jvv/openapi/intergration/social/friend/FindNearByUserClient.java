/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.intergration.social.friend;

import com.jvv.facade.social.friend.api.UserFriendApi;
import com.jvv.facade.social.friend.api.UserNearByApi;
import com.jvv.facade.social.friend.order.UserFriendOrder;
import com.jvv.facade.social.friend.order.UserNearByOrder;
import com.jvv.facade.social.friend.result.UserFriendResult;
import com.jvv.facade.social.friend.result.UserNearByResult;
import com.jvv.openapi.intergration.Client;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/4/10
 * @time 14:51
 */
@Component
public class FindNearByUserClient extends Client {
	
	/**
	 *  附近的人
	 * @param order UserNearByOrder
	 * @return
	 */
	public UserNearByResult findNearByUser(UserNearByOrder order){
		
		UserNearByApi api = getDubboClient (UserNearByApi.class);
		return api.findNearByUser (order);
	}
}
