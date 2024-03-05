package com.demo.utils;

import java.util.Objects;
import java.util.Properties;

import com.demo.constants.EnvEnums;
import com.demo.constants.FrameworkConstants;
import com.demo.customexception.InvalidKeyException;

public final class PropertyUtils {

	private PropertyUtils() {

	}

	private static PropertyUtils propertyUtils = null;

	public static synchronized PropertyUtils getPropertyUtilInstance() {
		if (propertyUtils == null) {
			propertyUtils = new PropertyUtils();
		}
		return propertyUtils;
	}

	public String getPropertyValue(EnvEnums enums) {
		Properties properties = PropertyBuilder.getPropertyFile(FrameworkConstants.getFCInstance().getConfigPropPath());
		if (Objects.isNull(properties.getProperty(enums.name().toLowerCase()))) {
			throw new InvalidKeyException("Invalid key: " + properties.getProperty(enums.name().toLowerCase()));
		}
		return properties.getProperty(enums.name().toLowerCase());
	}

}
