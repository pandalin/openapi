package com.jvv.openapi.service.customer.user.requset.loginOut;

import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.meta.OpenApiField;

import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA
 * 〈用户退出登录参数实体〉<p>
 * 〈功能详细描述〉
 *
 * @author liaotianyu
 * @date 2017/3/22
 * @time 14:34
 */
public class UserLoginOutRequest extends ApiRequest {


    @NotNull
    @OpenApiField(desc = "token", constraint = "必填")
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
