/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.response;

import com.jvv.customer.facade.user.info.UserParamInfo;
import com.jvv.openapi.core.service.entity.AbstractResponseData;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date
 * @time
 */
public class UserParamResponseData extends AbstractResponseData {
	
	protected Long id;
	/**
	 * 参数代码
	 */
	protected String code;
	/**
	 * 参数名称
	 */
	protected String name;
	/**
	 * 参数KEY
	 */
	protected String paramKey;
	/**
	 * 参数值
	 */
	protected String paramValue;
	/**
	 * 是否可用 0:不用  1:可用
	 */
	protected Integer isUse;
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
	/**
	 * 返回相应info集合
	 * */
	protected List<UserParamInfo> userParamInfos;
	
	protected long count;
	
	protected Integer level;
	//========== getters and setters ==========
	public Integer getLevel () {
		return level;
	}
	
	public void setLevel (Integer level) {
		this.level = level;
	}
	
	public long getCount () {
		return count;
	}
	
	public void setCount (long count) {
		this.count = count;
	}
	
	public List<UserParamInfo> getUserParamInfos () {
		return userParamInfos;
	}
	
	public void setUserParamInfos (List<UserParamInfo> userParamInfos) {
		this.userParamInfos = userParamInfos;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {this.id = id;}
	/**
	 * 返回 参数代码
	 */
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置 参数代码
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 返回 参数名称
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 参数名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 返回 参数KEY
	 */
	public String getParamKey() {
		return paramKey;
	}
	
	/**
	 * 设置 参数KEY
	 */
	public void setParamKey(String paramKey) {
		this.paramKey = paramKey;
	}
	/**
	 * 返回 参数值
	 */
	public String getParamValue() {
		return paramValue;
	}
	
	/**
	 * 设置 参数值
	 */
	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}
	/**
	 * 返回 是否可用 0:不用  1:可用
	 */
	public Integer getIsUse() {
		return isUse;
	}
	
	/**
	 * 设置 是否可用 0:不用  1:可用
	 */
	public void setIsUse(Integer isUse) {
		this.isUse = isUse;
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
