/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2017-03-13 12:06 创建
 *
 */
package com.jvv.openapi.core.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/**
 * Provides a helper that locates the declarated generics type of a class.
 * 当没有父类时，需要实现
 * IOneGenericType(一个泛型参数)/ITowGenericType(两个泛型参数)/IThreeGenericType(三个个泛型参数)
 * @author sshwsfc@gmail.com
 * @version V1.0
 * @Description:
 * @date 2015/12/23 20:37
 *
 */
@SuppressWarnings("rawtypes")
public class GenericsUtils {
	/**
	 * Locates the first generic declaration on a class.
	 *
	 * @param clazz The class to introspect
	 * @return the first generic declaration, or <code>null</code> if cannot be
	 * determined
	 */
	public static Class getGenericClass(Class clazz) {
		return getGenericClass(clazz, 0);
	}

	/**
	 * Locates generic declaration by index on a class.
	 *
	 * @param clazz clazz The class to introspect
	 * @param index the Index of the generic ddeclaration,start from 0.
	 */
	public static Class getGenericClass(Class clazz, int index) {
		Type genType = clazz.getGenericSuperclass();

		if (genType instanceof ParameterizedType) {
			Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

			if ((params != null) && (params.length >= (index - 1))) {
				return (Class) params[index];
			}
		} else {
			Type[] genTypes = clazz.getGenericInterfaces();
			for (Type gt : genTypes) {
				if (gt instanceof ParameterizedType) {
					Type[] params = ((ParameterizedType) gt).getActualTypeArguments();

					if ((params != null) && (params.length >= (index - 1))) {
						Type param = params[index];
						if (param instanceof TypeVariable) {
							TypeVariable typeVariable = (TypeVariable) param;
							Type[] boundsounds = typeVariable.getBounds();
							return (Class) boundsounds[0];
						}
					}
				}
			}
		}
		return null;
	}

	/**
	 * 通过反射,获得定义Class时声明的父类的范型参数的类型.
	 */
	public static Class getSuperClassGenricType(Class clazz) {
		return getSuperClassGenricType(clazz, 0);
	}

	/**
	 * 通过反射,获得定义Class时声明的父类的范型参数的类型.
	 */
	public static Class getSuperClassGenricType(Class clazz, int index)
			throws IndexOutOfBoundsException {

		Type genType = clazz.getGenericSuperclass();

		if (!(genType instanceof ParameterizedType)) {

			return Object.class;
		}

		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

		if (index >= params.length || index < 0) {
			return Object.class;
		}
		if (!(params[index] instanceof Class)) {
			return Object.class;
		}
		return (Class) params[index];
	}
}