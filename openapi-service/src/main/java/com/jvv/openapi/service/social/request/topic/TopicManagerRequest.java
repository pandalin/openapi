package com.jvv.openapi.service.social.request.topic;

import com.jvv.common.services.order.validation.Modify;
import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.meta.OpenApiField;

import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/5/23
 * @time 16:36
 */
public class TopicManagerRequest extends ApiRequest{
	
	@NotNull
	@OpenApiField(desc = "圈子Id")
	protected String topicId;
	
	
	@OpenApiField(desc = "圈子分类Id")
	protected String topicSorts;
	
	/**
	 * 是否热门  0:否  1:是
	 */
	@OpenApiField(desc = "是否热门")
	protected Integer isHot;
	
	/**
	 * 是否屏蔽  0:不屏蔽   1:屏蔽
	 */
	@OpenApiField(desc = "是否屏蔽")
	protected Integer isShield;
	
	/**
	 * 排序序号
	 */
	@OpenApiField(desc = "设置排序序号")
	protected Long orderNum;
	
	/**
	 * 操作人
	 * */
	@OpenApiField(desc = "操作人")
	protected String operater;
	
	
	public Integer getIsHot () {
		return isHot;
	}
	
	public void setIsHot (Integer isHot) {
		this.isHot = isHot;
	}
	
	public Integer getIsShield () {
		return isShield;
	}
	
	public void setIsShield (Integer isShield) {
		this.isShield = isShield;
	}
	
	public Long getOrderNum () {
		return orderNum;
	}
	
	public void setOrderNum (Long orderNum) {
		this.orderNum = orderNum;
	}
	
	public String getOperater () {
		return operater;
	}
	
	public void setOperater (String operater) {
		this.operater = operater;
	}
	
	public String getTopicId () {
		return topicId;
	}
	
	public void setTopicId (String topicId) {
		this.topicId = topicId;
	}
	
	public String getTopicSorts () {
		return topicSorts;
	}
	
	public void setTopicSorts (String topicSorts) {
		this.topicSorts = topicSorts;
	}
}
