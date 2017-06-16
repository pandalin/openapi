package com.jvv.openapi.domain.base.result.social;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by IntelliJ IDEA
 * <p>〈邂逅存储对象〉 </p>
 * 〈邂逅存储对象〉
 *
 * @author linxm
 * @version 1.0
 * @date 2017/4/11
 * @time 11:27
 */
public class UserEncounterInfo implements Serializable {

    private String userId;

    private String userName;

    private String headImg;

    private Integer userType;//类型

    private String constellation;//星座

    private String identity;//身份

    private String industry;//行业

    private Date birthDay;//生日

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

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getConstellation() {
        return constellation;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
}
