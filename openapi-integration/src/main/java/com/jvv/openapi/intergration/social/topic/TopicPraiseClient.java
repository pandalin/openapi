/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.intergration.social.topic;

import com.jvv.common.services.result.SimpleResult;
import com.jvv.facade.social.circle.api.TopicDoPraiseApi;
import com.jvv.facade.social.circle.api.TopicPraiseListApi;
import com.jvv.facade.social.circle.api.TopicUnreadPraiseCountApi;
import com.jvv.facade.social.circle.order.TopicDoPraiseOrder;
import com.jvv.facade.social.circle.result.TopicPraiseListResult;
import com.jvv.facade.social.circle.result.TopicUnreadCountResult;
import com.jvv.openapi.intergration.Client;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA
 * 〈〉 <p>
 * 〈调用于赞相关的服务〉
 *
 * @author lxb
 * @date 2017/5/17
 * @time 10:43
 */
@Component
public class TopicPraiseClient extends Client {
	
	/**
	 * 点赞调用
	 * @param order
	 * @return
	 */
	public SimpleResult praise(TopicDoPraiseOrder order){
		TopicDoPraiseApi topicDoPraiseApi=getDubboClient (TopicDoPraiseApi.class);
		System.out.println ("----");
		return topicDoPraiseApi.userDoPraise (order);
	}
	
	/**
	 * 获取点赞列表
	 * @param userId
	 * @return
	 */
	public TopicPraiseListResult getUserPraiseList(String userId,int pageNo,int pageSize){
		TopicPraiseListApi topicPraiseListApi=getDubboClient (TopicPraiseListApi.class);
		return topicPraiseListApi.getUserPraiseList (userId,pageNo,pageSize);
	}
	
	
	/**
	 * 获取未读点赞总数
	 * @param userId
	 * @return
	 */
	public TopicUnreadCountResult getUnreadPraiseCount(String userId){
		TopicUnreadPraiseCountApi topicUnreadPraiseCountApi=getDubboClient (TopicUnreadPraiseCountApi.class);
		return topicUnreadPraiseCountApi.getUnreadPraiseCount (userId);
	}
	
}
