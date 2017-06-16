/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.requset;

import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.meta.OpenApiField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 UserParam 字典相关接口request
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date
 * @time
 */
public class UserParamRequest extends ApiRequest{
	
	@OpenApiField(desc = "字典ID")
	protected Long id;
	
	/**
	 * 参数代码
	 */
	
	@OpenApiField(desc = "字典分类码")
	protected String code;
	/**
	 * 参数名称
	 */
	@OpenApiField(desc = "字典分类名")
	protected String name;
	/**
	 * 参数KEY
	 */
	@OpenApiField(desc = "字典参数key值")
	protected String paramKey;
	/**
	 * 参数值
	 */
	@OpenApiField(desc = "字典参数值")
	protected String paramValue;
	/**
	 * 是否可用 0:不用  1:可用
	 */
	@OpenApiField(desc = "是否可用")
	protected Integer isUse;
	/**
	 * 创建时间
	 */
	@OpenApiField(desc = "创建时间")
	protected Date createtime;
	/**
	 * 创建人
	 */
	@OpenApiField(desc = "创建人")
	protected String creator;
	/**
	 * 修改人
	 */
	 
	protected String updater;
	/**
	 * 修改时间
	 */
	@OpenApiField(desc = "修改时间")
	protected Date updatetime;
	/**
	 * 分页参数，起始索引
	 * */
	@OpenApiField(desc = "分页起始索引")
	protected Long start;
	/**
	 * 分页参数，每页条数
	 * */
	@OpenApiField(desc = "分页页条数")
	protected Integer pageSize;
	
	@OpenApiField(desc = "性别")
	protected Integer level;
	//========== getters and setters ==========
	
	
	public Integer getLevel () {
		return level;
	}
	
	public void setLevel (Integer level) {
		this.level = level;
	}
	
	public Long getStart () {
		return start;
	}
	
	public void setStart (Long start) {
		this.start = start;
	}
	
	public Integer getPageSize () {
		return pageSize;
	}
	
	public void setPageSize (Integer pageSize) {
		this.pageSize = pageSize;
	}
	
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
	
	public Long getId () {
		return id;
	}
	
	public void setId (Long id) {
		this.id = id;
	}
		
}
