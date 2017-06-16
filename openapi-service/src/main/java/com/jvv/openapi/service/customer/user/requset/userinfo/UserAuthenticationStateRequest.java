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
public class UserAuthenticationStateRequest extends ApiRequest {
	
	@NotNull
	@OpenApiField(desc = "用户id")
	private String userId;
	
	@NotNull
	@OpenApiField(desc = "实名认证状态 (0:未认证  1:已认证)")
	private Integer authenticationState;
	
	@NotNull
	@OpenApiField(desc = "身份证号")
	private String idcard;
	
	@NotNull
	@OpenApiField(desc = "真实姓名")
	private String realname;
	
	
	public String getUserId () {
		return userId;
	}
	
	public void setUserId (String userId) {
		this.userId = userId;
	}
	
	public Integer getAuthenticationState () {
		return authenticationState;
	}
	
	public void setAuthenticationState (Integer authenticationState) {
		this.authenticationState = authenticationState;
	}
	
	public String getIdcard () {
		return idcard;
	}
	
	public void setIdcard (String idcard) {
		this.idcard = idcard;
	}
	
	public String getRealname () {
		return realname;
	}
	
	public void setRealname (String realname) {
		this.realname = realname;
	}
}
