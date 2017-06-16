/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.intergration.social.topic;

import com.jvv.facade.social.circle.api.TopicWhiteListApi;
import com.jvv.facade.social.circle.result.TopicWhiteListResult;
import com.jvv.openapi.intergration.Client;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/5/27
 * @time 13:40
 */
@Component
public class TopicWhiteListClient extends Client{
	
	public TopicWhiteListResult queryAllWhiteList(){
		TopicWhiteListApi api = getDubboClient (TopicWhiteListApi.class);
		return api.queryAllWhiteList ();
	}
	
}
