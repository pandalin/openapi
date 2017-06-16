/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.response.topic;

import com.jvv.openapi.core.service.entity.AbstractResponseData;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author lxb
 * @date 2017/5/18
 * @time 14:52
 */
public class BackTopicSortQueryResponse extends AbstractResponseData{
	
	/**
	 * 分类码
	 */
	protected Long sortCode;
	/**
	 * 值
	 */
	protected String sortValue;
	
	/**
	 * 圈子总动态数量
	 * */
	protected Integer count;
	
	
	public Long getSortCode () {
		return sortCode;
	}
	
	public void setSortCode (Long sortCode) {
		this.sortCode = sortCode;
	}
	
	public String getSortValue () {
		return sortValue;
	}
	
	public void setSortValue (String sortValue) {
		this.sortValue = sortValue;
	}
	
	public Integer getCount () {
		return count;
	}
	
	public void setCount (Integer count) {
		this.count = count;
	}
}
