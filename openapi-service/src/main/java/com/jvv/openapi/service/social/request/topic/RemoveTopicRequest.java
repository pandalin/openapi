package com.jvv.openapi.service.social.request.topic;

import com.jvv.facade.social.circle.order.TopicFileOrder;
import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.meta.OpenApiField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author huangw
 * @date 2017/5/17
 * @time 11:34
 */
public class RemoveTopicRequest extends ApiRequest {
	@OpenApiField(desc = "token")
	@NotBlank
	protected String token;
	
	@OpenApiField(desc = "topicId")
	@NotBlank
	protected String topicId;
	
	public String getToken () {
		return token;
	}
	
	public void setToken (String token) {
		this.token = token;
	}
	
	public String getTopicId () {
		return topicId;
	}
	
	public void setTopicId (String topicId) {
		this.topicId = topicId;
	}
}
