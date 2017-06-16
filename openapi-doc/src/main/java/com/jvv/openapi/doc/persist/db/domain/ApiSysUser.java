/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */

/*
 * 修订记录：
 * zhike 2015年9月16日 下午1:04:56 创建
 */
package com.jvv.openapi.doc.persist.db.domain;

import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

/**
 * @author zhike@jinvovo.com
 */
public class ApiSysUser extends AbstractDomain {
    private static final long serialVersionUID = 1L;

    @NotBlank
    private String userName;

    @NotBlank
    private String password;

    private Date create_date;

    private Integer isAdmin;

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }
}
