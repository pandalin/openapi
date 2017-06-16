/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-22 19:45 创建
 *
 */
package com.jvv.openapi.core.servlet;

import com.jvv.openapi.common.util.GidGenerater;
import com.jvv.openapi.core.service.ApiConstants;
import com.jvv.openapi.core.util.MDCUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 基于Spring服务的Servlet基础类
 *
 * <li>1、整合Spring容器到Servlet中，方便子类直接获取Spring容器内的服务 <li>2、提Servlet处理基础模板框架 <li>
 * 3、提供对Servlet配置参数的获取封装
 *
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/22 19:45
 */

public abstract class AbstractSpringServlet extends HttpServlet {
	/** UID */
	private static final long serialVersionUID = 4968964220869359245L;
	
	public static final String HTTP_METHOD_GET = "GET";
	public static final String HTTP_METHOD_HEAD = "HEAD";
	public static final String HTTP_METHOD_POST = "POST";
	public static final String HTTP_METHOD_PUT = "PUT";
	public static final String HTTP_METHOD_DELETE = "DELETE";
	public static final String HTTP_METHOD_OPTIONS = "OPTIONS";
	
	private static final Logger logger = LoggerFactory.getLogger(AbstractSpringServlet.class);
	
	/** WebApplicationContext for this servlet */
	private WebApplicationContext webApplicationContext;
	
	@Override
	public void init() throws FrameworkServletException {
		logger.debug("Initializing Spring-based Servlet '" + getServletName() + "'");
		this.webApplicationContext = WebApplicationContextUtils
			.getWebApplicationContext(getServletContext());
		doInit();
	}
	
	protected <T> T getBean(String name, Class<T> requestType) {
		return webApplicationContext.getBean(name, requestType);
	}
	
	protected Object getBean(String name) {
		return webApplicationContext.getBean(name);
	}
	
	protected String getStringParameter(String name) {
		return getInitParameter(name);
	}
	
	protected long getLongParameter(String name) {
		try {
			return Long.parseLong(getStringParameter(name));
		} catch (Exception e) {
			throw new RuntimeException("Parse init parameter to long failure.[" + name + ":"
										+ getStringParameter(name) + "]");
		}
	}
	
	protected int getIntParameter(String name) {
		try {
			return Integer.parseInt(getStringParameter(name));
		} catch (Exception e) {
			throw new RuntimeException("Parse init parameter to int failure.[" + name + ":"
										+ getStringParameter(name) + "]");
		}
	}
	
	protected List<String> getParameter(String name) {
		String value = getStringParameter(name);
		if (value == null || "".equals(value)) {
			return new ArrayList<String>(0);
		}
		String[] array = value.split(",");
		return Arrays.asList(array);
	}
	
	protected void doInit() {
		
	}
	
	protected abstract void doService(String method, HttpServletRequest request,
										HttpServletResponse response)
																		throws FrameworkServletException;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
																			IOException {
		long start = new Date().getTime();
		setLogKey(req);
		logger.info("==>>>收到GET请求.....");
		doService(HTTP_METHOD_GET, req, resp);
		logger.info("<<<==处理GET请求完成！耗时{}毫秒\n\n", new Date().getTime() - start);
	}
	
	@Override
	protected void doHead(HttpServletRequest req, HttpServletResponse resp)
																			throws ServletException,
																			IOException {
		long start = new Date().getTime();
		setLogKey(req);
		logger.info("==>>>收到HEAD请求.....");
		doService(HTTP_METHOD_HEAD, req, resp);
		logger.info("<<<==处理HEAD请求完成！耗时{}毫秒\n\n", new Date().getTime() - start);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
																			throws ServletException,
																			IOException {
		long start = new Date().getTime();
		setLogKey(req);
		logger.info("==>>>收到POST请求.....");
		doService(HTTP_METHOD_POST, req, resp);
		logger.info("<<<==处理POST请求完成！耗时{}毫秒\n\n", new Date().getTime() - start);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
																			IOException {
		long start = new Date().getTime();
		setLogKey(req);
		logger.info("==>>>收到PUT请求.....");
		doService(HTTP_METHOD_PUT, req, resp);
		logger.info("<<<==处理PUT请求完成！耗时{}毫秒\n\n", new Date().getTime() - start);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
																				throws ServletException,
																				IOException {
		long start = new Date().getTime();
		setLogKey(req);
		logger.info("==>>>收到DELETE请求.....");
		doService(HTTP_METHOD_DELETE, req, resp);
		logger.info("<<<==处理DELETE请求完成！耗时{}毫秒\n\n", new Date().getTime() - start);
	}
	
	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp)
																				throws ServletException,
																				IOException {
		long start = new Date().getTime();
		setLogKey(req);
		logger.info("==>>>收到OPTIONS请求.....");
		doService(HTTP_METHOD_OPTIONS, req, resp);
		logger.info("<<<==处理OPTIONS请求完成！耗时{}毫秒\n\n", new Date().getTime() - start);
	}
	
	@Override
	public void destroy() {
		webApplicationContext = null;
	}
	
	protected void setLogKey(HttpServletRequest req) {
		req.setAttribute(ApiConstants.GID, GidGenerater.generateGid(ApiConstants.GID_BIZ_CODE));
		String orderNo = req.getParameter(ApiConstants.ORDER_NO);
		MDCUtils.setLogKey(GidGenerater.generateGid() + ":" + orderNo);
	}
	
	public WebApplicationContext getWebApplicationContext() {
		return webApplicationContext;
	}
	
}
