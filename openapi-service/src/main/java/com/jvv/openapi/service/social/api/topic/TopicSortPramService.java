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
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.intergration.social.topic.TopicSortClient;
import com.jvv.openapi.service.social.request.topic.TopicSortParamRequest;
import com.jvv.openapi.service.social.response.topic.TopicSortParamResponse;
import com.jvv.openapi.service.social.response.topic.TopicSortParamResponseData;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈前端内容  〉
 *  social  :查询前后台标签标识 0.后台标签  1.前台标签
 * @author lxb
 * @date 2017/5/17
 * @time 16:46
 */
@OpenApiService(name = "getSort", desc = "获取圈子分类" , responseType = ResponseTypeEnum.SYN)
public class TopicSortPramService  extends AbstractApiService<TopicSortParamRequest,ApiResponse> {
	@Autowired
	private TopicSortClient topicSortClient;
	@Autowired
	private TokenUtils tokenUtils;
	
	@Override
	protected void doService (TopicSortParamRequest request, ApiResponse response) {
		String userId=tokenUtils.getUserIdByToken (request.getToken ());
		
		TopicSortParamResult result=topicSortClient.getSort ("1");
		//System.out.println(result.toString ());
		if(result!=null && result.getList ()!=null){
			TopicSortParamResponseData data=new TopicSortParamResponseData ();
			List<TopicSortParamResponse> list=new ArrayList<> ();
			for(TopicSortParamInfo info:result.getList ()){
				TopicSortParamResponse sortParamResponse=new TopicSortParamResponse ();
				BeanUtils.copyProperties (info,sortParamResponse);
				list.add (sortParamResponse);
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
