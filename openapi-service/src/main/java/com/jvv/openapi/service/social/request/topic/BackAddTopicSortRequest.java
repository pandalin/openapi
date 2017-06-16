/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.request.topic;

import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.meta.OpenApiField;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author lxb
 * @date 2017/5/18
 * @time 15:29
 */
public class BackAddTopicSortRequest extends ApiRequest {
	
	/**
	 * 增加的圈子分类名称
	 */
	
	@NotBlank
	@OpenApiField(desc = "圈子分类名称")
	protected  String tagName;
	
	public String getTagName () {
		return tagName;
	}
	
	public void setTagName (String tagName) {
		this.tagName = tagName;
	}
}
