package com.mtm.examples.commons.util;

import org.springframework.util.StringUtils;

public class CommonUtils {
    
    private CommonUtils() {
        // Private constructor to prevent instantiation
    }

    public static String generateResourceId(String prefix) {
        if (!StringUtils.hasText(prefix)) {
            throw new IllegalArgumentException("Prefix cannot be null or empty");
        }
        return prefix + "-" + System.currentTimeMillis();
    }

    public static void validateRequired(String value, String fieldName) {
        if (!StringUtils.hasText(value)) {
            throw new IllegalArgumentException(fieldName + " cannot be null or empty");
        }
    }

    public static void validatePositive(Number value, String fieldName) {
        if (value == null || value.doubleValue() <= 0) {
            throw new IllegalArgumentException(fieldName + " must be a positive number");
        }
    }
} 