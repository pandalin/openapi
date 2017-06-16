/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.response.third;

import com.jvv.openapi.core.service.entity.AbstractResponseData;

import java.util.Date;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author lxb
 * @date 2017/3/15
 * @time 10:32
 */
public class UserThirdResponseData extends AbstractResponseData {
	/**
	 * id
	 */
	protected Long id;
	/**
	 * 用户ID
	 */
	protected String userId;
	/**
	 * 手机号
	 */
	protected String userPhone;
	/**
	 * 第三方绑定类型
	 */
	protected String thirdType;
	/**
	 * 用户的三方帐户唯一标识(记录的unionid)
	 */
	protected String openid;
	/**
	 * 多微信公众平台时用户的唯一标识区分(记录的openid)
	 */
	protected String unionid;
	/**
	 * 备注信息
	 */
	protected String remark;
	
	/**
	 * 创建时间
	 */
	protected Date createtime;
	/**
	 * 创建人
	 */
	protected String creator;
	/**
	 * 修改人
	 */
	protected String updater;
	/**
	 * 修改时间
	 */
	protected Date updatetime;
	
	public Long getId () {
		return id;
	}
	
	public void setId (Long id) {
		this.id = id;
	}
	
	public String getUserId () {
		return userId;
	}
	
	public void setUserId (String userId) {
		this.userId = userId;
	}
	
	public String getUserPhone () {
		return userPhone;
	}
	
	public void setUserPhone (String userPhone) {
		this.userPhone = userPhone;
	}
	
	public String getThirdType () {
		return thirdType;
	}
	
	public void setThirdType (String thirdType) {
		this.thirdType = thirdType;
	}
	
	public String getOpenid () {
		return openid;
	}
	
	public void setOpenid (String openid) {
		this.openid = openid;
	}
	
	public String getUnionid () {
		return unionid;
	}
	
	public void setUnionid (String unionid) {
		this.unionid = unionid;
	}
	
	public String getRemark () {
		return remark;
	}
	
	public void setRemark (String remark) {
		this.remark = remark;
	}
	
	/**
	 * 返回 创建时间
	 */
	public Date getCreatetime() {
		return createtime;
	}
	
	/**
	 * 设置 创建时间
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
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
	/**
	 * 返回 修改人
	 */
	public String getUpdater() {
		return updater;
	}
	
	/**
	 * 设置 修改人
	 */
	public void setUpdater(String updater) {
		this.updater = updater;
	}
	/**
	 * 返回 修改时间
	 */
	public Date getUpdatetime() {
		return updatetime;
	}
	
	/**
	 * 设置 修改时间
	 */
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	
	
	
}
