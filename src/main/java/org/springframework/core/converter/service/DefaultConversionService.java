package org.springframework.core.converter.service;

import org.springframework.core.converter.ConverterRegistry;

public class DefaultConversionService extends GenericConversionService {

    public static void addDefaultConverters(ConverterRegistry registry) {

        registry.addConverterFactory(new StringToNumberConverterFactory());
    }

    public DefaultConversionService() {
        addDefaultConverters(this);
    }
}
