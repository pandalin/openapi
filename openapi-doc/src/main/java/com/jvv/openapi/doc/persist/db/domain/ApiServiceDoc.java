/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */

package com.jvv.openapi.doc.persist.db.domain;

import java.util.List;

/**
 * API 服务文档对象
 *
 * @author zhangpu
 */
public class ApiServiceDoc extends AbstractDomain {
    private static final long serialVersionUID = -7859208961307226264L;
    /**
     * API服务Key
     */
    private String service;
    /**
     * API服务版本号
     */
    private String version;

    /**
     * 归属
     */
    private String owner;

    /**
     * API服务名称
     */
    private String serviceName;
    /**
     * API类型 同步 or 异步
     */
    private String serviceType;
    /**
     * 业务说明或备注
     */
    private String note;
    /**
     * 人工附加说明
     */
    private String manualNote;
    /**
     * 人工附加实例
     */
    private String manualDemo;

    /**
     * 服务码 用来唯一确定一个服务,由service_version组成
     */
    private String serviceNo;

    /**
     * 报文文档
     */
    private List<ApiMessageDoc> messageDocs;

    private List<ApiServiceDepend> apiServiceDepends;

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getManualNote() {
        return manualNote;
    }

    public void setManualNote(String manualNote) {
        this.manualNote = manualNote;
    }

    public String getManualDemo() {
        return manualDemo;
    }

    public void setManualDemo(String manualDemo) {
        this.manualDemo = manualDemo;
    }

    public List<ApiMessageDoc> getMessageDocs() {
        return messageDocs;
    }

    public void setMessageDocs(List<ApiMessageDoc> messageDocs) {
        this.messageDocs = messageDocs;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getServiceNo() {
        return serviceNo;
    }

    public void setServiceNo(String serviceNo) {
        this.serviceNo = serviceNo;
    }

    public List<ApiServiceDepend> getApiServiceDepends() {
        return apiServiceDepends;
    }

    public void setApiServiceDepends(List<ApiServiceDepend> apiServiceDepends) {
        this.apiServiceDepends = apiServiceDepends;
    }

    @Override
    public String toString() {
        return String
                .format("ApiServiceDoc: {service:%s, version:%s, serviceName:%s, serviceType:%s, note:%s, manualNote:%s, manualDemo:%s, messageDocs:%s}",
                        service, version, serviceName, serviceType, note, manualNote, manualDemo, messageDocs);
    }

}
