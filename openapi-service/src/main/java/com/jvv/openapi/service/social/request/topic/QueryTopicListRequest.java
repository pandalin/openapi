package com.jvv.openapi.service.social.request.topic;

import com.jvv.common.services.order.validation.Query;
import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.meta.OpenApiField;

import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/5/25
 * @time 17:23
 */
public class QueryTopicListRequest extends ApiRequest {
	
	/**
	 * 页码；1开始;必须大于0
	 * 默认1
	 */
	@NotNull
	@OpenApiField(desc = "页码")
	protected Integer pageNo;
	
	/**
	 * 每页大小；必须大于0
	 * 默认：10
	 */
	@NotNull
	@OpenApiField(desc = "分页大小")
	protected Integer pageSize;
	
	/**
	 * 查询日期 开始日期
	 */
	@OpenApiField(desc = "开始日期")
	protected String beginTime;
	
	/**
	 * 查询日期 结束日期
	 */
	@OpenApiField(desc = "结束日期")
	protected String endTime;
	
	/**
	 * 查询菜单一级  sort-分类 ,is_hot-热门 ,is_shield 屏蔽 , is
	 */
	@OpenApiField(desc = "查询菜单一级")
	protected String firstClass;
	
	/**
	 * 查询菜单二级 对应一级菜单各自分段的值
	 */
	@OpenApiField(desc = "查询菜单二级")
	protected Integer secondClass;
	
	/**
	 * 排序 publish_time,praise_count
	 */
	@OpenApiField(desc = "排序条件")
	protected String sort;
	
	/**
	 * 排序规则 desc asc
	 */
	@OpenApiField(desc = "排序方式")
	protected String order;
	
	public Integer getPageNo () {
		return pageNo;
	}
	
	public void setPageNo (Integer pageNo) {
		this.pageNo = pageNo;
	}
	
	public Integer getPageSize () {
		return pageSize;
	}
	
	public void setPageSize (Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	public String getBeginTime () {
		return beginTime;
	}
	
	public void setBeginTime (String beginTime) {
		this.beginTime = beginTime;
	}
	
	public String getEndTime () {
		return endTime;
	}
	
	public void setEndTime (String endTime) {
		this.endTime = endTime;
	}
	
	public String getFirstClass () {
		return firstClass;
	}
	
	public void setFirstClass (String firstClass) {
		this.firstClass = firstClass;
	}
	
	public Integer getSecondClass () {
		return secondClass;
	}
	
	public void setSecondClass (Integer secondClass) {
		this.secondClass = secondClass;
	}
	
	public String getSort () {
		return sort;
	}
	
	public void setSort (String sort) {
		this.sort = sort;
	}
}
