/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2016-01-03 15:31 创建
 *
 */

package com.jvv.openapi.dal.handler;

//
///**
// * @author turalyon@jinvovo.com
// * @version V1.0
// * @Description:
// * @date 2016/1/3 15:31
// */
//
//@MappedJdbcTypes({ JdbcType.INTEGER, JdbcType.DECIMAL })
//@MappedTypes(Money.class)
//public class MoneyTypeHandler extends BaseTypeHandler<Money> {
//	@Override
//	public void setNonNullParameter(PreparedStatement ps, int i, Money parameter, JdbcType jdbcType)
//																									throws SQLException {
//		if (parameter == null) {
//			ps.setLong(i, 0);
//		} else {
//			ps.setLong(i, parameter.getCent());
//		}
//
//	}
//
//	@Override
//	public Money getNullableResult(ResultSet rs, String columnName) throws SQLException {
//		int cent = rs.getInt(columnName);
//		Money money = new Money();
//		money.setCent(cent);
//		return money;
//	}
//
//	@Override
//	public Money getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
//		int cent = rs.getInt(columnIndex);
//		Money money = new Money();
//		money.setCent(cent);
//		return money;
//	}
//
//	@Override
//	public Money getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
//		int cent = cs.getInt(columnIndex);
//		Money money = new Money();
//		money.setCent(cent);
//		return money;
//	}
//}