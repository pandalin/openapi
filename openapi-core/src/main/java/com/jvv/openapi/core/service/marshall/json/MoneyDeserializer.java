/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-24 20:24 创建
 *
 */
package com.jvv.openapi.core.service.marshall.json;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/24 20:24
 */
//
//public class MoneyDeserializer implements ObjectDeserializer {
//	public final static MoneyDeserializer instance = new MoneyDeserializer();
//
//	@SuppressWarnings("unchecked")
//	public <T> T deserialze(DefaultJSONParser parser, Type clazz, Object fieldName) {
//		return (T) deserialze(parser);
//	}
//
//	@SuppressWarnings("unchecked")
//	public static <T> T deserialze(DefaultJSONParser parser) {
//
//		try {
//			int token = parser.getLexer().token();
//			if (token == JSONToken.NULL) {
//				parser.getLexer().nextToken(JSONToken.COMMA);
//				return null;
//			}
//			if (token == JSONToken.COMMA) {
//				JSONScanner lexer = (JSONScanner) parser.getLexer();
//				String val;
//				lexer.nextToken();
//				lexer.nextTokenWithColon(JSONToken.LITERAL_STRING);
//				val = lexer.stringVal();
//				lexer.nextToken(JSONToken.RBRACE);
//				lexer.nextToken();
//				Money money = new Money(val);
//				return (T) money;
//
//			} else {
//				Object value = parser.parse();
//				if (value == null) {
//					return null;
//				}
//				Money money = new Money(value.toString());
//				return (T) money;
//			}
//		} catch (Exception e) {
//			throw new ParamFormatException ("", "", "Money");
//		}
//	}
//
//	public int getFastMatchToken() {
//		return JSONToken.LITERAL_FLOAT;
//	}
//}
