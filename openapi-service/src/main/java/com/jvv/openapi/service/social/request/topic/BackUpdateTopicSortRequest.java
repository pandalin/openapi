/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.request.topic;

import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.meta.OpenApiField;

import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author lxb
 * @date 2017/5/18
 * @time 15:31
 */
public class BackUpdateTopicSortRequest extends ApiRequest {
	
	/**
	 * 分类码
	 */
	@NotNull
	@OpenApiField(desc = "圈子分类编码")
	protected Integer sortCode;
	/**
	 * 值
	 */
	@OpenApiField(desc = "圈子分类名称")
	protected String sortValue;
	/**
	 * 备注
	 */
	@OpenApiField(desc = "圈子分类描述")
	protected String remark;
	/**
	 * 创建人
	 */
	@OpenApiField(desc = "圈子分类创建人")
	protected String creator;
	/**
	 * 修改人
	 */
	@OpenApiField(desc = "圈子分类更新人")
	protected String updater;
	
	public Integer getSortCode () {
		return sortCode;
	}
	
	public void setSortCode (Integer sortCode) {
		this.sortCode = sortCode;
	}
	
	public String getSortValue () {
		return sortValue;
	}
	
	public void setSortValue (String sortValue) {
		this.sortValue = sortValue;
	}
	
	public String getRemark () {
		return remark;
	}
	
	public void setRemark (String remark) {
		this.remark = remark;
	}
	
	public String getCreator () {
		return creator;
	}
	
	public void setCreator (String creator) {
		this.creator = creator;
	}
	
	public String getUpdater () {
		return updater;
	}
	
	public void setUpdater (String updater) {
		this.updater = updater;
	}
}
