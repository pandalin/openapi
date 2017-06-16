/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */

package com.jvv.openapi.doc.utils;

import com.jvv.openapi.doc.enums.ApiDataType;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

/**
 * Api文档类型判断工具
 * 
 * @author zhangpu
 *
 */
public class ApiDataTypeUtils {


	public static final String DATA_LENGTH_SPLITER = "-";

	public static boolean isSimpleType(Class<?> clazz) {
		return isString(clazz) || isNumber(clazz);
	}

	/**
	 * 判断是否API文档字符串类型
	 * 
	 * 包括JAVA类型:String, Date和枚举
	 * 
	 * @param field
	 * @return
	 */
	public static boolean isString(Field field) {
		return isString(field.getType());
	}

	public static boolean isString(Class<?> clazz) {
		return String.class.isAssignableFrom(clazz) || Character.class.isAssignableFrom(clazz)
				|| Date.class.isAssignableFrom(clazz) || Boolean.class.isAssignableFrom(clazz) || clazz.isEnum()
				|| (clazz.isPrimitive() && "boolean,char".contains(clazz.toString()));
	}

	public static String getStringType(Field field) {
		Annotation[] Annotations = field.getAnnotations();
		int start = Integer.MIN_VALUE;
		int end = Integer.MAX_VALUE;
		for (Annotation a : Annotations) {
			if (Size.class.isAssignableFrom(a.getClass())) {
				Size s = (Size) a;
				start = s.min();
				end = s.max();
			} else if (Length.class.isAssignableFrom(a.getClass())) {
				Length s = (Length) a;
				start = s.min();
				end = s.max();
			}
		}
		if (start == Integer.MIN_VALUE && end == Integer.MAX_VALUE) {
			return ApiDataType.S.getCode();
		} else {
			StringBuilder sb = new StringBuilder();
			if (start == end) {
				sb.append("FS(").append(start).append(")");
			} else {
				sb.append("S(").append(start).append("-").append(end).append(")");
			}
			return sb.toString();
		}
	}

	/**
	 * 判断是否数字类型
	 * 
	 * @param field
	 * @return
	 */
	public static boolean isNumber(Field field) {
		return isNumber(field.getType());
	}

	public static boolean isNumber(Class<?> clazz) {
		return Number.class.isAssignableFrom(clazz)
				|| (clazz.isPrimitive() && "long,int,byte,short".contains(clazz.toString()));
	}

	public static String getNumberType(Field field) {
		int minLength = 1;
		int maxLength = String.valueOf(Integer.MAX_VALUE).length();
		boolean setting = false;
		Min min = (Min) field.getAnnotation(Min.class);
		if (min != null) {
			minLength = String.valueOf(min.value()).length();
			setting = true;
		}
		Max max = (Max) field.getAnnotation(Max.class);
		if (max != null) {
			maxLength = String.valueOf(max.value()).length();
			setting = true;
		}

		if (setting) {
			return minLength == maxLength ? "FN(" + maxLength + ")" : "N(" + minLength + "-" + maxLength + ")";
		} else {
			return "N";
		}
	}

	/**
	 * 判断是否数组
	 * 
	 * 包括类型：集合和数组
	 * 
	 * @param field
	 * @return
	 */
	public static boolean isCollection(Field field) {
		return Collection.class.isAssignableFrom(field.getType()) || field.getType().isArray();
	}

	public static boolean isMap(Field field) {
		return Map.class.isAssignableFrom(field.getType());
	}

	public static boolean isMoney(Field field) {
		return false;
//		return Money.class.isAssignableFrom(field.getType());
	}

	/**
	 *
	 * @param field
	 * @return
	 */
	public static ApiDataType converetToApiData(Field field){
		if (ApiDataTypeUtils.isString(field)) {
			Size size = field.getAnnotation(Size.class);
			Length length = field.getAnnotation(Length.class);

			if(size != null && size.max() == size.min()){
				return ApiDataType.FS;
			}

			if(length != null && length.max() == length.min()){
				return ApiDataType.FS;
			}

			return ApiDataType.S;
		}

		if (ApiDataTypeUtils.isNumber(field)) {
			return ApiDataType.N;
		}

		if (ApiDataTypeUtils.isMoney(field)) {
			return ApiDataType.M;
		}

		if (ApiDataTypeUtils.isCollection(field)) {
			return ApiDataType.JSON_ARRAY;
		}

		return ApiDataType.JSON;
	}

	/**
	 * 解析对应字段的长度
	 * @param field
	 * @return 返回对应字段的长度,如果为非String类型返回null.
	 */
	public static String getDataLength(Field field){
		if (ApiDataTypeUtils.isString(field)) {
			String dataLength = null;
			Size size = field.getAnnotation(Size.class);
			Length length = field.getAnnotation(Length.class);

			if(size != null){
				if(size.min() == size.max()){
					dataLength = "" + size.min();
				}
				else{
					dataLength = ""+size.min()+DATA_LENGTH_SPLITER+size.max();
				}
			}

			if(length != null){
				if(length.min() == length.max()){
					dataLength = "" + length.min();
				}
				else{
					dataLength = ""+length.min()+DATA_LENGTH_SPLITER+length.max();
				}
			}
			return  dataLength;
		}

		return null;
	}

	// public static void main(String[] args) throws Exception {
	//
	// Field[] fs = PojoDto.class.getDeclaredFields();
	// for (Field f : fs) {
	// System.out.println(f.getName() + " " + f.getType() + " "
	// + isNumber(f));
	// }
	//
	// }

}
