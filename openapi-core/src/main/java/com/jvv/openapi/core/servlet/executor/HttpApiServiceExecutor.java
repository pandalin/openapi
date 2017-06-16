/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-22 20:03 创建
 *
 */
package com.jvv.openapi.core.servlet.executor;

import com.google.common.base.Strings;
import com.jvv.openapi.common.exception.ResultCode;
import com.jvv.openapi.core.exception.handler.ApiServiceExceptionHandler;
import com.jvv.openapi.core.service.ApiConstants;
import com.jvv.openapi.core.service.ApiServiceException;
import com.jvv.openapi.core.service.ParamFormatException;
import com.jvv.openapi.core.service.auth.ApiAuthentication;
import com.jvv.openapi.core.service.auth.ApiAuthorization;
import com.jvv.openapi.core.service.auth.repository.MerchantRepository;
import com.jvv.openapi.core.service.base.*;
import com.jvv.openapi.core.service.entity.*;
import com.jvv.openapi.core.service.enums.ProtocolsEnum;
import com.jvv.openapi.core.service.enums.SchemeEnum;
import com.jvv.openapi.core.service.enums.SignTypeEnum;
import com.jvv.openapi.core.service.factory.ApiServiceFactory;
import com.jvv.openapi.core.service.listener.event.AfterServiceExecuteEvent;
import com.jvv.openapi.core.service.listener.event.BeforeServiceExecuteEvent;
import com.jvv.openapi.core.service.listener.event.RequestReceivedEvent;
import com.jvv.openapi.core.service.listener.event.ServiceExceptionEvent;
import com.jvv.openapi.core.service.listener.multicaster.EventPublisher;
import com.jvv.openapi.core.service.marshall.ApiRequestUnMarshall;
import com.jvv.openapi.core.service.marshall.ApiResponseMarshall;
import com.jvv.openapi.core.servlet.FrameworkServletException;
import com.jvv.openapi.core.support.LoggerHandler;
import com.jvv.openapi.core.util.ServletUtils;
import com.jvv.openapi.dal.entity.OrderInfoDO;
import com.jvv.openapi.dal.mapper.ExtraMapper;
import com.jvv.openapi.dal.mapper.OrderInfoMapper;
import com.jvv.openapi.facade.constants.enums.Status;
import com.jvv.openapi.facade.constants.validation.ValidateUtils;
import org.apache.commons.lang3.StringUtils;
import org.perf4j.StopWatch;
import org.perf4j.slf4j.Slf4JStopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Nullable;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/22 20:03
 */
