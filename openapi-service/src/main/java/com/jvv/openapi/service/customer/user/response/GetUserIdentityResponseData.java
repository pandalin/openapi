/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.response;

import com.jvv.customer.facade.user.info.UserParamInfo;
import com.jvv.openapi.core.service.entity.AbstractResponseData;
import com.jvv.openapi.core.service.meta.OpenApiField;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/3/21
 * @time 14:54
 */
public class GetUserIdentityResponseData extends AbstractResponseData {
	
	private List<UserParamInfo> boyList;
	private List<UserParamInfo> girList;
	
	public List<UserParamInfo> getBoyList () {
		return boyList;
	}
	
	public void setBoyList (List<UserParamInfo> boyList) {
		this.boyList = boyList;
	}
	
	public List<UserParamInfo> getGirList () {
		return girList;
	}
	
	public void setGirList (List<UserParamInfo> girList) {
		this.girList = girList;
	}
}
