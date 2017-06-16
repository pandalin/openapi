package com.jvv.openapi.service.social.api;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.jvv.common.lang.DateUtils;
import com.jvv.customer.facade.constants.enums.Status;
import com.jvv.customer.facade.user.result.UserEncounterInfoResult;
import com.jvv.openapi.common.constant.RedisKeyEnum;
import com.jvv.openapi.common.exception.ResultCode;
import com.jvv.openapi.common.util.RedisUtils;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.domain.base.result.social.UserEncounterInfo;
import com.jvv.openapi.domain.base.result.social.UserEncounterResult;
import com.jvv.openapi.domain.encounter.decorator.*;
import com.jvv.openapi.intergration.customer.user.UserInfoClient;
import com.jvv.openapi.service.social.request.UserEncounterRequest;
import com.jvv.openapi.service.social.response.UserEncounterResponseData;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTimeUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.ZSetOperations;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by IntelliJ IDEA
 * <p>〈邂逅〉 </p>
 * 〈邂逅〉
 *
 * @author linxm
 * @version 1.0
 * @date 2017/4/11
 * @time 11:17
 */
@OpenApiService(name = "getEncounterUserList", desc = "邂逅", responseType = ResponseTypeEnum.SYN)
public class UserEncounterApiService extends AbstractApiService<UserEncounterRequest, ApiResponse> {

    @Resource
    private RedisUtils redisUtils;
    @Resource
    private TokenUtils tokenUtils;
    @Resource
    private UserInfoClient userInfoClient;

    @Override
    protected void doService(UserEncounterRequest request, ApiResponse response) {

        String userId = tokenUtils.getUserIdByToken(request.getToken());

        UserEncounterInfoResult userEncounterInfoResult = userInfoClient.findUserEncounterDetailsByUserId(userId);
        if (Status.SUCCESS.equals(userEncounterInfoResult.getStatus())) {
            com.jvv.customer.facade.user.info.UserEncounterInfo userInfo = userEncounterInfoResult.getInfo();

            //匹配5个，取6个，如果含自己，就把自己去掉
            Set<String> set = redisUtils.distinctRandomMembers(RedisKeyEnum.KEY_USER_ENCOUNTER_LIST.name(), 6);

            Iterator<String> it = set.iterator();

            List<UserEncounterResult> encounterResultList = Lists.newArrayList();
            UserEncounterResult userEncounterResult = null;
            int index = 0;
            while (it.hasNext()) {
                String next = it.next();

                String saveUserJson = (String) redisUtils.get(RedisKeyEnum.KEY_USER_ENCOUNTER.name(), RedisKeyEnum.encounter_.name() + next);
                UserEncounterInfo encounterInfo = JSON.parseObject(saveUserJson, UserEncounterInfo.class);
                //排除自己
                if (encounterInfo == null || userId.equals(encounterInfo.getUserId())) {
                    continue;
                }
                //不包含自己或者自己在最后时，只取前5个
                if (set.size() == 6 && index == 5) {
                    break;
                }

                SuitabilityDecorator suitability = new SuitabilityDecorator(new BaseSuitability());
                if (userInfo.getUserType() == encounterInfo.getUserType()) {
                    suitability = new UserTypeSuitability(suitability);
                }

                if (encounterInfo.getBirthDay() != null && userInfo.getBirthDay() != null) {
                    int curUserAge = DateUtils.getAge(userInfo.getBirthDay());

                    int userAge = DateUtils.getAge(encounterInfo.getBirthDay());
                    if (userAge + 3 <= curUserAge && curUserAge <= userAge - 3) {
                        suitability = new UserSuitability(suitability);
                    }
                }

                if (encounterInfo.getConstellation() != null && encounterInfo.getConstellation().equals(request.getConstellation())) {
                    suitability = new ConstelllationSuitability(suitability);
                }
                if (userInfo.getIndustry() != null && userInfo.getIndustry().equals(encounterInfo.getIndustry())) {
                    suitability = new UserSuitability(suitability);
                }
                if (userInfo.getIdentity() != null && userInfo.getIdentity().equals(encounterInfo.getIdentity())) {
                    suitability = new UserSuitability(suitability);
                }
                userEncounterResult = new UserEncounterResult(encounterInfo.getUserId(), encounterInfo.getUserName(),encounterInfo.getHeadImg(), suitability.suit());

                encounterResultList.add(userEncounterResult);

                index++;
            }

            //把自己加进去,必须存在头像
            if (StringUtils.isNotEmpty(userInfo.getHeadImg())) {
                UserEncounterInfo userEncounterInfo = new UserEncounterInfo();
                BeanUtils.copyProperties(userInfo, userEncounterInfo);
                userEncounterInfo.setConstellation(request.getConstellation());
                //保证每个人只有1条是关键
                redisUtils.put(RedisKeyEnum.KEY_USER_ENCOUNTER.name(), RedisKeyEnum.encounter_.name() + userId, JSON.toJSONString(userEncounterInfo));

                redisUtils.sAdd(RedisKeyEnum.KEY_USER_ENCOUNTER_LIST.name(), userId);

            }

            //返回信息

            UserEncounterResponseData userEncounterResponseData = new UserEncounterResponseData();
            userEncounterResponseData.setList (encounterResultList);

            response.setDatas(userEncounterResponseData);
            response.setStatus(com.jvv.common.enums.Status.SUCCESS.code());
            response.setMessage(com.jvv.common.enums.Status.SUCCESS.message());
            response.setDetailMessage(ResultCode.EXECUTE_SUCCESS.getMessage());
            response.setCode(ResultCode.EXECUTE_SUCCESS.getCode());
        }

    }

}
