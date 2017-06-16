/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * zhike@jinvovo.com 2016-07-27 15:10 创建
 *
 */
package com.jvv.openapi.doc.persist.db.domain;

/**
 * @author zhike@jinvovo.com
 */
public class ApiServiceDepend extends AbstractDomain {

    private String request;

    private String response;

    private String notify;

    private String redirect;

//    private ApiServiceDoc apiServiceDoc;

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getNotify() {
        return notify;
    }

    public void setNotify(String notify) {
        this.notify = notify;
    }

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

//    public ApiServiceDoc getApiServiceDoc() {
//        return apiServiceDoc;
//    }
//
//    public void setApiServiceDoc(ApiServiceDoc apiServiceDoc) {
//        this.apiServiceDoc = apiServiceDoc;
//    }
}
