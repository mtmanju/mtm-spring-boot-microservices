package com.mtm.examples.examples.service.error;

import com.mtm.examples.examples.error.CustomError;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Properties;

@Service("errorMessageResolverService")
public class ErrorMessageResolverService {

    public String getErrorMessageForErrorCode(CustomError errorCode, String[] params, String locale)
            throws IOException {
        if (null != errorCode) {
            Properties properties = PropertiesLoaderUtils.loadProperties(
                    new ClassPathResource(String.format("errorMessage_%s.properties", locale.toLowerCase())));
            String errorMessage = properties.getProperty(errorCode.name());
            if (StringUtils.isNotBlank(errorMessage)) {
                return String.format(errorMessage, (Object[]) params);
            }
        }
        return null;
    }
}