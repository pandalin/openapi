/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.response;

import com.jvv.openapi.core.service.entity.AbstractResponseData;

import java.util.Date;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/4/7
 * @time 14:33
 */
public class CheckGroupResponseData extends AbstractResponseData{
	
	//------群信息
	/**
	 * 群聊ID
	 */
	protected String groupId;
	/**
	 * 群头像
	 */
	protected String groupHeadImg;
	/**
	 * 群号
	 */
	protected Long groupNumber;
	/**
	 * 群名称
	 */
	protected String groupName;
	
	/**
	 * 群介绍
	 */
	protected String groupIntroduce;
	
	
	/**
	 * 群创建时间
	 */
	protected Date createtime;
	
	/**
	 * 是否需要验证入群  false:否   true:是
	 */
	protected Boolean isVerifyJoin;
	
	/**
	 * 是否全体禁言   0:否   1:是
	 */
	protected Boolean isAllBanned;
	
	/**
	 * 创建人
	 */
	protected String creator;
	
	//-------查看群用户信息
	
	//	/**
	//	 * 群权限（1:群主、2:管理员、3:普通成员、4:非群成员）
	//	 */
	//	protected String groupJurisdiction;
	//
	/**
	 * 用户在本群的昵称()
	 */
	protected String groupNickname;
	
	/**
	 * 消息免打扰    false:打扰  true:免打扰 ()
	 */
	protected Boolean isDisturb;
	
	public String getGroupId () {
		return groupId;
	}
	
	public void setGroupId (String groupId) {
		this.groupId = groupId;
	}
	
	public String getGroupHeadImg () {
		return groupHeadImg;
	}
	
	public void setGroupHeadImg (String groupHeadImg) {
		this.groupHeadImg = groupHeadImg;
	}
	
	public Long getGroupNumber () {
		return groupNumber;
	}
	
	public void setGroupNumber (Long groupNumber) {
		this.groupNumber = groupNumber;
	}
	
	public String getGroupName () {
		return groupName;
	}
	
	public void setGroupName (String groupName) {
		this.groupName = groupName;
	}
	
	public String getGroupIntroduce () {
		return groupIntroduce;
	}
	
	public void setGroupIntroduce (String groupIntroduce) {
		this.groupIntroduce = groupIntroduce;
	}
	
	public Date getCreatetime () {
		return createtime;
	}
	
	public void setCreatetime (Date createtime) {
		this.createtime = createtime;
	}
	
	public Boolean getIsVerifyJoin () {
		return isVerifyJoin;
	}
	
	public void setIsVerifyJoin (Boolean isVerifyJoin) {
		this.isVerifyJoin = isVerifyJoin;
	}
	
	/**
	 * 返回 是否全体禁言   0:否   1:是
	 */
	public Boolean getIsAllBanned() {
		return isAllBanned;
	}
	
	/**
	 * 设置 是否全体禁言   0:否   1:是
	 */
	public void setIsAllBanned(Boolean isAllBanned) {
		this.isAllBanned = isAllBanned;
	}
	
	/**
	 * 返回 创建人
	 */
	public String getCreator() {
		return creator;
	}
	
	/**
	 * 设置 创建人
	 */
	public void setCreator(String creator) {
		this.creator = creator;
	}
	
	public String getGroupNickname () {
		return groupNickname;
	}
	
	public void setGroupNickname (String groupNickname) {
		this.groupNickname = groupNickname;
	}
	
	public Boolean getIsDisturb () {
		return isDisturb;
	}
	
	public void setDisturb (Boolean isDisturb) {
		this.isDisturb = isDisturb;
	}

}
