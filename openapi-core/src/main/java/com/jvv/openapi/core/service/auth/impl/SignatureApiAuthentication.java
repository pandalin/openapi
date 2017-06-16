/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-22 22:32 创建
 *
 */
package com.jvv.openapi.core.service.auth.impl;

import com.jvv.openapi.core.exception.FrameworkException;
import com.jvv.openapi.core.service.ApiConstants;
import com.jvv.openapi.core.service.ApiServiceException;
import com.jvv.openapi.core.service.auth.ApiAuthentication;
import com.jvv.openapi.core.service.auth.ApiServiceAuthException;
import com.jvv.openapi.core.service.auth.realm.AuthInfoRealm;
import com.jvv.openapi.core.service.auth.repository.MerchantRepository;
import com.jvv.openapi.core.service.auth.sign.Signer;
import com.jvv.openapi.core.service.auth.sign.SignerFactory;
import com.jvv.openapi.core.service.base.ApiContextHolder;
import com.jvv.openapi.core.service.base.ApiServiceResultCode;
import com.jvv.openapi.core.service.base.MerchantInfo;
import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.dal.mapper.ExtraMapper;
import com.jvv.openapi.facade.constants.enums.MerchantStatusEnum;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

/**
 * API Service 授权接口
 *
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/22 22:32
 */

@Service
public class SignatureApiAuthentication implements ApiAuthentication {
	public static final String DEFAULT_DATE_FORMAT_STRING = "yyyy-MM-dd HH:mm:ss";
	private static final Logger logger = LoggerFactory.getLogger(SignatureApiAuthentication.class);
	
	@Resource
	protected SignerFactory<Map<String, String>> signerFactory;
	@Resource
	protected AuthInfoRealm authInfoRealm;
	@Autowired
	private MerchantRepository merchantRepository;
	@Resource
	private ExtraMapper extraMapper;

	@Override
	public void checkMerchant(ApiRequest request) {
		String partnerId = request.getPartnerId();
		Assert.hasText(partnerId, String.format("partnerId[商户ID] must not be null"));
		MerchantInfo merchantInfo = merchantRepository.loadFromCache(partnerId);
		if (merchantInfo == null) {
			throw new ApiServiceException(ApiServiceResultCode.PARTNER_NOT_REGISTER,
					String.format("商户[%s]不存在", partnerId));
		}

		if (merchantInfo.getStatus() != MerchantStatusEnum.NORMAL) {
			throw new ApiServiceException(ApiServiceResultCode.PARTNER_NOT_REGISTER,
					String.format("商户[%s]状态异常,当前状态：%s", partnerId, merchantInfo.getStatus()));
		}

		Date now = extraMapper.getSysdate();
		if (merchantInfo.getActiveTime() != null && merchantInfo.getActiveTime().getTime() > now.getTime()) {
			throw new ApiServiceException(ApiServiceResultCode.PARTNER_NOT_REGISTER,
					String.format("商户[%s]未生效，生效时间:%s", partnerId,
							DateFormatUtils.format(merchantInfo.getActiveTime(), DEFAULT_DATE_FORMAT_STRING)));
		}
		if (merchantInfo.getEffectiveTime() != null && merchantInfo.getEffectiveTime().getTime() < now.getTime()) {
			throw new ApiServiceException(ApiServiceResultCode.PARTNER_NOT_REGISTER,
					String.format("商户[%s]已过期，过期时间:%s", partnerId,
							DateFormatUtils.format(merchantInfo.getActiveTime(), DEFAULT_DATE_FORMAT_STRING)));
		}
	}

	/**
	 * 认证
	 *
	 * @param request
	 */
	@Override
	public void authenticate(ApiRequest request) {
		try {
			String requestSign = request.getSign();
			Signer<Map<String, String>> signer = signerFactory.getSigner(request.getSignType());
			signer.verify(requestSign,
					(String) authInfoRealm.getAuthenticationInfo(request.getPartnerId()),
					ApiContextHolder.getApiContext().getRequestData());
		} catch (FrameworkException asae) {
			throw asae;
		} catch (Exception e) {
			logger.warn("签名认证异常", e);
			throw new ApiServiceAuthException(e);
		}
	}

	/**
	 * 签名
	 *
	 * @param response
	 */
	@Override
	public void signature(Map<String, String> response) {
		String signType = response.get(ApiConstants.SIGN_TYPE);
		String partnerId = response.get(ApiConstants.PARTNER_ID);
		signature(response, partnerId, signType);
	}

	@Override
	public void signature(Map<String, String> responseData, String partnerId, String signType) {
		try {
			String sign = signerFactory.getSigner(signType).sign(responseData,
					authInfoRealm.getAuthenticationInfo(partnerId));
			responseData.put(ApiConstants.SIGN, sign);
		} catch (ApiServiceException asae) {
			throw asae;
		} catch (Exception e) {
			logger.warn("签名异常", e);
			throw new ApiServiceException(ApiServiceResultCode.INTERNAL_ERROR, "签名失败"
																			   + e.getMessage());
		}
	}
}
