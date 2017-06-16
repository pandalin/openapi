/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */

package com.jvv.openapi.doc.parser.impl;

import com.google.common.collect.Lists;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.doc.parser.ApiServiceScanner;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Service;

import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.List;

/**
 * Api服务扫描 Spring工具实现
 *
 * @author zhangpu
 */
@Service
public class SpringResourceApiServiceScanner implements ApiServiceScanner {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public List<Class<?>> scan(String packagePattern) {
		ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
		List<Class<?>> classes = Lists.newArrayList();
		try {
			Resource[] resources = resourcePatternResolver.getResources(packagePattern);
			ClassLoader loader = this.getClass().getClassLoader();
			String binaryName = null;
			for (Resource resource : resources) {
				binaryName = getCanonicalClassPath(resource);
				try {
					Class<?> clazz = loader.loadClass(binaryName);
					if (Modifier.isAbstract(clazz.getModifiers())) {
						continue;
					}
					if (clazz.getAnnotation(OpenApiService.class) != null) {
						classes.add(clazz);
					}
				} catch (Exception e) {
					logger.info("加载类{}失败:{}",binaryName,e);
					continue;
				}
			}
		} catch (Exception e) {
			throw new RuntimeException("扫描ApiService失败:" + e.getMessage());
		}
		return classes;
	}

	protected String getCanonicalClassPath(Resource resource) {
		try {
			URL classFileUrl = resource.getURL();
			String path = classFileUrl.getPath();
			if (StringUtils.contains(path, "classes/")) {
				path = StringUtils.substringAfterLast(path, "classes/");
			}
			if (StringUtils.contains(path, "jar!/")) {
				path = StringUtils.substringAfterLast(path, "jar!/");
			}
			path = path.replaceAll("/", ".").replace(".class", "");
			return path;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	public static void main(String[] args) throws Exception {
		Resource resource = new DefaultResourceLoader().getResource("file:///d:temp/");
		System.out.println(resource.getURL());
		URL url = resource.getURL();
		System.out.println(url.getPath());
		System.out.println(url.getRef());
	}

}
