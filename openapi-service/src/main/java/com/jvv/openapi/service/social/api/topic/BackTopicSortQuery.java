/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.api.topic;

import com.jvv.common.lang.CollectionUtils;
import com.jvv.facade.social.circle.info.TopicSortParamInfo;
import com.jvv.facade.social.circle.result.TopicSortParamResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.intergration.social.topic.TopicSortClient;
import com.jvv.openapi.service.social.response.topic.BackTopicSortQueryResponse;
import com.jvv.openapi.service.social.response.topic.BackTopicSortQueryResponseData;
import com.jvv.openapi.service.social.response.topic.TopicSortParamResponse;
import com.jvv.openapi.service.social.response.topic.TopicSortParamResponseData;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈提供给后台〉
 *
 * @author lxb
 * @date 2017/5/18
 * @time 14:47
 */
@OpenApiService(name = "queryBackTopicSort", desc = "后台获取圈子分类" , responseType = ResponseTypeEnum.SYN)
public class BackTopicSortQuery extends AbstractApiService<ApiRequest,ApiResponse> {
	
	@Autowired
	private TopicSortClient topicSortClient;
	
	@Override
	protected void doService (ApiRequest request, ApiResponse response) {
		
		TopicSortParamResult result=topicSortClient.getSort ("0");
		if(result!=null && result.getList ()!=null){
			BackTopicSortQueryResponseData data=new BackTopicSortQueryResponseData ();
			List<BackTopicSortQueryResponse> list=new ArrayList<> ();
			for(TopicSortParamInfo info:result.getList ()){
				BackTopicSortQueryResponse backTopicSortQueryResponse=new BackTopicSortQueryResponse ();
				BeanUtils.copyProperties (info, backTopicSortQueryResponse);
				list.add (backTopicSortQueryResponse);
			}
			if(CollectionUtils.isNotEmpty (list)){
				data.setList (list);
				response.setDatas (data);
			}
		}
		
		response.setStatus (result.getStatus ().code ());
		response.setCode (result.getCode ());
		response.setMessage (result.getMessage ());
		response.setDetailMessage (result.getDescription ());
	}
}
