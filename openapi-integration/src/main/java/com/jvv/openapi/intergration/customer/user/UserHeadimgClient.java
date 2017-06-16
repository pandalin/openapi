/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.intergration.customer.user;

import com.jvv.customer.facade.base.result.SimpleResult;
import com.jvv.customer.facade.user.api.UserHeadimgApi;
import com.jvv.customer.facade.user.order.UserHeadimgOrder;
import com.jvv.customer.facade.user.result.UserHeadimgResult;
import com.jvv.openapi.intergration.Client;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/3/23
 * @time 9:45
 */
@Component
public class UserHeadimgClient extends Client {
	
	/**
	 * 新添加一个头像
	 * */
	public SimpleResult uploadHeadImg(UserHeadimgOrder userHeadimgOrder) {
		UserHeadimgApi api = getDubboClient (UserHeadimgApi.class);
		return api.uploadHeadImg (userHeadimgOrder);
	}
	/**
	 * 删除头像
	 */
	public SimpleResult deleteHeadImg(UserHeadimgOrder userHeadimgOrder) {
		UserHeadimgApi api = getDubboClient (UserHeadimgApi.class);
		return api.deleteHeadImg (userHeadimgOrder);
	}
	
	/**
	 * 获取头像集合
	 */
	
	public UserHeadimgResult getHeadImgList(UserHeadimgOrder userHeadimgOrder){
		UserHeadimgApi api = getDubboClient (UserHeadimgApi.class);
		return api.getHeadImgList (userHeadimgOrder);
	}
	/**
	 * 设置默认头像
	 * */
	public SimpleResult setDefaultHeadImg (UserHeadimgOrder userHeadimgOrder){
		UserHeadimgApi api = getDubboClient (UserHeadimgApi.class);
		return api.setDefaultHeadImg (userHeadimgOrder);
	}
	/**
	 * 更新头像
	 * */
	public SimpleResult updateHeadimg (UserHeadimgOrder userHeadimgOrder){
		UserHeadimgApi api = getDubboClient (UserHeadimgApi.class);
		return api.updateHeadimg (userHeadimgOrder);
	}
	
}
