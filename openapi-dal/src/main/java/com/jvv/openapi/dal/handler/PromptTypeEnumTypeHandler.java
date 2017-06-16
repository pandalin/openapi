/*
 * www.moonlighting.cn Inc.
 * Copyright (c) 2017 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@moonlighting.cn 2017-01-16 22:46 创建
 *
 */
package com.jvv.openapi.dal.handler;

import com.jvv.openapi.facade.constants.enums.PromptTypeEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author turalyon@moonlighting.cn
 */
@MappedTypes({ PromptTypeEnum.class })
@MappedJdbcTypes({ JdbcType.VARCHAR  })
public class PromptTypeEnumTypeHandler extends BaseTypeHandler<PromptTypeEnum> {

	public void setNonNullParameter(PreparedStatement preparedStatement, int i, PromptTypeEnum anEnum,
									JdbcType jdbcType) throws SQLException {
		preparedStatement.setString(i, anEnum.getCode());
	}

	public PromptTypeEnum getNullableResult(ResultSet resultSet, String s) throws SQLException {
		String result = resultSet.getString(s);
		return PromptTypeEnum.getByCode(result);
	}

	public PromptTypeEnum getNullableResult(ResultSet resultSet, int i) throws SQLException {
		String result = resultSet.getString(i);
		return PromptTypeEnum.getByCode(result);
	}

	public PromptTypeEnum getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
		String result = callableStatement.getString(i);
		return PromptTypeEnum.getByCode(result);
	}
}
