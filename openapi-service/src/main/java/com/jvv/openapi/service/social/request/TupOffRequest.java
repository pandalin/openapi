/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.request;

import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.meta.OpenApiField;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/4/25
 * @time 9:32
 */
public class TupOffRequest extends ApiRequest {
	
	@NotNull
	@OpenApiField(desc = "token",constraint = "必填")
	private String token;
	
	@OpenApiField(desc = "被举报ID(用户ID/群ID/窝现场ID)" )
	private String accountId;
	
	@OpenApiField(desc = "图片列表" )
	private String imgList;
	
	@OpenApiField(desc = "被举报账号" )
	private String account;
	
	@OpenApiField(desc = "被举报账号昵称" )
	private String accountNickname;
	
	@OpenApiField(desc = "举报人昵称" )
	private String fromUserNickname;
	
	@OpenApiField(desc = "举报人手机" )
	private String fromUserPhone;
	
	@OpenApiField(desc = "举报类型  1:用户  2:群  3: 圈子  4:窝现场" )
	private Long tipOffType;
	
	@OpenApiField(desc = "举报原因" )
	private String reason;
	
	@OpenApiField(desc = "举报描述" )
	private String describe;
	
	public String getToken () {
		return token;
	}
	
	public void setToken (String token) {
		this.token = token;
	}
	
	public String getAccountId () {
		return accountId;
	}
	
	public void setAccountId (String accountId) {
		this.accountId = accountId;
	}
	
	public String getImgList () {
		return imgList;
	}
	
	public void setImgList (String imgList) {
		this.imgList = imgList;
	}
	
	public String getAccount () {
		return account;
	}
	
	public void setAccount (String account) {
		this.account = account;
	}
	
	public String getAccountNickname () {
		return accountNickname;
	}
	
	public void setAccountNickname (String accountNickname) {
		this.accountNickname = accountNickname;
	}
	
	public String getFromUserNickname () {
		return fromUserNickname;
	}
	
	public void setFromUserNickname (String fromUserNickname) {
		this.fromUserNickname = fromUserNickname;
	}
	
	public String getFromUserPhone () {
		return fromUserPhone;
	}
	
	public void setFromUserPhone (String fromUserPhone) {
		this.fromUserPhone = fromUserPhone;
	}
	
	public Long getTipOffType () {
		return tipOffType;
	}
	
	public void setTipOffType (Long tipOffType) {
		this.tipOffType = tipOffType;
	}
	
	public String getReason () {
		return reason;
	}
	
	public void setReason (String reason) {
		this.reason = reason;
	}
	
	public String getDescribe () {
		return describe;
	}
	
	public void setDescribe (String describe) {
		this.describe = describe;
	}
}
