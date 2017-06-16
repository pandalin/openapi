/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.common.util;

import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author linxm
 * @date 2017/3/17
 * @time 14:57
 */
@Component("redisUtils")
public class RedisUtils<K,HK,V> {
	
	@Resource
	private RedisTemplate redisTemplate;
	
	private HashOperations<K,HK,V> hashOperations;

	private ZSetOperations<K,V> zSetOperations;
	private SetOperations<K,V> setOperations;

	@PostConstruct
	public void init() {
		hashOperations = redisTemplate.opsForHash ();
		zSetOperations = redisTemplate.opsForZSet();
		setOperations = redisTemplate.opsForSet();
	}
	
	public void put(K key, HK hashKey, V value) {
		hashOperations.put(key, hashKey, value);
	}
	
	public V get(K key,HK hashKey) {
		return hashOperations.get(key,hashKey);
	}
	
	public void delete(K key,HK hashKey) {
		hashOperations.delete(key,hashKey);
	}

	public Long sAdd(K key,V value) {return setOperations.add(key,value);}

	public Set<V> distinctRandomMembers(K key, long count) {return setOperations.distinctRandomMembers(key,count);}

	public boolean zAdd(K key,V value,long score) {
		return zSetOperations.add(key,value,score);
	}

	public Long remove(K key,V value) {
		return zSetOperations.remove(key,value);
	}

	public Long size(K key) {
		return zSetOperations.size(key);
	}

	public boolean expire(K key,long expireTime, TimeUnit timeUnit) {
		return redisTemplate.expire(key, expireTime, timeUnit);
	}

	public Set<ZSetOperations.TypedTuple<V>> getRangeWithScores(K key, long start, long end) {
		return zSetOperations.reverseRangeWithScores(key,start,end);
	}

	public Cursor<ZSetOperations.TypedTuple<V>> scan(K key, String pattern) {
		ScanOptions scanOptions = new ScanOptions.ScanOptionsBuilder().match(pattern).build();
		return zSetOperations.scan(key,scanOptions);
	}
}
