/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */

package com.jvv.openapi.doc.parser.impl;

import com.google.common.collect.Lists;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.doc.parser.ApiServiceScanner;
import com.jvv.openapi.doc.persist.db.domain.ApiServiceDoc;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.List;
import java.util.Map;

/**
 * Api服务扫描 Spring工具实现
 *
 * @author zhangpu
 */
//@Service
public class SpringContextApiServiceScanner implements ApiServiceScanner, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public List<Class<?>> scan(String packagePattern) {
        List<Class<?>> classes = Lists.newArrayList();
        try {
            Map<String, ApiServiceDoc> apiServiceMap = applicationContext.getBeansOfType(ApiServiceDoc.class);
            for (ApiServiceDoc apiService : apiServiceMap.values()) {
                OpenApiService openApiService = getOpenApiServiceAnnotation(apiService);
                if (openApiService != null) {
                    classes.add(apiService.getClass());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("扫描ApiService失败:" + e.getMessage());
        }
        return classes;
    }

    private OpenApiService getOpenApiServiceAnnotation(ApiServiceDoc apiService) {
        return apiService.getClass().getAnnotation(OpenApiService.class);

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
