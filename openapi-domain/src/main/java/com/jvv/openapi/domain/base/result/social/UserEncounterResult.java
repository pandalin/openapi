package com.jvv.openapi.domain.base.result.social;

import com.jvv.openapi.domain.base.result.DomainResultBase;

/**
 * Created by IntelliJ IDEA
 * <p>〈邂逅返回数据〉 </p>
 * 〈邂逅返回数据〉
 *
 * @author linxm
 * @version 1.0
 * @date 2017/4/11
 * @time 12:27
 */
public class UserEncounterResult extends DomainResultBase {

    private String userId;

    private String userName;

    private String headImg;

    private int suitability;//匹配度

    public UserEncounterResult(String userId, String userName,String headImg, int suitability) {
        this.userId = userId;
        this.userName = userName;
        this.headImg = headImg;
        this.suitability = suitability;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public int getSuitability() {
        return suitability;
    }

    public void setSuitability(int suitability) {
        this.suitability = suitability;
    }
}
