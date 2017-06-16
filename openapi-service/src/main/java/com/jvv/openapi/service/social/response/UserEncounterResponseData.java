package com.jvv.openapi.service.social.response;

import com.jvv.openapi.core.service.entity.AbstractResponseData;
import com.jvv.openapi.domain.base.result.social.UserEncounterResult;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 * <p>〈邂逅〉 </p>
 * 〈邂逅〉
 *
 * @author linxm
 * @version 1.0
 * @date 2017/4/11
 * @time 10:05
 */
public class UserEncounterResponseData extends AbstractResponseData{

    private List<UserEncounterResult> list;
    
    public List<UserEncounterResult> getList () {
        return list;
    }
    
    public void setList (List<UserEncounterResult> list) {
        this.list = list;
    }
}
