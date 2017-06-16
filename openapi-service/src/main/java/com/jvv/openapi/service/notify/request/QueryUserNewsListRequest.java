package com.jvv.openapi.service.notify.request;

import com.jvv.common.services.order.validation.Query;
import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.meta.OpenApiField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/6/7
 * @time 16:42
 */
public class QueryUserNewsListRequest extends ApiRequest {
	
	@NotNull
	@OpenApiField(desc = "token")
	private String token;
	
	@NotNull
	@OpenApiField(desc = "消息类别(1:系统通知、2:消息提醒)")
	private Long msgType;
	
	@NotNull
	@OpenApiField(desc = "分页起始页")
	private Integer start;
	
	@NotNull
	@OpenApiField(desc = "每页最大条数")
	private Integer pageSize;
	
	
	public String getToken () {
		return token;
	}
	
	public void setToken (String token) {
		this.token = token;
	}
	
	public Long getMsgType () {
		return msgType;
	}
	
	public void setMsgType (Long msgType) {
		this.msgType = msgType;
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
