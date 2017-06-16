/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.intergration.customer.user;

import com.jvv.customer.facade.base.result.SimpleResult;
import com.jvv.customer.facade.user.api.UserRealnameCheckInfoApi;
import com.jvv.customer.facade.user.order.UserRealnameCheckOrder;
import com.jvv.customer.facade.user.result.UserRealnameCheckResult;
import com.jvv.openapi.intergration.Client;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/3/16
 * @time 16:35
 */
@Component
public class UserRealnameCheckClient extends Client {
	
	/**
	 * 新增一条实名认证管理记录
	 * @param order UserRealnameCheckOrder对象
	 */
	public SimpleResult insertUserRealnameCheck (UserRealnameCheckOrder order){
		UserRealnameCheckInfoApi api = getDubboClient (UserRealnameCheckInfoApi.class);
		return api.insertUserRealnameCheck (order);
	}
	
	/**
	 * 查询实名认证管理的记录列表
	 *
	 * @param realname 真实姓名（可空）
	 * @param status   状态
	 * @param Start
	 * @param pageSize
	 */
	public UserRealnameCheckResult selectUserRealnameCheck (String realname, Long status, Long Start, Integer pageSize) {
		UserRealnameCheckInfoApi api = getDubboClient (UserRealnameCheckInfoApi.class);
		return api.selectUserRealnameCheck (realname, status, Start, pageSize);
	}
	
	/**
	 * 提交审核
	 *
	 * @param id
	 */
	public SimpleResult commitUserRealnameCheck (long id) {
		UserRealnameCheckInfoApi api = getDubboClient (UserRealnameCheckInfoApi.class);
		return api.commitUserRealnameCheck (id);
	}
}
