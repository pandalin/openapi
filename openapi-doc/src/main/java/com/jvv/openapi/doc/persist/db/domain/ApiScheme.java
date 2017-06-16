/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */

package com.jvv.openapi.doc.persist.db.domain;

import java.util.List;
import java.util.Set;

/**
 * Created by zhangpu on 2015/1/27.
 */
public class ApiScheme extends AbstractDomain {

	private String name;

	private String author;

	private String note;
	
	//解决方案类型（web：网页支付，mobile:移动支付,international：国际支付）
	private String schemeType;
	
	//解决方案访问类型（out：外网内网都可以访问，in：只允许内网可以访问）
	private String visitType;
	
	//解决方案名称类型，主要用于区分支付产品中的业务接入和行业开放
	private String nameType;
	
	//解决方案英文名称
	private String englishName;
	
	private Set<ApiSchemeServiceDoc> serviceNos;

	private ApiSchemeContent schemeContent;

	private List<ApiServiceDoc> services;

	public String getEnglishName() {
		return this.englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public String getNameType() {
		return this.nameType;
	}

	public void setNameType(String nameType) {
		this.nameType = nameType;
	}

	public String getName() {
		return name;
	}
	
	public String getVisitType() {
		return this.visitType;
	}


	public void setVisitType(String visitType) {
		this.visitType = visitType;
	}


	public String getSchemeType() {
		return this.schemeType;
	}

	public void setSchemeType(String schemeType) {
		this.schemeType = schemeType;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Set<ApiSchemeServiceDoc> getServiceNos() {
		return serviceNos;
	}

	public void setServiceNos(Set<ApiSchemeServiceDoc> serviceNos) {
		this.serviceNos = serviceNos;
	}

	public List<ApiServiceDoc> getServices() {
		return services;
	}

	public void setServices(List<ApiServiceDoc> services) {
		this.services = services;
	}

	public ApiSchemeContent getSchemeContent() {
		return schemeContent;
	}

	public void setSchemeContent(ApiSchemeContent schemeContent) {
		this.schemeContent = schemeContent;
	}
}
