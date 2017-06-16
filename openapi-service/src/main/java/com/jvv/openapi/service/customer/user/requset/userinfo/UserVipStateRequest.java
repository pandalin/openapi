package com.jvv.openapi.service.customer.user.requset.userinfo;

import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.meta.OpenApiField;

import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/6/12
 * @time 15:44
 */
public class UserVipStateRequest extends ApiRequest {
	
	@NotNull
	@OpenApiField(desc = "用户id")
	private String userId;
	
	@OpenApiField(desc = "用户类型 (1:普通用户 2:VIP)")
	private Integer userType;
	
	
	public String getUserId () {
		return userId;
	}
	
	public void setUserId (String userId) {
		this.userId = userId;
	}
	
	public Integer getUserType () {
		return userType;
	}
	
	public void setUserType (Integer userType) {
		this.userType = userType;
	}
}
