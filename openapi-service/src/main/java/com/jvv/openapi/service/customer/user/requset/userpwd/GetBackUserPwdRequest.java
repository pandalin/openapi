package com.jvv.openapi.service.customer.user.requset.userpwd;

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
 * @date 2017/3/24
 * @time 15:46
 */
public class GetBackUserPwdRequest extends ApiRequest {

    @NotNull
    @OpenApiField(desc = "token", constraint = "必填")
    private String token;
    /**
     * 真实姓名
     */
    @OpenApiField(desc = "真实姓名", constraint = "非必填")
    private String realName;
    /**
     * idcard
     */
    @OpenApiField(desc = "身份证号码", constraint = "非必填")
    private String idCard;

    @NotNull
    @OpenApiField(desc = "安全码", constraint = "必填")
    private String password;

    @NotNull
    @OpenApiField(desc = "确认安全码", constraint = "必填")
    private String confirmPassword;

    @NotNull
    @OpenApiField(desc = "动态码", constraint = "必填")
    private String smsCode;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }
}
