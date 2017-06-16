/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */

/**
 * create by zhangpu
 * date:2015年5月25日
 */
package com.jvv.openapi.doc;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author zhangpu
 *
 */
public class ApidocContext {

	private String title = "OpenApi自动文档";
	private String subTitle;
	private Map<String, String> links = Maps.newLinkedHashMap();

	public void appendLink(String title, String url) {
		links.put(title, url);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public Map<String, String> getLinks() {
		return links;
	}

	public void setLinks(Map<String, String> links) {
		this.links = links;
	}

}
