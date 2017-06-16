/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.intergration.synOldSystem;

import com.jvv.gateway.facade.synOldSystem.api.SynOldSystemApi;
import com.jvv.gateway.facade.synOldSystem.order.SynOldSystemOrder;
import com.jvv.gateway.facade.synOldSystem.result.SynOldSystemResult;
import com.jvv.openapi.intergration.Client;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/4/17
 * @time 16:22
 */
@Component
public class SynOldSystemClient extends Client {
	/**
	 * 同步金窝窝老系统接口
	 * @param synOldSystemOrder
	 * @return
	 */
	public SynOldSystemResult syn(SynOldSystemOrder synOldSystemOrder){
		return getDubboClient(SynOldSystemApi.class).syn(synOldSystemOrder);
	}
}
