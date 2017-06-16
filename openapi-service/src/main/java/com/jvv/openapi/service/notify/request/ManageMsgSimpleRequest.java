package com.jvv.openapi.service.notify.request;

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
 * @time 10:37
 */
public class ManageMsgSimpleRequest extends ApiRequest {
	
	@NotNull
	@OpenApiField(desc = "消息id")
	private String msgId;
	
	public String getMsgId () {
		return msgId;
	}
	
	public void setMsgId (String msgId) {
		this.msgId = msgId;
	}
}
