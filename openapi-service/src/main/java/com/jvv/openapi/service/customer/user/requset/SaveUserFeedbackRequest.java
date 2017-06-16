package com.jvv.openapi.service.customer.user.requset;

import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.meta.OpenApiField;

import javax.validation.constraints.NotNull;

/**
 * @Author SPF
 * @Date 2017/4/18
 */
public class SaveUserFeedbackRequest extends ApiRequest {

    /**
     * 用户id
     */
    @NotNull
    @OpenApiField(desc = "token", constraint = "必填")
    private String token;
    /**
     * 用户意见反馈
     */
    @NotNull
    @OpenApiField(desc = "用户意见反馈", constraint = "必填")
    private String feedback;

    /**
     * 获取用户意见反馈
     * @return feedback 用户意见反馈
     */
    public String getFeedback() {
        return this.feedback;
    }

    /**
     * 设置用户意见反馈
     * @param feedback 用户意见反馈
     */
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    /**
     * 获取用户id
     * @return token 用户id
     */
    public String getToken() {
        return this.token;
    }

    /**
     * 设置用户id
     * @param token 用户id
     */
    public void setToken(String token) {
        this.token = token;
    }
}
