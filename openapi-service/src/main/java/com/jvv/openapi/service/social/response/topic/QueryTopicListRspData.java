package com.jvv.openapi.service.social.response.topic;

import com.jvv.facade.social.circle.info.TopicManagerInfo;
import com.jvv.openapi.core.service.entity.AbstractResponseData;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/5/26
 * @time 11:51
 */
public class QueryTopicListRspData extends AbstractResponseData {
	private List<TopicManagerInfo> list;
	
	private Long count;
	
	public List<TopicManagerInfo> getList () {
		return list;
	}
	
	public void setList (List<TopicManagerInfo> list) {
		this.list = list;
	}
	
	public Long getCount () {
		return count;
	}
	
	public void setCount (Long count) {
		this.count = count;
	}
}
