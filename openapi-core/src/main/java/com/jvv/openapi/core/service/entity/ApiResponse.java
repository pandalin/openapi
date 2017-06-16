/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-22 22:28 创建
 *
 */
package com.jvv.openapi.core.service.entity;

import com.jvv.common.services.result.SimpleResult;
import com.jvv.openapi.core.service.base.ApiServiceResultCode;
import com.jvv.openapi.core.service.meta.OpenApiField;

import javax.validation.constraints.Null;
import java.util.List;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/22 22:28
 */

public class ApiResponse extends ApiServiceInfo {
	@Null
	@OpenApiField(desc = "服务响应编码", constraint = "必填")
	private String code = ApiServiceResultCode.EXECUTE_SUCCESS.getCode();
	@Null
	@OpenApiField(desc = "服务响应编码描述")
	private String message = ApiServiceResultCode.EXECUTE_SUCCESS.getMessage();
	
	@OpenApiField(desc = "服务响应信息")
	private String detailMessage = ApiServiceResultCode.EXECUTE_SUCCESS.getMessage();
	
	@OpenApiField(desc = "服务响应的流水号")
	private String gid;
	@Null
	@OpenApiField(desc = "服务响应状态")
	private String status;
	
	@Null
	@OpenApiField(desc = "返回数据")
	private AbstractResponseData datas;
	@Null
	@OpenApiField(desc = "提示方式")
	private String prompt;
	@Null
	@OpenApiField(desc = "其他数据")
	private AbstractResponseData other;
	

	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getDetailMessage() {
		return detailMessage;
	}
	
	public void setDetailMessage(String detailMessage) {
		this.detailMessage = detailMessage;
	}
	
	public String getGid() {
		return gid;
	}
	
	public void setGid(String gid) {
		this.gid = gid;
	}
	
	public AbstractResponseData getDatas() {
		return datas;
	}
	
	public void setDatas(AbstractResponseData datas) {
		this.datas = datas;
	}
	
	public String getPrompt () {
		return prompt;
	}
	
	public void setPrompt (String prompt) {
		this.prompt = prompt;
	}
	
	public AbstractResponseData getOther () {
		return other;
	}
	
	public void setOther (AbstractResponseData other) {
		this.other = other;
	}
	
	/**
	 * 封装返回response参数
	 * */
	public <R extends SimpleResult,RES extends ApiResponse> RES injectResponse(R result, RES response){
		response.setStatus (result.getStatus ().getCode ());
		response.setCode (result.getCode ());
		response.setMessage (result.getMessage ());
		response.setDetailMessage (result.getDescription ());
		return response;
	}
	//	@Override
	//	public String toString() {
	//		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
//	}
}
