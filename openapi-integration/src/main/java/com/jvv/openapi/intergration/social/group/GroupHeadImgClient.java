/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.intergration.social.group;

import com.jvv.common.services.result.SimpleResult;

import com.jvv.facade.group.api.GroupHeadImgApi;
import com.jvv.facade.group.order.GroupHeadImgOrder;
import com.jvv.facade.group.result.GroupHeadImgResult;
import com.jvv.openapi.intergration.Client;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/4/13
 * @time 11:56
 */
@Component
public class GroupHeadImgClient extends Client {
	
	/**
	 * 上传群头像
	 * */
	public SimpleResult uploadHeadImg (GroupHeadImgOrder userHeadimgOrder){
		GroupHeadImgApi api = getDubboClient (GroupHeadImgApi.class);
		return api.uploadHeadImg (userHeadimgOrder);
	}
	/**
	 * 删除群头像
	 * */
	public SimpleResult deleteHeadImg (GroupHeadImgOrder userHeadimgOrder){
		GroupHeadImgApi api = getDubboClient (GroupHeadImgApi.class);
		return api.deleteHeadImg (userHeadimgOrder);
	}
	/**
	 * 获取群头像列表
	 * */
	public GroupHeadImgResult getHeadImgList (GroupHeadImgOrder userHeadimgOrder){
		GroupHeadImgApi api = getDubboClient (GroupHeadImgApi.class);
		return api.getHeadImgList (userHeadimgOrder);
	}
	/**
	 * 设置默认头像
	 * */
	public SimpleResult setDefaultHeadImg (GroupHeadImgOrder userHeadimgOrder){
		GroupHeadImgApi api = getDubboClient (GroupHeadImgApi.class);
		return api.setDefaultHeadImg (userHeadimgOrder);
	}
	/**
	 * 更新群头像
	 * */
	public SimpleResult updateHeadimg (GroupHeadImgOrder userHeadimgOrder){
		GroupHeadImgApi api = getDubboClient (GroupHeadImgApi.class);
		return api.updateHeadimg (userHeadimgOrder);
	}
}
