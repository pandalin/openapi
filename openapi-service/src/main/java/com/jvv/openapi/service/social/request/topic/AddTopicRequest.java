package com.jvv.openapi.service.social.request.topic;

import com.jvv.common.services.order.validation.Add;
import com.jvv.facade.social.circle.order.TopicFileOrder;
import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.meta.OpenApiField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.Date;
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
public class AddTopicRequest extends ApiRequest {
	@OpenApiField(desc = "token")
	@NotBlank
	protected String token;

	@OpenApiField(desc = "圈子内容")
	protected String content;
	/**
	 * 是否公开  0:不公开(仅好友可见)   1:公开
	 */
	@OpenApiField(desc = "是否公开")
	@NotNull
	protected Integer isPublic;
	
	@OpenApiField(desc = "圈子图片")
	protected List<TopicFileOrder> topicFiles;
	
	@OpenApiField(desc = "经度")
	protected Double longitude;
	
	@OpenApiField(desc = "纬度")
	protected Double latitude;
	
	@OpenApiField(desc = "地理位置")
	protected String userlocation;
	
	public String getToken () {
		return token;
	}
	
	public void setToken (String token) {
		this.token = token;
	}
	
	public String getContent () {
		return content;
	}
	
	public void setContent (String content) {
		this.content = content;
	}
	
	public Integer getIsPublic () {
		return isPublic;
	}
	
	public void setIsPublic (Integer isPublic) {
		this.isPublic = isPublic;
	}
	
	public List<TopicFileOrder> getTopicFiles () {
		return topicFiles;
	}
	
	public void setTopicFiles (List<TopicFileOrder> topicFiles) {
		this.topicFiles = topicFiles;
	}
	
	public Double getLongitude () {
		return longitude;
	}
	
	public void setLongitude (Double longitude) {
		this.longitude = longitude;
	}
	
	public Double getLatitude () {
		return latitude;
	}
	
	public void setLatitude (Double latitude) {
		this.latitude = latitude;
	}
	
	public String getUserlocation () {
		return userlocation;
	}
	
	public void setUserlocation (String userlocation) {
		this.userlocation = userlocation;
	}
}
