/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2017-02-28 23:20 创建
 *
 */
package com.jvv.openapi.facade.constants.validation;

import com.google.common.collect.Maps;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Map;
import java.util.Set;

/**
 * @author turalyon@jinvovo.com
 */
public enum ValidateUtils {
	INSTANCE {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

		@Override
		public Validator getValidator() {
			return factory.getValidator();
		}
	};

	public abstract Validator getValidator();

	/**
	 * 校验Order
	 *
	 * @param groups
	 */
	public static void check(Object obj, Class<?>... groups) {
		Set<ConstraintViolation<Object>> constraintViolations = ValidateUtils.INSTANCE.getValidator()
				.validate(obj, groups);
		validate(constraintViolations);
	}

	protected static <T> void validate(Set<ConstraintViolation<T>> constraintViolations) {
		IllegalArgumentException exception = null;
		if (constraintViolations != null && !constraintViolations.isEmpty()) {
			Map<String, String> errMsgs = Maps.newTreeMap();
			for (ConstraintViolation<T> constraintViolation : constraintViolations) {
				errMsgs.put(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
			}

			StringBuilder infoBuilder = new StringBuilder();
			for (Map.Entry<String, String> errMsg : errMsgs.entrySet()) {
				infoBuilder.append(errMsg.getKey()).append(":")
						.append(errMsg.getValue()).append(";");
			}
			exception = new IllegalArgumentException(infoBuilder.toString());
		}
		if (exception != null) {
			throw exception;
		}
	}
}
