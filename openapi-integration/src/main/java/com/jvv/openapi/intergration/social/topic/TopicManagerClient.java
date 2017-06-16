package com.jvv.openapi.intergration.social.topic;

import com.jvv.common.services.result.SimpleResult;
import com.jvv.facade.social.circle.api.TopicApi;
import com.jvv.facade.social.circle.api.TopicManagerApi;
import com.jvv.facade.social.circle.order.QueryTopicManagerOrder;
import com.jvv.facade.social.circle.order.TopicOrder;
import com.jvv.facade.social.circle.order.TopicSortOrder;
import com.jvv.facade.social.circle.result.TopicManagerResult;
import com.jvv.facade.social.circle.result.TopicResult;
import com.jvv.openapi.intergration.Client;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/5/23
 * @time 14:53
 */
@Component
public class TopicManagerClient extends Client {
	/**
	 * 给每个圈子排序+1
	 * */
	public SimpleResult modifyTopicPlusOne(){
		TopicManagerApi api = getDubboClient (TopicManagerApi.class);
		return api.modifyTopicPlusOne ();
	}
	
	/**
	 * 设置分类
	 * topicId
	 * sort 分类 ,隔开
	 * */
	public SimpleResult modifyTopicSort(TopicSortOrder order){
		TopicManagerApi api = getDubboClient (TopicManagerApi.class);
		return api.modifyTopicSort (order);
	}
	
	/**
	 * 屏蔽
	 * topicId
	 * isShield 屏蔽
	 * operater 操作人
	 */
	
	public SimpleResult modifyTopicShiled(TopicOrder order){
		TopicManagerApi api = getDubboClient (TopicManagerApi.class);
		return api.modifyTopicShiled (order);
	}
	
	/**
	 * topicId
	 * isHot 是否热门
	 * operater 操作人
	 */
	public SimpleResult modifyTopicHot(TopicOrder order){
		TopicManagerApi api = getDubboClient (TopicManagerApi.class);
		return api.modifyTopicHot (order);
	}
	
	/**
	 * topicId
	 * orderNum 设置排序
	 * operater 操作人
	 */
	public SimpleResult modifyOrderNum(TopicOrder order){
		TopicManagerApi api = getDubboClient (TopicManagerApi.class);
		return api.modifyOrderNum (order);
	}
	
	/**
	 * 查看圈子列表
	 * */
	public TopicManagerResult queryTopicList(QueryTopicManagerOrder order){
		TopicManagerApi api = getDubboClient (TopicManagerApi.class);
		return api.queryTopicList (order);
	}
}
