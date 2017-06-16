/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.intergration.social.Interpersonal;

import com.jvv.facade.social.friend.api.UserInterpersonalApi;
import com.jvv.facade.social.friend.order.UserInterpersonalOrder;
import com.jvv.facade.social.friend.result.UserInterpersonalResult;
import com.jvv.openapi.intergration.Client;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author lxb
 * @date 2017/4/11
 * @time 9:59
 */
@Component
public class UserInterpersonalClient extends Client {
	public UserInterpersonalResult queryUserInterpersonal(UserInterpersonalOrder order){
		UserInterpersonalApi userInterpersonalApi=getDubboClient (UserInterpersonalApi.class);
		return userInterpersonalApi.queryUserInterpersonal (order);
	}
}
