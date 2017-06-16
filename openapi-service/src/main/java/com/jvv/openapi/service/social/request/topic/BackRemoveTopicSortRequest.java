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
 * @time 15:30
 */
public class BackRemoveTopicSortRequest extends ApiRequest {
	
	/**
	 * 圈子分类的编码
	 */
	@NotNull
	@OpenApiField(desc = "圈子分类编码")
	protected Integer sortCode;
	
	
	public Integer getSortCode () {
		return sortCode;
	}
	
	public void setSortCode (Integer sortCode) {
		this.sortCode = sortCode;
	}
}
