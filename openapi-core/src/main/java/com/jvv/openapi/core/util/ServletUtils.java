/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-23 22:47 创建
 *
 */
package com.jvv.openapi.core.util;

import com.google.common.collect.Maps;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/23 22:47
 */

public class ServletUtils {

	public static void writeResponse(HttpServletResponse response, String data) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		try  {
			Writer writer = response.getWriter();
			writer.write(data);
		} catch (Exception e) {
			throw new RuntimeException("响应请求(flushResponse)失败:", e);
		}
	}

	public static void redirect(HttpServletResponse response, String location) {
		try {
			response.sendRedirect(location);
		} catch (Exception e) {
			throw new RuntimeException("重定向失败,location:" + location + " :", e);
		}
	}

	/**
	 * 获取参数map,我们不允许用户传入多个同名参数.
	 *
	 * @param request
	 * @return
	 */
	public static Map<String, String> getParamMap(ServletRequest request) {
		Assert.notNull(request, "Request must not be null");
		Map<String, String> params = Maps.newHashMap();
		Enumeration<String> enumeration = request.getParameterNames();
		while (enumeration.hasMoreElements()) {
			String name = enumeration.nextElement();
			String[] values = request.getParameterValues(name);
			if (values == null || values.length == 0) {
				continue;
			}
			String value = values[0];
			if (value != null) {
				params.put(name, value);
			}
		}
		return params;
	}

	public static String buildQueryString(Map<String, String> params) {
		if (params == null || params.size() == 0) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		Iterator<Map.Entry<String, String>> it = params.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> entry = it.next();
			if (entry.getValue() != null) {
				sb.append(entry.getKey()).append('=').append(EncodeUtils.urlEncode(entry.getValue()));
			}
			if (it.hasNext()) {
				sb.append('&');
			}
		}
		return sb.toString();
	}
}
