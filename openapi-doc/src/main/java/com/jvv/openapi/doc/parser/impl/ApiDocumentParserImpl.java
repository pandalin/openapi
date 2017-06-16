/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */

package com.jvv.openapi.doc.parser.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.jvv.openapi.core.service.base.ApiService;
import com.jvv.openapi.core.service.entity.ApiNotify;
import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiField;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.doc.enums.ApiDataType;
import com.jvv.openapi.doc.enums.FieldStatus;
import com.jvv.openapi.doc.enums.MessageType;
import com.jvv.openapi.doc.parser.ApiDocumentParser;
import com.jvv.openapi.doc.parser.ApiServiceScanner;
import com.jvv.openapi.doc.persist.db.domain.ApiItemDoc;
import com.jvv.openapi.doc.persist.db.domain.ApiMessageDoc;
import com.jvv.openapi.doc.persist.db.domain.ApiServiceDepend;
import com.jvv.openapi.doc.persist.db.domain.ApiServiceDoc;
import com.jvv.openapi.doc.utils.ApiDataTypeUtils;
import com.jvv.openapi.doc.utils.ApiDocPrivateUtils;
import com.jvv.openapi.doc.utils.ApiRedirect;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ApiDocumentParserImpl implements ApiDocumentParser {

    private static final Logger logger = LoggerFactory.getLogger(ApiDocumentParserImpl.class);

    private String packagePattern = "classpath:com.jvv.openapi.service./**/*.class";

    @Autowired
    private ApiServiceScanner apiServiceScanner;

    @Override
    public List<ApiServiceDoc> parse(String packagePattern) {
        List<Class<?>> apiClasses = doScan(packagePattern);
        List<ApiServiceDoc> docs = Lists.newArrayList();
        for (Class<?> clazz : apiClasses) {
            docs.add(doParseService(clazz));
        }
        return docs;
    }

    /**
     * 扫描服务
     *
     * @return
     */
    protected List<Class<?>> doScan(String packagePattern) {
        return apiServiceScanner.scan(packagePattern);
    }

    /**
     * 解析文档
     *
     * @param clazz
     * @return
     */
    protected ApiServiceDoc doParseService(Class<?> clazz) {
        try {
            ApiServiceDoc doc = new ApiServiceDoc();
            //获取服务对应的实体
            ApiService<?, ?> service = (ApiService<?, ?>) clazz.newInstance();
            ApiRequest request = service.getRequestBean();
            ApiResponse response = service.getResponseBean();
//            ApiNotify notify = service.getApiNotifyBean();
            ApiRedirect redirect = new ApiRedirect();
            OpenApiService openApiService = service.getClass().getAnnotation(OpenApiService.class);
            doc.setService(openApiService.name());
            doc.setServiceName(openApiService.desc());
            doc.setVersion(openApiService.version());
            doc.setServiceNo(doc.getService() + "_" + doc.getVersion());
            doc.setServiceType(openApiService.responseType().getMessage());
            doc.setOwner(openApiService.owner());
            List<ApiMessageDoc> mds = Lists.newArrayList();
            mds.addAll(doParseMessage(request.getClass()));



            if (!ResponseTypeEnum.REDIRECT.equals(openApiService.responseType())) {
                mds.addAll(doParseMessage(response.getClass()));
            } else {
                //增加跳转类型messageDoc
                ApiMessageDoc redirectApiMessageDoc = new ApiMessageDoc();
                redirectApiMessageDoc.setApiItems(parseMessage(redirect.getClass(), null,Object.class));
                redirectApiMessageDoc.setMessageType(MessageType.Redirect);
                mds.add(redirectApiMessageDoc);
            }
            if (openApiService.responseType() == ResponseTypeEnum.ASNY
                    || openApiService.responseType() == ResponseTypeEnum.REDIRECT) {
//                if (!notify.getClass().isAssignableFrom(ApiNotify.class)) {
//                    mds.addAll(doParseMessage(notify.getClass()));
//                }
            }
            doc.setMessageDocs(mds);
            doParseServiceDepend(service,doc);
            logger.warn("Parse service success, [{}],{}", clazz);
            return doc;
        } catch (Exception e) {
            logger.warn("parse service fail: {}", clazz, e);
            return null;
        }

    }

    /**
     * 解析服务对于的请求、响应、跳转、异步实体
     *
     * @param service
     * @return
     */
    protected void doParseServiceDepend(ApiService<?, ?> service, ApiServiceDoc doc) {
        try {
            ApiServiceDepend apiServiceDepend = new ApiServiceDepend();
            ApiRequest request = service.getRequestBean();
            if (!request.getClass().isAssignableFrom(ApiRequest.class)) {
                apiServiceDepend.setRequest(request.getClass().getSimpleName());
            }
            ApiResponse response = service.getResponseBean();
            if (!response.getClass().isAssignableFrom(ApiResponse.class)) {
                apiServiceDepend.setResponse(response.getClass().getSimpleName());
            }
//            ApiNotify notify = service.getApiNotifyBean();
//            if (!notify.getClass().isAssignableFrom(ApiNotify.class)) {
//                apiServiceDepend.setNotify(notify.getClass().getSimpleName());
//            }
            ApiRedirect redirect = new ApiRedirect();
            if (!redirect.getClass().isAssignableFrom(ApiRedirect.class)) {
                apiServiceDepend.setRedirect(redirect.getClass().getSimpleName());
            }
            List<ApiServiceDepend> list = new ArrayList<>();
            list.add(apiServiceDepend);
            doc.setApiServiceDepends(list);
        } catch (Exception e) {
            logger.warn("parse serviceDepend fail: {}", service, e);
        }
    }

    protected List<ApiMessageDoc> doParseMessage(final Class<?> clazz) {
        List<ApiMessageDoc> docList = Lists.newArrayList();
        ApiMessageDoc messageDoc = new ApiMessageDoc();
        Class<?> superClazz = Object.class;
        MessageType messageType = null;
        if (ApiRequest.class.isAssignableFrom(clazz)) {
            messageType = MessageType.Request;
            superClazz = ApiRequest.class;
        } else if (ApiNotify.class.isAssignableFrom(clazz)) {
            messageType = MessageType.Notify;
            superClazz = ApiNotify.class;
        } else if (ApiResponse.class.isAssignableFrom(clazz)) {
            messageType = MessageType.Response;
            superClazz = ApiResponse.class;
        } else {
            throw new IllegalArgumentException("Class " + clazz.getName() + "not a supported " + "messageDoc type.");
        }
        messageDoc.setMessageType(messageType);
        messageDoc.setFlag("DIY");
        messageDoc.setApiItems(parseMessage(clazz, null,superClazz));

        ApiMessageDoc sysMessageDoc = new ApiMessageDoc();
        sysMessageDoc.setApiItems(parseMessage(superClazz, null,Object.class));
        sysMessageDoc.setFlag("SYS");
        sysMessageDoc.setMessageType(messageType);
        docList.add(sysMessageDoc);

        docList.add(messageDoc);

        return docList;
    }

    protected List<ApiItemDoc> parseMessage(final Class<?> clazz, String igornFieldNames, Class<?> superClazz) {
        List<ApiItemDoc> apiItems = Lists.newArrayList();

        Class<?> sclazz = clazz.getSuperclass();
        if(Object.class.equals(clazz) || clazz.equals(superClazz)){
            return apiItems;
        }else{
            apiItems.addAll(parseMessage(sclazz,igornFieldNames,superClazz));
        }

        Class<?> cc = clazz;
        do {
            Field[] fields = cc.getDeclaredFields();
            for (Field field : fields) {

                if (Modifier.isStatic(field.getModifiers())) {
                    continue;
                }
                //OpenApiField标识的才做解析
                if (!field.isAnnotationPresent(OpenApiField.class)) {
                    continue;
                }

                ApiItemDoc item = null;
                item = parseItem(field);

                if (item == null) {
                    continue;
                }
                // 忽略的属性
                if (StringUtils.isNotBlank(igornFieldNames) && igornFieldNames.contains(field.getName())) {
                    apiItems.add(item);
                    continue;
                }

                if (ApiDataType.JSON.equals(item.getDataType())) {
                    // Map or entity
                    String igornFieldName = null;
                    //entity获取循环引用的Filed 不对循环引用的Field进行转换
                    if (!item.getClass().isAssignableFrom(Map.class)) {
                        igornFieldName = checkRecursionField(field.getType());
                    }

                    item.setChildren(parseMessage(field.getType(), igornFieldName,Object.class));

                    //复杂类型demo
                    String demo = jsonItem(item);
                    demo = demo.substring(demo.indexOf(":") + 1);
                    item.setDemo(demo == null ? "" : demo);
                }
                if (ApiDataType.JSON_ARRAY.equals(item.getDataType())) {
                    // Array
                    Class<?> genericClass = ApiDocPrivateUtils.getParameterGenericType(clazz, field);
                    if (genericClass != null && !ApiDataTypeUtils.isSimpleType(genericClass)) {
                        String igornFieldName = checkRecursionField(genericClass);
                        item.setChildren(parseMessage(genericClass, igornFieldName,Object.class));
                    }
                    //复杂类型demo
                    String demo = jsonItem(item);
                    demo = demo.substring(demo.indexOf(":") + 1);
                    item.setDemo(demo == null ? "" : demo);
                }
                apiItems.add(item);
            }
            cc = cc.getSuperclass();
        }
        while (cc != null && cc != ApiRequest.class && cc != ApiResponse.class && cc != ApiNotify.class && cc != Object.class);

        return apiItems;
    }

    private String jsonItem(ApiItemDoc itemDoc) {
        StringBuilder jsonBuilder = new StringBuilder();
        String json = "";

        if (ApiDataType.JSON.equals(itemDoc.getDataType())) {
            if (CollectionUtils.isNotEmpty(itemDoc.getChildren())) {
                for (ApiItemDoc item : itemDoc.getChildren()) {
                    String childJson = jsonItem(item);
                    jsonBuilder.append(childJson);
                    if (StringUtils.isNotBlank(childJson)) {
                        jsonBuilder.append(",");
                    }
                }
                json = jsonBuilder.toString();
                json = "{" + json.substring(0, json.length() - 1) + "}";
            }
            json = "\"" + itemDoc.getName() + "\"" + ":" + json;
        } else if (ApiDataType.JSON_ARRAY.equals(itemDoc.getDataType())) {
            if (CollectionUtils.isNotEmpty(itemDoc.getChildren())) {
                for (ApiItemDoc item : itemDoc.getChildren()) {
                    String childJson = jsonItem(item);
                    jsonBuilder.append(childJson);
                    if (StringUtils.isNotBlank(childJson)) {
                        jsonBuilder.append(",");
                    }
                }
                json = jsonBuilder.toString();
                json = "[{" + json.substring(0, json.length() - 1) + "}]";
            }
            json = "\"" + itemDoc.getName() + "\"" + ":" + json;
        } else {
            json += "\"" + itemDoc.getName() + "\":\"" + itemDoc.getDemo() + "\"";
        }

        return json;
    }

    private String checkRecursionField(Class<?> clazz) {
        Field[] fs = clazz.getDeclaredFields();
        for (Field f : fs) {
            if (clazz.equals(f.getType()) || clazz.equals(ApiDocPrivateUtils.getParameterGenericType(clazz, f))) {
                return f.getName();
            }
        }
        return null;
    }

    private ApiItemDoc parseItem(Field field) {
        OpenApiField openApiField = field.getAnnotation(OpenApiField.class);
        String desc = "";
        String constraint = "";
        if (field.getType().isEnum()) {
            Object[] objects = field.getType().getEnumConstants();
            //获取枚举名并引入
            String enumName = field.getType().getName();
            Class model = null;
            try {
                model = Class.forName(enumName);
            } catch (Exception e) {
                logger.error("找不到枚举名", enumName);
            }
            //获得Model类的get方法，无参数
            Method getMethod = null;
            try {
                getMethod = model.getMethod("getMessage", null);
            } catch (NoSuchMethodException e) {
                logger.error("没有找到getMessagee方法", enumName);
                try {
                    getMethod = model.getMethod("getResultMessage", null);
                } catch (NoSuchMethodException e1) {
                    logger.error("没有找到getResultMessage方法", enumName);
                    try {
                        getMethod = model.getMethod("getValue", null);
                    } catch (NoSuchMethodException e2) {
                        logger.error("没有找到getValue方法", enumName);
                    }
                }
            } catch (Exception e) {
                logger.error("其他异常", enumName);
            }
            //遍历message
            List<String> strList = new ArrayList<String>();
            for (Object object : objects) {
                Object message = null;
                try {
                    message = getMethod.invoke(object, null);
                    strList.add(object.toString() + ":" + message.toString());
                } catch (Exception e) {
                    logger.error("调用方法失败", object, enumName);
                }
            }
            JSONObject constraintJsonObject = new JSONObject();
            constraintJsonObject.put("data", strList);
            if (StringUtils.isBlank(openApiField.constraint())) {
                constraintJsonObject.put("name", openApiField.desc());
            } else {
                constraintJsonObject.put("name", openApiField.desc());
            }
            constraint = constraintJsonObject.toJSONString();
        } else {
            if (StringUtils.isBlank(openApiField.constraint())) {
                constraint = openApiField.desc();
            } else {
                constraint = openApiField.constraint();
            }
        }
        if (openApiField != null) {
            desc = openApiField.desc() + desc;
            return new ApiItemDoc(field.getName(), openApiField.desc(), ApiDataTypeUtils.converetToApiData(field),
                    ApiDataTypeUtils.getDataLength(field), getStatus(field), constraint, openApiField.demo());
        } else {
            // 非openAPI规范对象
            desc = field.getName() + desc;
            return new ApiItemDoc(field.getName(), field.getName(), ApiDataTypeUtils.converetToApiData(field),
                    ApiDataTypeUtils.getDataLength(field), getStatus(field), desc, "");
        }

    }

    /**
     * 判断是否为空
     *
     * @param field
     * @return
     */
    private FieldStatus getStatus(Field field) {
//        OpenApiConditional openApiConditional = field.getAnnotation(OpenApiConditional.class);
        FieldStatus status = FieldStatus.O;
        if (!(field.getAnnotation(NotNull.class) == null && field.getAnnotation(NotEmpty.class) == null && field
                .getAnnotation(NotBlank.class) == null)) {
            status = FieldStatus.M;
        }
        //是否条件可选
//        if (openApiConditional != null) {
//            status = FieldStatus.C;
//        }
        return status;
    }

    public String getPackagePattern() {
        return packagePattern;
    }

    public void setPackagePattern(String packagePattern) {
        this.packagePattern = packagePattern;
    }

    public ApiServiceScanner getApiServiceScanner() {
        return apiServiceScanner;
    }

    public void setApiServiceScanner(ApiServiceScanner apiServiceScanner) {
        this.apiServiceScanner = apiServiceScanner;
    }
}
