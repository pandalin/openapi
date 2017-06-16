/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.intergration.customer.user;

import com.jvv.customer.facade.base.result.SimpleResult;
import com.jvv.customer.facade.constants.enums.UserPwdTypeEnum;
import com.jvv.customer.facade.user.api.UserResetPwdApi;
import com.jvv.customer.facade.user.order.GetBackUserPwdOrder;
import com.jvv.customer.facade.user.order.UserModifyPwdOrder;
import com.jvv.customer.facade.user.order.UserResetPwdOrder;
import com.jvv.customer.facade.user.order.UserSetPwdOrder;
import com.jvv.customer.facade.user.result.UserResetPwdResult;
import com.jvv.openapi.intergration.Client;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA
 * 〈重置密码〉 <p>
 * 〈重置密码〉
 *
 * @author linxm
 * @date 2017/3/16
 * @time 9:31
 */
@Component("userResetPwdClient")
public class UserResetPwdClient extends Client {
	
	/**
	 * php重置密码
	 * @param userId
	 * @param realname
	 * @param idcard
	 * @param pwdType
	 * @return
	 */
	public UserResetPwdResult resetPwd(String userId,String realname,String idcard,int pwdType) {
		UserResetPwdApi userResetPwdApi = getDubboClient (UserResetPwdApi.class);
		
		UserResetPwdOrder userResetPwdOrder = new UserResetPwdOrder ();
		userResetPwdOrder.setUserId (userId);
		userResetPwdOrder.setRealname (realname);
		userResetPwdOrder.setIdcard (idcard);
		userResetPwdOrder.setPwdType (pwdType);
		
		return userResetPwdApi.resetPwd (userResetPwdOrder);
	}
	
	/**
	 * app设置密码
	 * @param userId
	 * @param password
	 * @param confirmPassword
	 * @param smsCode
	 * @param pwdType
	 * @return
	 */
	public SimpleResult setUserPwd(String userId,
								   String password, String confirmPassword,
								   String smsCode,String pwdType) {
		UserResetPwdApi userResetPwdApi = getDubboClient (UserResetPwdApi.class);
		
		UserSetPwdOrder order = new UserSetPwdOrder ();
		order.setUserId (userId);
		order.setPassword (password);
		order.setConfirmPassword (confirmPassword);
		order.setSmsCode(smsCode);
		order.setPwdType (UserPwdTypeEnum.getByCode (pwdType));
		
		return userResetPwdApi.setUserPwd (order);
	}
	
	/**
	 * app修改密码、安全码
	 * @param userId
	 * @param password
	 * @param confirmPassword
	 * @param pwdType
	 * @return
	 */
	public SimpleResult modifyUserPwd(String userId, String oldPassword,
	                                  String password, String confirmPassword,
	                                  String smsCode,String pwdType) {
		UserResetPwdApi userResetPwdApi = getDubboClient (UserResetPwdApi.class);
		
		UserModifyPwdOrder order = new UserModifyPwdOrder ();
		order.setUserId (userId);
		order.setOldPassword (oldPassword);
		order.setPassword (password);
		order.setConfirmPassword (confirmPassword);
		order.setSmsCode (smsCode);
		order.setPwdType (UserPwdTypeEnum.getByCode (pwdType));
		
		return userResetPwdApi.modifyUserPwd (order);
	}

	/**
	 * app找回安全码
	 * @param userId
	 * @param password
	 * @param confirmPassword
	 * @return
	 */
	public SimpleResult getBackUserPwd(String userId, String realName,String idCard,
									  String password, String confirmPassword,
									  String smsCode) {
		UserResetPwdApi userResetPwdApi = getDubboClient (UserResetPwdApi.class);

		GetBackUserPwdOrder order = new GetBackUserPwdOrder ();
		order.setUserId (userId);
		order.setRealName (realName);
		order.setIdCard (idCard);
		order.setPassword (password);
		order.setConfirmPassword (confirmPassword);
		order.setSmsCode (smsCode);

		return userResetPwdApi.getBackUserPwd(order);
	}
	
}
