package com.jvv.openapi.intergration.customer.user;

import com.jvv.customer.facade.user.api.UserFeedbackApi;
import com.jvv.customer.facade.user.order.UserFansRankOrder;
import com.jvv.customer.facade.user.order.UserFeedbackSaveOrder;
import com.jvv.customer.facade.user.result.UserFeedbackResult;
import com.jvv.openapi.intergration.Client;
import org.springframework.stereotype.Component;

/**
 * @Author SPF
 * @Date 2017/4/18
 */
@Component
public class UserFeedbackClient extends Client {

    public UserFeedbackResult saveUserFeedback(UserFeedbackSaveOrder order) {
        UserFeedbackApi api = getDubboClient(UserFeedbackApi.class);
        UserFeedbackResult result = api.svaeUserFeedback(order);
        return result;
    }
}
