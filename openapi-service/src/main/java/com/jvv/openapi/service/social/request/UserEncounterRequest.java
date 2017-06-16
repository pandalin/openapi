package com.jvv.openapi.service.social.request;

import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.meta.OpenApiField;

import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA
 * <p>〈类详细描述〉 </p>
 * 〈功能详细描述〉
 *
 * @author linxm
 * @version 1.0
 * @date 2017/4/11
 * @time 9:36
 */
public class UserEncounterRequest extends ApiRequest {

    @NotNull
    @OpenApiField(desc = "token",constraint = "必填")
    private String token;

    @OpenApiField(desc = "星座",constraint = "非必填")
    private String constellation;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getConstellation() {
        return constellation;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }
}
