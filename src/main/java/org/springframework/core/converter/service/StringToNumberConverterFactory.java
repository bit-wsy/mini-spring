package org.springframework.core.converter.service;

import org.springframework.core.converter.Converter;
import org.springframework.core.converter.ConverterFactory;

public class StringToNumberConverterFactory implements ConverterFactory<String, Number> {

    // T应该是诸如int的类型
    @Override
    public <T extends Number> Converter<String, T> getConverter(Class<T> targetType) {
        return new StringToNumber<T>(targetType);
    }

    private static final class StringToNumber<T extends Number> implements Converter<String, T> {

        private final Class<T> targetType;

        public StringToNumber(Class<T> targetType) {
            this.targetType = targetType;
        }

        @Override
        public T convert(String source) {
            if (source.isEmpty()) {
                return null;
            }

            if (targetType.equals(Integer.class)) {
                return (T) Integer.valueOf(source);
            } else if (targetType.equals(Long.class)) {
                return (T) Long.valueOf(source);
            } else {
                throw new IllegalArgumentException(
                   "Cannot convert String [" + source + "] to target class [" + targetType.getName() + "]");
            }
        }
    }
}
