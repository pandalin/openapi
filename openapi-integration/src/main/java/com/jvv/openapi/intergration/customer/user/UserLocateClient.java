/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.intergration.customer.user;

import com.jvv.customer.facade.user.api.UserLocateApi;
import com.jvv.customer.facade.user.api.UserResetPwdApi;
import com.jvv.customer.facade.user.order.UserLocateOrder;
import com.jvv.customer.facade.user.order.UserResetPwdOrder;
import com.jvv.customer.facade.user.result.UserLocateResult;
import com.jvv.customer.facade.user.result.UserResetPwdResult;
import com.jvv.openapi.intergration.Client;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA
 * 〈用户地址位置〉 <p>
 * 〈用户地址位置〉
 *
 * @author linxm
 * @date 2017/3/20
 * @time 10:55
 */
@Component("userLocateClient")
public class UserLocateClient extends Client {
	
	/**
	 * 保存用户地理位置信息
	 *
	 * @param cityCode
	 * @param userId
	 * @param longitude
	 * @param latitude    @return
	 */
	public UserLocateResult saveUserLocate (String userId,String longitude,String latitude,
	                                        String cityCode, String cityName,
											String countryCode, String countryName ,
											String province) {
		UserLocateApi userLocateApi = getDubboClient (UserLocateApi.class);
		
		UserLocateOrder userLocateOrder = new UserLocateOrder ();
		userLocateOrder.setUserId (userId);
		userLocateOrder.setLongitude (longitude);
		userLocateOrder.setLatitude (latitude);
		userLocateOrder.setCityCode (cityCode);
		userLocateOrder.setCityName (cityName);
		userLocateOrder.setCountyCode (countryCode);
		userLocateOrder.setCountyName (countryName);
		userLocateOrder.setProvince(province);
		
		return userLocateApi.saveUserLocate (userLocateOrder);
	}
	
}
