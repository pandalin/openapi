/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.api.topic;

import com.jvv.common.lang.CollectionUtils;
import com.jvv.facade.social.circle.info.TopicSortParamInfo;
import com.jvv.facade.social.circle.result.TopicSortParamResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.intergration.social.topic.TopicSortClient;
import com.jvv.openapi.service.social.request.topic.BackGetTagByCodeRequest;
import com.jvv.openapi.service.social.response.topic.BackTopicSortQueryResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author lxb
 * @date 2017/5/31
 * @time 11:38
 */
@OpenApiService(name = "queryTopicSortByCode", desc = "后台根据code获得单个圈子分类信息" , responseType = ResponseTypeEnum.SYN)
public class BackGetTopicSortService extends AbstractApiService<BackGetTagByCodeRequest,ApiResponse> {
	
	@Autowired
	private TopicSortClient topicSortClient;
	
	@Override
	protected void doService (BackGetTagByCodeRequest request, ApiResponse response) {
		TopicSortParamResult result=topicSortClient.getSortByCode (request.getSortCode ().longValue ());
		TopicSortParamInfo info=result.getInfo ();
		
		BackTopicSortQueryResponse data=new BackTopicSortQueryResponse ();
		
		if(info!=null){
			BeanUtils.copyProperties (info,data);
			response.setDatas (data);
		}
		
		response.setStatus (result.getStatus ().code ());
		response.setCode (result.getCode ());
		response.setMessage (result.getMessage ());
		response.setDetailMessage (result.getDescription ());
	}
}
