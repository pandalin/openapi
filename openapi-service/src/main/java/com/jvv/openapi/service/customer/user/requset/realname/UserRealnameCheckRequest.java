/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.requset.realname;

import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.meta.OpenApiField;
import com.jvv.openapi.core.service.meta.OpenApiService;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/3/16
 * @time 17:48
 */
public class UserRealnameCheckRequest extends ApiRequest {
	
	@OpenApiField(desc = "记录ID")
	private Long id;
	
	@OpenApiField(desc = "token")
	private String token;
	
	@OpenApiField(desc = "用户ID")
	protected String userId;
	
	@OpenApiField(desc = "真实姓名")
	protected String realname;
	
	@OpenApiField(desc = "用户手机号")
	protected String userPhone;
	
	@OpenApiField(desc = "身份证号")
	protected String idcard;
	
	@OpenApiField(desc = "身份证正面照")
	protected String cardFront;
	
	@OpenApiField(desc = "身份证反面照")
	protected String cardVerso;
	
	@OpenApiField(desc = "手持身份证照")
	protected String cardHand;
	/**
	 * 审核状态  0:未处理  1:审核未通过 2:审核通过
	 */
	@OpenApiField(desc = "审核状态")
	protected Long status;
	@OpenApiField(desc = "创建人")
	protected String creator;
	@OpenApiField(desc = "索引起始值")
	protected Long Start;
	@OpenApiField(desc = "每页大小")
	protected Integer pageSize;
	
	
	public String getToken () {
		return token;
	}
	
	public void setToken (String token) {
		this.token = token;
	}
	
	public Long getId () {
		return id;
	}
	
	public void setId (Long id) {
		this.id = id;
	}
	
	public String getUserId () {
		return userId;
	}
	
	public void setUserId (String userId) {
		this.userId = userId;
	}
	
	public String getRealname () {
		return realname;
	}
	
	public void setRealname (String realname) {
		this.realname = realname;
	}
	
	public String getUserPhone () {
		return userPhone;
	}
	
	public void setUserPhone (String userPhone) {
		this.userPhone = userPhone;
	}
	
	public String getIdcard () {
		return idcard;
	}
	
	public void setIdcard (String idcard) {
		this.idcard = idcard;
	}
	
	public String getCardFront () {
		return cardFront;
	}
	
	public void setCardFront (String cardFront) {
		this.cardFront = cardFront;
	}
	
	public String getCardVerso () {
		return cardVerso;
	}
	
	public void setCardVerso (String cardVerso) {
		this.cardVerso = cardVerso;
	}
	
	public String getCardHand () {
		return cardHand;
	}
	
	public void setCardHand (String cardHand) {
		this.cardHand = cardHand;
	}
	
	public Long getStatus () {
		return status;
	}
	
	public void setStatus (Long status) {
		this.status = status;
	}
	
	public String getCreator () {
		return creator;
	}
	
	public void setCreator (String creator) {
		this.creator = creator;
	}
	
	public Long getStart () {
		return Start;
	}
	
	public void setStart (Long start) {
		Start = start;
	}
	
	public Integer getPageSize () {
		return pageSize;
	}
	
	public void setPageSize (Integer pageSize) {
		this.pageSize = pageSize;
	}
}
