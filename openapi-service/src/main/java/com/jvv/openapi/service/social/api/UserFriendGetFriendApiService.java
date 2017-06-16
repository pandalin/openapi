/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.api;

import com.jvv.common.services.PageInfo;
import com.jvv.facade.constants.enums.UserFriendTypeEnum;
import com.jvv.facade.social.friend.order.UserFriendOrder;
import com.jvv.facade.social.friend.result.UserFriendResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.facade.constants.enums.Status;
import com.jvv.openapi.intergration.social.friend.UserFriendClient;
import com.jvv.openapi.service.social.request.UserFriendRequest;
import com.jvv.openapi.service.social.response.UserFriendResponseData;
import org.joda.time.DateTimeUtils;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/4/10
 * @time 11:55
 */
@OpenApiService(name = "getFriendList", desc = "获取用户好友列表", responseType = ResponseTypeEnum.SYN)
public class UserFriendGetFriendApiService extends AbstractApiService<UserFriendRequest, ApiResponse> {

    @Resource
    UserFriendClient client;
    @Resource
    TokenUtils tokenUtils;


    @Override
    protected void doService(UserFriendRequest request, ApiResponse response) {
        UserFriendOrder order = new UserFriendOrder();

        String userId = tokenUtils.getUserIdByToken(request.getToken());
        order.setUserId(userId);
        //查找关注类型数据
        order.setFriendType(UserFriendTypeEnum.FRIEND);
        order.setUpdateTime(request.getUpdateTime());
        order.setPageInfo(new PageInfo());

        UserFriendResult userFriendResult = client.getUserFriendList(order);

        //返回结果注入相对应的response
        response.setStatus(userFriendResult.getStatus().getCode());
        response.setMessage(userFriendResult.getMessage());
        response.setDetailMessage(userFriendResult.getMessage());
        response.setCode(userFriendResult.getCode());

        UserFriendResponseData data = new UserFriendResponseData();
        data.setCurrentTime(String.valueOf(DateTimeUtils.currentTimeMillis()));
        data.setList(userFriendResult.getUserFriendInfos());
        response.setDatas(data);


    }
}
