package org.springframework.beans.instantiation;

import org.springframework.beans.BeansException;
import org.springframework.beans.definition.BeanDefinition;

public interface InstantiationStrategy {
    Object instantiate(BeanDefinition beanDefinition) throws BeansException;
}
