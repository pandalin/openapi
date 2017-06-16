/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.response;

import com.jvv.openapi.core.service.entity.AbstractResponseData;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/4/7
 * @time 14:03
 */
public class UserFriendResponseData extends AbstractResponseData {
	/**
	 * 对方ID
	 */
	protected String friendId;
	/**
	 * 关系类型  1:关注 2:粉丝  3:好友  4:无关系(互相取消关注)
	 */
	protected Long friendType;
	/**
	 * 好友备注名
	 */
	protected String nameRemark;
	
	private List list;

	/**
	 * 当前服务器时间
	 */
	private String currentTime;
	
	public String getFriendId () {
		return friendId;
	}
	
	public void setFriendId (String friendId) {
		this.friendId = friendId;
	}
	
	public Long getFriendType () {
		return friendType;
	}
	
	public void setFriendType (Long friendType) {
		this.friendType = friendType;
	}
	
	public String getNameRemark () {
		return nameRemark;
	}
	
	public void setNameRemark (String nameRemark) {
		this.nameRemark = nameRemark;
	}
	
	public List getList () {
		return list;
	}
	
	public void setList (List list) {
		this.list = list;
	}

	public String getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(String currentTime) {
		this.currentTime = currentTime;
	}
}
