/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.intergration.social.topic;

import com.jvv.common.services.result.SimpleResult;
import com.jvv.facade.social.circle.api.TopicSortParamApi;
import com.jvv.facade.social.circle.order.TopicSortParamOrder;
import com.jvv.facade.social.circle.result.TopicSortParamResult;
import com.jvv.openapi.intergration.Client;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author lxb
 * @date 2017/5/17
 * @time 17:00
 */
@Component
public class TopicSortClient extends Client {
	
	/**
	 * 通过code获得分类信息
	 * @param code
	 * @return
	 */
	public TopicSortParamResult getSortByCode(Long code){
		TopicSortParamApi topicSortParamApi=getDubboClient (TopicSortParamApi.class);
		return topicSortParamApi.getTag(code);
	}
	
	
	/**
	 * @param mark
	 * @return
	 */
	public TopicSortParamResult getSort(String mark){
		TopicSortParamApi topicSortParamApi=getDubboClient (TopicSortParamApi.class);
		return topicSortParamApi.getTagList (mark);
	}
	
	public SimpleResult addSort(String tagName){
		TopicSortParamApi topicSortParamApi=getDubboClient (TopicSortParamApi.class);
		return topicSortParamApi.insertTag (tagName);
	}
	
	public SimpleResult removeSort(Long  sortCode){
		TopicSortParamApi topicSortParamApi=getDubboClient (TopicSortParamApi.class);
		return topicSortParamApi.removeTag (sortCode);
	}
	public SimpleResult updateSort(TopicSortParamOrder order){
		TopicSortParamApi topicSortParamApi=getDubboClient (TopicSortParamApi.class);
		return topicSortParamApi.updateTag (order);
	}
	
}
