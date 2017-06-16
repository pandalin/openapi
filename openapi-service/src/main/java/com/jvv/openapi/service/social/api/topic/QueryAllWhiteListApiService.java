/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.api.topic;

import com.jvv.facade.social.circle.info.TopicWhiteInfo;
import com.jvv.facade.social.circle.result.TopicWhiteListResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.intergration.social.topic.TopicWhiteListClient;
import com.jvv.openapi.service.social.response.topic.QueryAllWhiteListResponseData;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/5/27
 * @time 13:43
 */
@OpenApiService (name = "queryWhiteList",desc = "获取白名单链接列表",responseType = ResponseTypeEnum.SYN)
public class QueryAllWhiteListApiService extends AbstractApiService<ApiRequest,ApiResponse>{
	
	@Resource
	private TopicWhiteListClient topicWhiteListClient;
	
	@Override
	protected void doService (ApiRequest request, ApiResponse response) {
		TopicWhiteListResult result = topicWhiteListClient.queryAllWhiteList ();
		response.injectResponse (result,response);
		QueryAllWhiteListResponseData data = new QueryAllWhiteListResponseData ();
		List<TopicWhiteInfo> list = result.getInfo ().getList ();
		if(list!=null){
			data.setList (list);
			response.setDatas (data);
		}
	}
}
