package com.jvv.openapi.service.notify.request;

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
 * @date 2017/6/7
 * @time 15:13
 */
public class ManageQueryMsgListRequest extends ApiRequest {
	
	@OpenApiField(desc = "消息类型")
	private Long msgType;
	
	@OpenApiField(desc = "查询起始日期")
	private String startDate;
	
	@OpenApiField(desc = "查询结束日期")
	private String endDate;
	
	@NotNull
	@OpenApiField(desc = "分页起始页")
	private Integer start;
	
	@NotNull
	@OpenApiField(desc = "每页最大条数")
	private Integer pageSize;
	
	public Long getMsgType () {
		return msgType;
	}
	
	public void setMsgType (Long msgType) {
		this.msgType = msgType;
	}
	
	public String getStartDate () {
		return startDate;
	}
	
	public void setStartDate (String startDate) {
		this.startDate = startDate;
	}
	
	public String getEndDate () {
		return endDate;
	}
	
	public void setEndDate (String endDate) {
		this.endDate = endDate;
	}
	
	public Integer getStart () {
		return start;
	}
	
	public void setStart (Integer start) {
		this.start = start;
	}
	
	public Integer getPageSize () {
		return pageSize;
	}
	
	public void setPageSize (Integer pageSize) {
		this.pageSize = pageSize;
	}
}