@Service("httpApiServiceExecutor")
public class HttpApiServiceExecutor implements
									ApiServiceExecutor<HttpServletRequest, HttpServletResponse> {
	
	protected static final Logger logger = LoggerFactory.getLogger(HttpApiServiceExecutor.class);

	private static final AbstractResponseData default_empty_data = new EmptyResponseData();
	/**
	 * 性能日志
	 */
	private static final Logger perlogger = LoggerFactory
			.getLogger(ApiConstants.PERFORMANCE_LOGGER);
	
	@Resource
	protected LoggerHandler systemLoggerHandler;
	@Resource
	protected MerchantRepository merchantRepository;
	/**
	 * 认证
	 */
	@Resource
	protected ApiAuthentication apiAuthentication;
	/**
	 * 授权检查
	 */
	@Resource
	protected ApiAuthorization apiAuthorization;
	/**
	 * 服务处理工厂
	 */
	@Resource
	protected ApiServiceFactory apiServiceFactory;

	@Autowired
	private OrderInfoMapper orderInfoMapper;
	@Autowired
	private ExtraMapper extraMapper;

	/**
	 * marshal/unmarshal 暂时直接使用http实现，后期可根据请求protocol使用工厂动态获取对应的实现
	 */
	@Resource(name = "httpPostApiRequestUnMarshall")
	protected ApiRequestUnMarshall<HttpServletRequest> requestUnMarshall;
	@Resource(name = "httpPostApiResponseMarshall")
	protected ApiResponseMarshall<String> responseMarshall;
	@Resource(name = "httpApiRedirectMarshall")
	protected ApiResponseMarshall<String> redirectMarshall;
	@Resource
	private EventPublisher eventPublisher;
	@Resource
	private ApiServiceExceptionHandler apiServiceExceptionHandler;
	
	@SuppressWarnings("rawtypes")
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		ApiResponse apiResponse = null;
		ApiRequest apiRequest = null;
		Map<String, String> requestData = null;
		ApiService apiService = null;
		ApiContext apiContext = null;
		StopWatch stopWatch = null;
		try {
			// 创建本线程context
			apiContext = createApiContext();
			// 获取原始请求数据
			requestData = ServletUtils.getParamMap(request);
			//			MDCUtils.setLogKey (requestData.get (ApiConstants.ORDER_NO));
			// 记录原始入参
			logRequestData(requestData);
			publishRequestReceivedEvent(requestData);
			
			// 先做基础参数校验
			doBasicValidate(requestData);
			// 路由服务
			apiService = getApiService(request);
			
			// 初始化apiContext
			initApiContext(apiContext, request, requestData, apiService);
			stopWatch = initPerfLog(apiContext);
			
			apiRequest = apiService.getRequestBean();
			apiResponse = apiService.getResponseBean();
			
			prepareResponse(apiResponse, requestData);
			apiRequest = doUnmarshal(request, apiRequest);
			apiContext.setRequest(apiRequest);
			apiContext.setResponse(apiResponse);

			//加载商户配置
			loadMerchant(apiContext);

			// 验证
			doVerify(apiContext, request);
			publishBeforeServiceExecuteEvent(apiResponse, apiRequest, apiService);
			// 执行服务
			doExceute(apiContext);
		} catch (Throwable ex) {
			if (!apiContext.isRepeated()) {
				handleException(apiContext, ex);
				apiContext.getResponse().setStatus(Status.FAIL.getCode());
			}
		} finally {
			try {
				doResponse(apiContext, response);
			} catch (Exception e) {
				logger.warn("响应处理失败:", e);
			} finally {
				destoryApiContext();
				if (stopWatch != null) {
					stopWatch.stop();
				}
			}
		}
		
	}

	private void loadMerchant(ApiContext apiContext) {
		MerchantInfo merchantInfo = merchantRepository.loadFromCache(apiContext.getRequest().getPartnerId());
		if (merchantInfo == null) {
			throw new ApiServiceException(ApiServiceResultCode.PARTNER_NOT_REGISTER,
					String.format("商户[%s]不存在", apiContext.getRequest().getPartnerId()));
		}
		apiContext.setMerchantInfo(merchantInfo);
	}
	
	/**
	 * @param apiContext
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void doExceute(ApiContext apiContext) {
		ApiService apiService = apiContext.getApiService();
		ApiRequest apiRequest = apiContext.getRequest();
		ApiResponse apiResponse = apiContext.getResponse();

		//保存流水
		OrderInfo orderInfo = saveRequest(apiContext);

		try {
			apiService.service(apiRequest, apiResponse);

			//修改流水
		} catch (Throwable ex) {
			publishServiceExceptionEvent(apiResponse, apiRequest, apiService, ex);
			throw ex;
		} finally {
			//更新流水
			publishAfterServiceExecuteEvent(apiResponse, apiRequest, apiService);
		}

		if (orderInfo != null) {
			//更新流水
			orderInfo.setStatus(Status.getByCode(apiResponse.getStatus()));
			orderInfo.setResultMessage(apiResponse.getDetailMessage());
			orderInfo.setResultCode(apiResponse.getCode());

			/*try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
			orderInfoMapper.updateBySerialNo(orderInfo);
		}

	}

	private OrderInfo saveRequest(ApiContext apiContext) {
		ApiRequest apiRequest = apiContext.getRequest();
		OrderInfo orderInfo = OrderInfo.convertFrom(apiRequest);
		orderInfo.setTradeDate(extraMapper.getSysdate());
		orderInfo.setSerialNo(extraMapper.newId("SerialNo", "001"));
		orderInfo.setGid(apiContext.getGid());
		orderInfo.setStatus(Status.PROCESSING);
		orderInfo.setResultCode(ResultCode.EXECUTE_PROCESSING.getCode());
		orderInfo.setResultMessage(ResultCode.EXECUTE_PROCESSING.getMessage());

		try {
			orderInfoMapper.insert(orderInfo);
		} catch (DuplicateKeyException e) {
			OrderInfoDO orderInfoDO = orderInfoMapper.findByMerchantOrderNo(apiRequest.getOrderNo());
			ApiResponse response = apiContext.getResponse();
			response.setStatus(orderInfoDO.getStatus().getCode());
			response.setCode(orderInfoDO.getResultCode());
			response.setMessage("重复的订单请求");
			response.setDetailMessage(orderInfoDO.getResultMessage());
			apiContext.setRepeated();
			throw new ApiServiceException(ApiServiceResultCode.ORDER_NO_NOT_UNIQUE, "重复的订单请求");
		} catch (Exception e) {
			logger.error("数据库异常：", e);
			throw new ApiServiceException(ApiServiceResultCode.DATABASE_EXCEPTION, "数据库异常");
		}

		return orderInfo;
	}
	
	protected void prepareResponse(ApiResponse apiResponse, Map<String, String> requestData) {
		if (apiResponse == null || requestData == null) {
			return;
		}
		//		apiResponse.setOrderNo(requestData.get(ApiConstants.ORDER_NO));
		
		apiResponse.setOrderNo(requestData.get(ApiConstants.ORDER_NO));
		apiResponse.setService(requestData.get(ApiConstants.SERVICE));
		
		//返回的datas字段不能为空
		if (apiResponse.getDatas() == null) {
			apiResponse.setDatas(default_empty_data);
		}
		
		if (apiResponse instanceof ISign) {
			ISign signObject = (ISign) apiResponse;
			
			signObject
					.setSignType(StringUtils.isNotBlank(requestData.get(ApiConstants.SIGN_TYPE)) ? requestData
							.get(ApiConstants.SIGN_TYPE) : SignTypeEnum.MD5.name());
			
		}
		
		apiResponse
				.setProtocol(StringUtils.isNotBlank(requestData.get(ApiConstants.PROTOCOL)) ? requestData
						.get(ApiConstants.PROTOCOL) : ProtocolsEnum.HTTP_JSON.getCode());
		
		apiResponse
				.setVersion(StringUtils.isNotBlank(requestData.get(ApiConstants.VERSION)) ? requestData
						.get(ApiConstants.VERSION) : ApiConstants.VERSION_DEFAULT);
		
	}
	
	protected void doResponse(ApiContext apiContext, HttpServletResponse response) {
		ApiService service = apiContext.getApiService();
		ApiResponse apiResponse = apiContext.getResponse();
		boolean redirect = apiContext.isRedirect();
		String redirectUrl = getRedirectUrl(service, apiResponse, apiContext);
		String marshallStr = null;
		if (redirect && StringUtils.isNotBlank(redirectUrl)) {
			marshallStr = doMarshal(apiResponse, true);
			String location = buildRedirctLocation(redirectUrl, marshallStr);
			ServletUtils.redirect(response, location);
		} else {
			marshallStr = doMarshal(apiResponse, false);
			ServletUtils.writeResponse(response, marshallStr);
		}
	}
	
	/**
	 * 解报
	 *
	 * @param request
	 * @return
	 */
	protected ApiRequest doUnmarshal(HttpServletRequest request, ApiRequest apiRequest) {
		return requestUnMarshall.unmarshall(request, apiRequest);
	}
	
	/**
	 * 组报
	 *
	 * @return
	 */
	protected String doMarshal(ApiResponse apiResponse, boolean isRedirect) {
		if (isRedirect) {
			return redirectMarshall.marshall(apiResponse);
		} else {
			return responseMarshall.marshall(apiResponse);
		}
	}
	
	/**
	 * 创建当前线程ApiContext
	 *
	 * @return 本线程绑定的ApiContext
	 */
	protected ApiContext createApiContext() {
		InternalApiContextHolder.init();
		// 初始化apiContext
		ApiContext apiContext = InternalApiContextHolder.getApiContext();
		// 初始化gid
		apiContext.initGid();
		// 设置MDC
		//		MDCUtils.setLogKey (apiContext.getGid ());
		return apiContext;
	}
	
	/**
	 * 初始化ApiContext
	 *
	 * @param request     原始ServletRequest请求
	 * @param apiContext  当前ApiContext会话
	 * @param requestData 原始请求数据
	 * @param apiService  目标Api服务
	 */
	protected void initApiContext(ApiContext apiContext, HttpServletRequest request,
								  Map<String, String> requestData, ApiService apiService) {
		apiContext.init(requestData, apiService);
		getRequestUserAgent(apiContext, request);
	}
	
	/**
	 * 销毁释放线程绑定ApiContext
	 */
	protected void destoryApiContext() {
		InternalApiContextHolder.clear();
	}
	
	/**
	 * 入口基础参数检查
	 *
	 * @param requestData
	 */
	protected void doBasicValidate(Map<String, String> requestData) {
		StringBuilder sb = new StringBuilder();
		if (StringUtils.isBlank(requestData.get(ApiConstants.ORDER_NO))) {
			sb.append("请求订单号/流水号(orderNo);");
		}
		if (StringUtils.isBlank(requestData.get(ApiConstants.SERVICE))) {
			sb.append("服务名(service);");
		}
		if (StringUtils.isBlank(requestData.get(ApiConstants.SYSTEM))) {
			sb.append("系统类型(system);");
		}
		if (StringUtils.isBlank(requestData.get(ApiConstants.PARTNER_ID))) {
			//设置默认的PartnerId,以后做为平台时，partnerId必传，作为区分商户的 标识
			requestData.put(ApiConstants.PARTNER_ID, ApiConstants.JVV_PARTNER_ID);
			if (StringUtils.isBlank(requestData.get(ApiConstants.DEVICE_ID))) {
				sb.append("设备ID(deviceId);");
			}
			//			sb.append("商户号(partnerId);");
		}
		if (StringUtils.isBlank(requestData.get(ApiConstants.SIGN))) {
			sb.append("签名(sign);");
		}
		if (StringUtils.isBlank(sb.toString())) {
			return;
		}
		throw new ParamFormatException(ApiServiceResultCode.ILLEGAL_REQUEST, sb.toString()
																			 + " 是必填项");
		
	}
	
	/**
	 * 服务验证
	 *
	 * @param request
	 * @param apiContext
	 */
	protected void doVerify(ApiContext apiContext, HttpServletRequest request) {
		//验证商户状态
		checkMerchant(apiContext.getRequest());

		//验证scheme
		doVerifyScheme(apiContext, request);
		// 验证服务基本参数
		doValidateServiceParam(apiContext);
		// 校验参数
		doValidateParameter(apiContext.getRequest());
		// 校验幂等性
		doVerifyIdempotence(apiContext.getRequest());
		// 认证
		doAuthenticate(apiContext.getRequest());
		// 授权
		doAuthorize(apiContext.getRequest());
	}

	private void checkMerchant(ApiRequest request) {
		apiAuthentication.checkMerchant(request);
	}
	
	/**
	 * 请求scheme验证
	 *
	 * @param apiContext
	 * @param request
	 */
	protected void doVerifyScheme(ApiContext apiContext, HttpServletRequest request) {
		String requestScheme = request.getScheme();
		if (apiContext.getOpenApiService().scheme() == null
			|| apiContext.getOpenApiService().scheme() == SchemeEnum.ALL) {
			return;
		}
		if (!apiContext.getOpenApiService().scheme().getCode().equalsIgnoreCase(requestScheme)) {
			throw new ApiServiceException(ApiServiceResultCode.UNSUPPORTED_SECHEME,
					"支持的scheme为:" + apiContext.getOpenApiService().scheme());
		}
	}
	
	/**
	 * 幂等性校验
	 *
	 * @param apiRequest
	 */
	protected void doVerifyIdempotence(ApiRequest apiRequest) {
		logger.info("//TODO 幂等性验证");
	}
	
	/**
	 * 服务参数校验
	 *
	 * @param apiContext
	 */
	protected void doValidateServiceParam(ApiContext apiContext) {
		apiContext.getOpenApiService().responseType().validate(apiContext.getRequestData());
	}
	
	/**
	 * 公共Api参数合法性检查
	 */
	protected void doValidateParameter(ApiRequest apiRequest) {
		try {
			ValidateUtils.check(apiRequest);
			apiRequest.check();
		} catch (IllegalArgumentException iae) {
			throw new ApiServiceException(ApiServiceResultCode.PARAMETER_ERROR, iae.getMessage());
		} catch (ApiServiceException ae) {
			throw ae;
		} catch (Exception e) {
			throw new ApiServiceException(ApiServiceResultCode.INTERNAL_ERROR, "公共参数合法性检查未通过:"
																			   + e.getMessage());
		}
	}
	
	/**
	 * 认证
	 *
	 * @param apiRequest
	 */
	protected void doAuthenticate(ApiRequest apiRequest) {
		apiAuthentication.authenticate(apiRequest);
	}
	
	protected void doSign(Map<String, String> apiResponse) {
		String signType = apiResponse.get(ApiConstants.SIGN_TYPE);
		String resultCode = apiResponse.get(ApiConstants.RESULT_CODE);
		if (Strings.isNullOrEmpty(signType)) {
			return;
		}
		// 服务认证失败
		if (resultCode != null
			&& resultCode.equals(ApiServiceResultCode.UN_AUTHENTICATED_ERROR.getCode())) {
			return;
		}
		// 授权失败
		if (resultCode != null
			&& resultCode.equals(ApiServiceResultCode.UN_AUTHORIZED_ERROR.getCode())) {
			return;
		}
		apiAuthentication.signature(apiResponse);
	}
	
	protected void doAuthorize(ApiRequest apiRequest) {
		apiAuthorization.authorize(apiRequest);
	}
	
	/**
	 * 错误处理
	 *
	 * @param apiContext
	 * @param e
	 */
	protected void handleException(@Nullable ApiContext apiContext, Throwable e) {
		if (apiContext.getResponse() == null) {
			apiContext.setResponse(createResponse(apiContext.getRequestData()));
		}
		apiServiceExceptionHandler.handle(apiContext.getRequest(), apiContext.getResponse(), e);
	}
	
	protected ApiService getApiService(HttpServletRequest request) {
		String service = request.getParameter("service");
		Assert.hasText(service);
		String version = request.getParameter("version");
		if (StringUtils.isBlank(version)) {
			version = "1.0";
		}
		return apiServiceFactory.getApiService(service, version);
	}
	
	private void publishBeforeServiceExecuteEvent(ApiResponse apiResponse, ApiRequest apiRequest,
												  ApiService apiService) {
		if (eventPublisher.canPublishEvent(apiService)) {
			eventPublisher.publishEvent(new BeforeServiceExecuteEvent(apiRequest, apiResponse),
					apiService);
		}
		
	}
	
	private void publishServiceExceptionEvent(ApiResponse apiResponse, ApiRequest apiRequest,
											  ApiService apiService, Throwable throwable) {
		if (eventPublisher.canPublishEvent(apiService)) {
			eventPublisher.publishEvent(new ServiceExceptionEvent(apiRequest, apiResponse,
					throwable), apiService);
		}
		
	}
	
	private void publishAfterServiceExecuteEvent(ApiResponse apiResponse, ApiRequest apiRequest,
												 ApiService apiService) {
		if (eventPublisher.canPublishEvent(apiService)) {
			eventPublisher.publishEvent(new AfterServiceExecuteEvent(apiRequest, apiResponse),
					apiService);
		}
		
	}
	
	private void publishRequestReceivedEvent(Map<String, String> requestData) {
		if (eventPublisher.canPublishGlobalEvent()) {
			eventPublisher.publishEvent(new RequestReceivedEvent(requestData));
		}
	}
	
	private StopWatch initPerfLog(ApiContext apiContext) {
		return new Slf4JStopWatch(apiContext.getServiceName(), perlogger);
	}
	
	//add by mayansen
	private void getRequestUserAgent(ApiContext apiContext, HttpServletRequest request) {
		String userAgent = request.getHeader("User-Agent");
		apiContext.setUserAgent(userAgent);
	}
	
	private void logRequestData(Map<String, String> requestData) {
		//changed by zhangpu for 'request log security filtering(mask or ignore)' on 2015-10-16
		String serviceName = requestData.get(ApiConstants.SERVICE);
		String labelPostfix = (StringUtils.isNotBlank(serviceName) ? "[" + serviceName + "]:" : ":");
		systemLoggerHandler.log("服务请求" + labelPostfix, requestData);
	}
	
	private ApiResponse createResponse(Map<String, String> requestData) {
		ApiResponse response = new ApiResponse();
		prepareResponse(response, requestData);
		return response;
	}
	
	private String getRedirectUrl(ApiService service, ApiResponse apiResponse, ApiContext apiContext) {
		String redirectUrl = apiContext.getRedirectUrl();
		// 如果没有设置，则使用程序员设置的服务默认跳转URL
		if (StringUtils.isBlank(redirectUrl)) {
			if (service instanceof AbstractApiService) {
				redirectUrl = ((AbstractApiService) service).getDefaultRedirectUrl();
			}
		}
		// 如果没有设置,而且跳转业务OpenApi层是错误的，则使用returnUrl做为returnUrl,调回商户。
		if (!Status.isSuccess(apiResponse.getStatus()) && StringUtils.isBlank(redirectUrl)
			&& apiContext.getRequestData() != null) {
			redirectUrl = apiContext.getRequestData().get(ApiConstants.RETURN_URL);
		}
		return redirectUrl;
	}
	
	private String buildRedirctLocation(String redirectUrl, String marshallStr) {
		if (redirectUrl == null) {
			throw new FrameworkServletException(ApiServiceResultCode.REDIRECT_URL_NOT_EXIST);
			// ?是否考虑使用openApi提供一个URL显示这种特别的错误情况？或则这种问题应该在调试阶段解决？ by zhangpu on
			// 20140821
		}
		if (redirectUrl.contains("?")) {
			return redirectUrl + "&" + marshallStr;
		} else {
			return redirectUrl + "?" + marshallStr;
		}
	}
}
