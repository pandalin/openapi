package com.jvv.openapi.service.notify.response;

import com.jvv.openapi.core.service.entity.AbstractResponseData;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/6/6
 * @time 17:28
 */
public class SimpleResponseData extends AbstractResponseData {
	private Object info;
	
	private List list;
	
	private Integer count;
	
	public Object getInfo () {
		return info;
	}
	
	public void setInfo (Object info) {
		this.info = info;
	}
	
	public List getList () {
		return list;
	}
	
	public void setList (List list) {
		this.list = list;
	}
	
	public Integer getCount () {
		return count;
	}
	
	public void setCount (Integer count) {
		this.count = count;
	}
}
