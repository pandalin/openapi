package com.jvv.openapi.service.customer.user.api.userpwd;

import com.jvv.customer.facade.base.result.SimpleResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.intergration.customer.user.UserResetPwdClient;
import com.jvv.openapi.service.customer.user.requset.userpwd.GetBackUserPwdRequest;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA
 * <p>〈类详细描述〉 </p>
 * 〈功能详细描述〉
 *
 * @author linxm
 * @version 1.0
 * @date 2017/3/24
 * @time 15:49
 */
@OpenApiService(name = "getBackUserPwd", desc = "找回安全码接口", responseType = ResponseTypeEnum.SYN)
public class GetBackUserPwdApiService extends AbstractApiService<GetBackUserPwdRequest,ApiResponse> {

    @Resource
    private UserResetPwdClient userResetPwdClient;
    @Resource
    private TokenUtils tokenUtils;

    @Override
    protected void doService(GetBackUserPwdRequest request, ApiResponse response) {
        String userId = tokenUtils.getUserIdByToken (request.getToken ());

        SimpleResult result = userResetPwdClient.getBackUserPwd (userId, request.getRealName ()
                ,request.getIdCard(),request.getPassword (),
                request.getConfirmPassword (),request.getSmsCode ());
        response.setStatus(result.getStatus().getCode());
        response.setMessage(result.getMessage());
        response.setDetailMessage(result.getMessage());
        response.setCode(result.getCode());
    }
}
