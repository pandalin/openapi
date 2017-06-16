/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.core.util;

import com.google.common.base.Preconditions;
import com.jvv.openapi.common.constant.RedisKeyEnum;
import com.jvv.openapi.common.exception.ResultCode;
import com.jvv.openapi.common.util.RedisUtils;
import com.jvv.openapi.core.exception.FrameworkException;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author linxm
 * @date 2017/3/17
 * @time 15:13
 */
@Component("tokenUtils")
public class TokenUtils {
	
	@Resource
	private RedisUtils redisUtils;

	public static final String KEY_USER_LOGIN_TOKEN = "ohmyjvv_logintoken2";
	
	/**
	 * token生成
	 * @param userId
	 * @return
	 */
	public String generateUserToken (String userId) {
		Preconditions.checkArgument (StringUtils.isNotEmpty (userId), "userId不能为空");
		
		String token = generateToken (userId);
		clean (userId);
		
		redisUtils.put (KEY_USER_LOGIN_TOKEN,token,userId);
		redisUtils.put (KEY_USER_LOGIN_TOKEN,userId,token);
		redisUtils.expire (KEY_USER_LOGIN_TOKEN, 7, TimeUnit.DAYS);
		return token;
	}
	
	public void clean (String userId) {
		checkArgument (StringUtils.isNotEmpty (userId), "userId不能为空");
		String oldToken = getTokenByUserId(userId);
		if (StringUtils.isNotEmpty(oldToken)) {
			redisUtils.delete(KEY_USER_LOGIN_TOKEN, oldToken);
		}
		redisUtils.delete (KEY_USER_LOGIN_TOKEN, userId);
	}
	
	/**
	 * 根据userId获取token
	 * @param userId
	 * @return
	 */
	public String getTokenByUserId(String userId) {
		checkArgument(StringUtils.isNotEmpty(userId), "userId不能为空");
		String token= (String) redisUtils.get(KEY_USER_LOGIN_TOKEN, userId);
		return token;
		
	}
	
	/**
	 * 根据userId获取token
	 * @param token
	 * @return
	 */
	public String getUserIdByToken(String token) {
		if (StringUtils.isEmpty(token)) {
			return null;
		}
		String userId = (String) redisUtils.get(KEY_USER_LOGIN_TOKEN, token);
		if (StringUtils.isEmpty (userId)) {
			throw new FrameworkException(ResultCode.NOT_LOGIN);
		}
		return userId;
	}
	
	private String generateToken (String userId) {
		return DigestUtils.md5Hex (userId + System.currentTimeMillis ());
	}
}
