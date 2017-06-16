package com.jvv.openapi.service.customer.user.api;

import com.jvv.customer.facade.user.order.UserFansRankOrder;
import com.jvv.customer.facade.user.order.UserFeedbackSaveOrder;
import com.jvv.customer.facade.user.result.UserFeedbackResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.intergration.customer.user.UserFeedbackClient;
import com.jvv.openapi.service.customer.user.requset.SaveUserFeedbackRequest;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;

/**
 * @Author SPF
 * @Date 2017/4/18
 */
@OpenApiService(name = "saveFeedback", desc = "保存用户反馈", responseType = ResponseTypeEnum.SYN)
public class SaveFeedbackService extends AbstractApiService<SaveUserFeedbackRequest,ApiResponse>  {

    @Resource
    UserFeedbackClient userFeedbackClient;

    @Resource
    TokenUtils tokenUtils;

    @Override
    protected void doService(SaveUserFeedbackRequest request, ApiResponse response) {
        UserFeedbackSaveOrder order = new UserFeedbackSaveOrder();
        BeanUtils.copyProperties(request, order);
        String userId = tokenUtils.getUserIdByToken (request.getToken());
        order.setUserId(userId);

        UserFeedbackResult result = userFeedbackClient.saveUserFeedback(order);
        response.setStatus (result.getStatus ().getCode ());
        response.setCode(result.getCode());
        response.setMessage(result.getMessage());
    }
}
