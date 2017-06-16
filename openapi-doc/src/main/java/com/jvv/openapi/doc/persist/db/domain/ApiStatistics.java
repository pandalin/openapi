/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * zhike@jinvovo.com 2016-08-29 10:32 创建
 *
 */
package com.jvv.openapi.doc.persist.db.domain;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author zhike@jinvovo.com
 */
public class ApiStatistics extends AbstractDomain {

    @NotBlank
    private String typeName;

    private Long visitCount;

    private String updateDate;

    private Long praiseCount;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Long getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(Long visitCount) {
        this.visitCount = visitCount;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public Long getPraiseCount() {
        return praiseCount;
    }

    public void setPraiseCount(Long praiseCount) {
        this.praiseCount = praiseCount;
    }
}
