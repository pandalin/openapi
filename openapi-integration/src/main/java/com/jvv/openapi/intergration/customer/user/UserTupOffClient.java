/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.intergration.customer.user;

import com.jvv.common.services.result.SimpleResult;
import com.jvv.facade.social.friend.api.UserTipOffApi;
import com.jvv.facade.social.friend.order.UserTipOffOrder;
import com.jvv.openapi.intergration.Client;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/4/25
 * @time 9:27
 */
@Component
public class UserTupOffClient extends Client {
	/**
	 * 举报
	 * */
	public SimpleResult addUserTupOffService(UserTipOffOrder order){
		UserTipOffApi api = getDubboClient (UserTipOffApi.class);
		return api.addUserTupOffService (order);
	}
	
}

