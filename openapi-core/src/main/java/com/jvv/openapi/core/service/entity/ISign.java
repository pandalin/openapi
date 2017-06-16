/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-27 10:56 创建
 *
 */
package com.jvv.openapi.core.service.entity;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/27 10:56
 */

public interface ISign {
	
	/** 获取签约类型 */
	public String getSignType();
	
	/** 设置签约类型 */
	public void setSignType(String signType);
	
	/** 获取签约字符串 */
	public String getSign();
	
	/** 设置签约字符串 */
	public void setSign(String sign);
}
