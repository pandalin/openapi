/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */

package com.jvv.openapi.doc.persist.db.domain;

import com.jvv.openapi.doc.enums.MessageType;

import java.util.List;


/**
 * 报文文档
 *
 * @author zhangpu
 */
public class ApiMessageDoc extends AbstractDomain {

	private static final long serialVersionUID = 1L;

	private String flag = "DIY";

	/**
	 * 消息类型
	 */
	private MessageType messageType;
	/**
	 * 业务说明或备注
	 */
	private String note;
	/**
	 * 人工附加说明
	 */
	private String manualNote;
	/**
	 * 字段域
	 */
	private List<ApiItemDoc> apiItems;

	public MessageType getMessageType() {
		return messageType;
	}

	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
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

	public List<ApiItemDoc> getApiItems() {
		return apiItems;
	}

	public void setApiItems(List<ApiItemDoc> apiItems) {
		this.apiItems = apiItems;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return String.format(
				"ApiMessageDoc: {messageType:%s, note:%s, manualNote:%s, apiItems:%s}",
				messageType, note, manualNote, apiItems);
	}

}
