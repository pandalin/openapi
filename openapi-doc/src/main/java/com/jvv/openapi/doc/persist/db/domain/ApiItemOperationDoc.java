/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */

package com.jvv.openapi.doc.persist.db.domain;

import com.jvv.openapi.doc.enums.ApiDataType;
import com.jvv.openapi.doc.enums.FieldStatus;

/**
 * API文档字段项
 *
 * @author zhike@jinvovo.com
 */
public class ApiItemOperationDoc extends AbstractDomain {
	/**
	 * 字段名称
	 */
	private String name;
	/**
	 * 字段标题
	 */
	private String title;
	/**
	 * 数据类型
	 */
	private ApiDataType dataType;
	/**
	 * 是否可选
	 */
	private FieldStatus status;
	
	/**
	 * 使用状态
	 */
	private String isUseStatus;
	
	/**
	 * 字段描述
	 */
	private String descn;
	/**
	 * 人工附加说明
	 */
	private String manualNote;
	/**
	 * 长度
	 */
	private String dataLength;

	/**
	 * item编号 serviceNo_messageType_name
	 */
	private String itemNo;

	/**
	 * 字段示例
	 */
	private String demo;
	
	/**
	 * 关联messageid
	 */
	private String messageId;
	
	private String children;
	
	
	public String getChildren() {
		return this.children;
	}

	public void setChildren(String children) {
		this.children = children;
	}

	public String getMessageId() {
		return this.messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public ApiItemOperationDoc() {
		super();
	}

	public ApiItemOperationDoc(String name, String title, ApiDataType dataType,String dataLength,
					  FieldStatus status,
					  String descn,String demo,String isUseStatus) {
		super();
		this.name = name;
		this.title = title;
		this.dataType = dataType;
		this.dataLength = dataLength;
		this.status = status;
		this.descn = descn;
		this.isUseStatus = isUseStatus;
		if(demo == null){
			this.demo = "";
		}
		this.demo = demo;
	}

	public String getIsUseStatus() {
		return this.isUseStatus;
	}

	public void setIsUseStatus(String isUseStatus) {
		this.isUseStatus = isUseStatus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ApiDataType getDataType() {
		return dataType;
	}

	public void setDataType(ApiDataType dataType) {
		this.dataType = dataType;
	}

	public FieldStatus getStatus() {
		return status;
	}

	public void setStatus(FieldStatus status) {
		this.status = status;
	}

	public String getDescn() {
		return descn;
	}

	public void setDescn(String descn) {
		this.descn = descn;
	}

	public String getManualNote() {
		return manualNote;
	}

	public void setManualNote(String manualNote) {
		this.manualNote = manualNote;
	}

	public String getDataLength() {
		return dataLength;
	}

	public void setDataLength(String dataLength) {
		this.dataLength = dataLength;
	}

	public String getItemNo() {
		return itemNo;
	}

	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}

	public String getDemo() {
		return demo;
	}

	public void setDemo(String demo) {
		this.demo = demo;
	}

	@Override
	public String toString() {
		return String
				.format("ApiItemOperationDoc: {name:%s, title:%s, dataType:%s, status:%s, descn:%s, manualNote:%s}",
						name, title, dataType, status, descn, manualNote);
	}

}
