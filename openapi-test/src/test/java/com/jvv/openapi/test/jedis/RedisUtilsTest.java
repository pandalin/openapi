/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.test.jedis;

import com.alibaba.fastjson.JSON;
import com.jvv.openapi.common.constant.RedisKeyEnum;
import com.jvv.openapi.common.util.RedisUtils;
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.domain.base.result.social.UserEncounterInfo;
import org.joda.time.DateTimeUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author linxm
 * @date 2017/3/17
 * @time 15:06
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-redis-test.xml"})
public class RedisUtilsTest {
	
	@Resource
	private RedisUtils redisUtils;
	@Resource
	private TokenUtils tokenUtils;
	@Resource
	private RedisTemplate redisTemplate;
	
	public static final String KEY_USER_LOGIN_TOKEN = "ohmyjvv_logintoken2";
	
	@Test
	public void put () {
		String token = tokenUtils.generateUserToken ("20170329001000000067");
		redisUtils.put (KEY_USER_LOGIN_TOKEN, "20170329001000000067", token);
		System.out.println (token);
	}
	
	@Test
	public void get () {
		System.out.println (tokenUtils.getUserIdByToken ("fae15bd6f8b4bb56044ff507e32585aa"));
//		System.out.println (redisUtils.get (TokenUtils.KEY_USER_LOGIN_TOKEN, "79e57af95c27859d2952e0469880597e"));
	}

	@Test
	public void zadd() {
		UserEncounterInfo userEncounterInfo = new UserEncounterInfo();
		userEncounterInfo.setUserId("9");
		userEncounterInfo.setConstellation("犀牛座");
		userEncounterInfo.setIdentity("打杂");
		userEncounterInfo.setUserType(1);
		userEncounterInfo.setUserId("user2017001");
		userEncounterInfo.setBirthDay(new Date());
		userEncounterInfo.setUserName("王五");
		System.out.println(redisUtils.zAdd(RedisKeyEnum.KEY_USER_ENCOUNTER_LIST.name(), JSON.toJSONString(userEncounterInfo), DateTimeUtils.currentTimeMillis()));
		Set<ZSetOperations.TypedTuple<String>> set = redisUtils.getRangeWithScores("zaddList",0,4);
		for (ZSetOperations.TypedTuple<String> s : set) {
			System.out.println(s.getValue());
		}
		Pattern p = Pattern.compile("userId");
		System.out.println(p.pattern());
		Cursor<ZSetOperations.TypedTuple<String>> tupleCursor = redisUtils.scan("zaddList",p.pattern());
		while (tupleCursor.hasNext()) {
			ZSetOperations.TypedTuple<String> v = tupleCursor.next();
			System.out.println("========>" + v.getValue());
		}
	}

	@Test
	public void serialize() {


		redisUtils.put("ceshi_redis","user_88890","9999");
	}

	@Test
	public void smember() {
		for (int i=0;i<100;i++) {
			redisUtils.sAdd("sadd","add_" + i);
		}

		Set<String> set = redisUtils.distinctRandomMembers("sadd",6);
		for (String s : set) {
			System.out.println(s);
		}

	}
}
