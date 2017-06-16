/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.response;


import com.jvv.facade.sixdegree.info.AddPeopleNumberInfo;
import com.jvv.facade.sixdegree.info.DownSixDegreePeopleNumberInfo;
import com.jvv.openapi.core.service.entity.AbstractResponseData;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/4/19
 * @time 15:07
 */
public class SixDegreeCountResponseData extends AbstractResponseData{
	
	/**
	 * 下一至六度单度数人数
	 */
//	protected Integer downOne;
//	protected Integer downTwo;
//	protected Integer downThree;
//	protected Integer downFour;
//	protected Integer downFive;
//	protected Integer downSix;
	
	/**
	 * 用集合存储下一到六度的人数
	 */
	List<DownSixDegreePeopleNumberInfo> list;
	
	/**
	 * 下六度总人数
	 */
	protected  Integer total;
	/**
	 * 几年几月几日增加的用户量
	 */
	List<AddPeopleNumberInfo> addPeopleNumberInfoList;
	
	public Integer getTotal () {
		return total;
	}
	
	public void setTotal (Integer total) {
		this.total = total;
	}
	
	public List<AddPeopleNumberInfo> getAddPeopleNumberInfoList () {
		return addPeopleNumberInfoList;
	}
	
	public void setAddPeopleNumberInfoList (
			List<AddPeopleNumberInfo> addPeopleNumberInfoList) {
		this.addPeopleNumberInfoList = addPeopleNumberInfoList;
	}
	
	public List<DownSixDegreePeopleNumberInfo> getList () {
		return list;
	}
	
	public void setList (List<DownSixDegreePeopleNumberInfo> list) {
		this.list = list;
	}
}
