/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.api;

import com.jvv.facade.group.info.QueryGroupInfo;
import com.jvv.facade.group.info.QueryGroupList;
import com.jvv.facade.group.order.QueryGroupOrder;
import com.jvv.facade.group.result.QueryGroupResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.facade.constants.enums.Status;
import com.jvv.openapi.intergration.social.group.GroupInfoClient;
import com.jvv.openapi.service.social.request.QueryGroupRequest;
import com.jvv.openapi.service.social.response.QueryGroupResponseData;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/4/6
 * @time 17:31
 */
@OpenApiService (name = "queryGroup",desc = "按条件查找群",responseType = ResponseTypeEnum.SYN)
public class QueryGroupApiService extends AbstractApiService<QueryGroupRequest,ApiResponse>{
	
	@Autowired
	private GroupInfoClient groupInfoClient;
	
	@Override
	protected void doService (QueryGroupRequest request, ApiResponse response) {
		if(request.getStart ()==null && "".equals (request.getStart ())){
			response.setStatus (Status.FAIL.getCode ());
			response.setCode ("999");
			response.setDetailMessage ("当前页码不能为空！");
			response.setMessage ("执行失败");
		}else if(request.getPageSize ()==null && "".equals (request.getPageSize ())){
			response.setStatus (Status.FAIL.getCode ());
			response.setCode ("999");
			response.setDetailMessage ("每页最大数据条数不能为空！");
			response.setMessage ("执行失败");
		}else {
			QueryGroupOrder order = new QueryGroupOrder ();
			BeanUtils.copyProperties (request, order);
			
			QueryGroupResult result = groupInfoClient.queryGroup (order);
			response.setStatus (result.getStatus ().getCode ());
			response.setMessage (result.getMessage ());
			response.setCode (result.getCode ());
			response.setDetailMessage (result.getDescription ());
			
			QueryGroupList info = result.getInfo ();
			if (info != null) {
				List<QueryGroupInfo> queryGroupInfoList = info.getQueryGroupInfoList ();
				//实例化ResponseData对象
				QueryGroupResponseData datas = new QueryGroupResponseData ();
				datas.setQueryGroupInfoList (queryGroupInfoList);
				response.setDatas (datas);
			}
		}
	}
}
