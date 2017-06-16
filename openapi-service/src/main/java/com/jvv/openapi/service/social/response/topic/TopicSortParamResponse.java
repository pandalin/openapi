/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.response.topic;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author lxb
 * @date 2017/5/17
 * @time 16:50
 */
public class TopicSortParamResponse {
	/**
	 * 分类码
	 */
	protected Long sortCode;
	/**
	 * 值
	 */
	protected String sortValue;
	
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
}
