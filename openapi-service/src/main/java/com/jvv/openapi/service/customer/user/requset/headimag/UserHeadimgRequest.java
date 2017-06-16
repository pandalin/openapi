/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.requset.headimag;

import com.jvv.customer.facade.constants.validation.Add;
import com.jvv.customer.facade.constants.validation.Modify;
import com.jvv.customer.facade.constants.validation.Query;
import com.jvv.customer.facade.constants.validation.Remove;
import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.meta.OpenApiField;
import com.jvv.openapi.core.service.meta.OpenApiService;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/3/23
 * @time 11:21
 */
public class UserHeadimgRequest extends ApiRequest {
	
	@NotNull
	@OpenApiField(desc = "token",constraint = "必填")
	protected String token;
	
	@OpenApiField(desc = "头像ID")
	protected Long id;
	
	@OpenApiField(desc = "用户ID")
	protected String userId;
	
	@OpenApiField(desc = "头像地址")
	protected String imgurl;
	
	@OpenApiField(desc = "上传时间")
	protected Date uploadTime;
	
	@OpenApiField(desc = "排序")
	protected Integer imgOrder;
	
	@OpenApiField(desc = "更新时间")
	protected Date updatetime;
	
	@OpenApiField(desc = "是否删除  0:删除 1:未删除")
	protected Integer isDelete;
	
	
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
	
	public String getImgurl () {
		return imgurl;
	}
	
	public void setImgurl (String imgurl) {
		this.imgurl = imgurl;
	}
	
	public Date getUploadTime () {
		return uploadTime;
	}
	
	public void setUploadTime (Date uploadTime) {
		this.uploadTime = uploadTime;
	}
	
	public Integer getImgOrder () {
		return imgOrder;
	}
	
	public void setImgOrder (Integer imgOrder) {
		this.imgOrder = imgOrder;
	}
	
	public Date getUpdatetime () {
		return updatetime;
	}
	
	public void setUpdatetime (Date updatetime) {
		this.updatetime = updatetime;
	}
	
	public Integer getIsDelete () {
		return isDelete;
	}
	
	public void setIsDelete (Integer isDelete) {
		this.isDelete = isDelete;
	}
}
