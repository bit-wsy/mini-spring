package org.springframework.beans.factory;

import org.springframework.beans.BeansException;
import org.springframework.beans.definition.BeanDefinition;
import org.springframework.beans.postprocessor.BeanPostProcessor;

public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {
    // 根据名称查找beanDefinition
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
