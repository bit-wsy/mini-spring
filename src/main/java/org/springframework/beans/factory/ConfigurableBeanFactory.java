package org.springframework.beans.factory;

import org.springframework.beans.postprocessor.BeanPostProcessor;
import org.springframework.beans.registry.SingletonBeanRegistry;
import org.springframework.core.converter.service.ConversionService;
import org.springframework.util.StringValueResolver;

public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    void destroySingletons();

    String resolveEmbeddedValue(String value);

    void addEmbeddedValueResolver(StringValueResolver valueResolver);

    void setConversionService(ConversionService conversionService);

    ConversionService getConversionService();
}
