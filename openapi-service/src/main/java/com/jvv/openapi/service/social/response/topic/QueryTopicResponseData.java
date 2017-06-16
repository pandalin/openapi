/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.response.topic;

import com.jvv.facade.social.circle.info.QueryTopicInfo;
import com.jvv.openapi.core.service.entity.AbstractResponseData;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/5/17
 * @time 16:37
 */
public class QueryTopicResponseData extends AbstractResponseData {
	/**
	 * 返回查看的时间点
	 * 如果来查看的用户没有传入时间点：返回时查看时的系统时间
	 * 如果用户查看时是传入了时间点：那么返回就是上传的时间点
	 */
	protected Long date;
	
	/**
	 * 圈子信息集合
	 */
	protected List<QueryTopicInfo> list;
	
	public Long getDate () {
		return date;
	}
	
	public void setDate (Long date) {
		this.date = date;
	}
	
	public List<QueryTopicInfo> getList () {
		return list;
	}
	
	public void setList (List<QueryTopicInfo> list) {
		this.list = list;
	}
}
