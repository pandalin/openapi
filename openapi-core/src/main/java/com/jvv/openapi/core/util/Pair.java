/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2017-03-12 23:23 创建
 *
 */
package com.jvv.openapi.core.util;

import java.io.Serializable;

/**
 * @author turalyon@jinvovo.com
 */

public class Pair<F, S> implements Serializable {
	/**
	 * 构造一个pair对象
	 *
	 * @param f 第一个对象
	 * @param s 第二个对象
	 * @return
	 */
	public static <F, S> Pair<F, S> build(F f, S s) {
		return new Pair<F, S>(f, s);
	}

	private final F f;
	private final S s;

	public Pair(F k, S v) {
		this.f = k;
		this.s = v;
	}

	/**
	 * 获取第一个对象
	 *
	 * @return
	 */
	public F getF() {
		return this.f;
	}

	/**
	 * 获取第二个对象
	 *
	 * @return
	 */
	public S getS() {
		return this.s;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((f == null) ? 0 : f.hashCode());
		result = prime * result + ((s == null) ? 0 : s.hashCode());
		return result;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		if (f == null) {
			if (other.f != null)
				return false;
		} else if (!f.equals(other.f))
			return false;
		if (s == null) {
			if (other.s != null)
				return false;
		} else if (!s.equals(other.s))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pair <").append(f).append(",").append(s).append(">");
		return builder.toString();
	}
}