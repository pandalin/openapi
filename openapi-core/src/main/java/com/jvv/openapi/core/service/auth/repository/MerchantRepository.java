/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2017-03-13 16:31 创建
 *
 */
package com.jvv.openapi.core.service.auth.repository;

import com.google.common.cache.*;
import com.jvv.openapi.core.service.base.MerchantInfo;
import com.jvv.openapi.dal.entity.MerchantDO;
import com.jvv.openapi.dal.mapper.MerchantMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author turalyon@jinvovo.com
 */
@Component
public class MerchantRepository {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private MerchantMapper merchantMapper;

	//缓存接口这里是LoadingCache，LoadingCache在缓存项不存在时可以自动加载缓存
	LoadingCache<String, MerchantInfo> cache
			//CacheBuilder的构造函数是私有的，只能通过其静态方法newBuilder()来获得CacheBuilder的实例
			= CacheBuilder.newBuilder()
			//设置并发级别为8，并发级别是指可以同时写缓存的线程数
			.concurrencyLevel(8)
			//设置写缓存后30分钟过期
			.expireAfterWrite(30, TimeUnit.MINUTES)
			//设置缓存容器的初始容量为10
			.initialCapacity(10)
			//设置缓存最大容量为100，超过100之后就会按照LRU最近虽少使用算法来移除缓存项
			.maximumSize(100)
			//设置要统计缓存的命中率
			.recordStats()
			//设置缓存的移除通知
			.removalListener(new RemovalListener<Object, Object>() {
				@Override
				public void onRemoval(RemovalNotification<Object, Object> notification) {
					logger.info("{} was removed, cause is {}", notification.getKey(), notification.getCause());
				}
			})
			//build方法中可以指定CacheLoader，在缓存不存在时通过CacheLoader的实现自动加载缓存
			.build(
					new CacheLoader<String, MerchantInfo>() {
						@Override
						public MerchantInfo load(String partnerId) throws Exception {
							return getMerchant(partnerId);
						}
					}
			);

	/**
	 * 获取商户配置信息
	 *
	 * @param partnerId
	 * @return
	 */
	public MerchantInfo getMerchant(String partnerId) {
		MerchantDO dbDo = merchantMapper.findByPartnerId(partnerId);

		return MerchantInfo.convertFrom(dbDo);
	}

	public MerchantInfo loadFromCache(String partnerId) {
		try {
			return cache.get(partnerId);
		} catch (Exception e) {
			if(e instanceof CacheLoader.InvalidCacheLoadException){
				return null;
			}
			return getMerchant(partnerId);
		}
	}
}
