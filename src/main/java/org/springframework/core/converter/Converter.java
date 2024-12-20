package org.springframework.core.converter;

public interface Converter<S, T> {

    T convert(S source);
}
