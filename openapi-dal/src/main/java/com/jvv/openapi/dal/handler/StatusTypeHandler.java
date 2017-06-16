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

import com.jvv.openapi.facade.constants.enums.Status;
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
@MappedTypes({ Status.class })
@MappedJdbcTypes({ JdbcType.VARCHAR  })
public class StatusTypeHandler extends BaseTypeHandler<Status> {

	public void setNonNullParameter(PreparedStatement preparedStatement, int i, Status anEnum,
									JdbcType jdbcType) throws SQLException {
		preparedStatement.setString(i, anEnum.getCode());
	}

	public Status getNullableResult(ResultSet resultSet, String s) throws SQLException {
		String result = resultSet.getString(s);
		return Status.getByCode(result);
	}

	public Status getNullableResult(ResultSet resultSet, int i) throws SQLException {
		String result = resultSet.getString(i);
		return Status.getByCode(result);
	}

	public Status getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
		String result = callableStatement.getString(i);
		return Status.getByCode(result);
	}
}
