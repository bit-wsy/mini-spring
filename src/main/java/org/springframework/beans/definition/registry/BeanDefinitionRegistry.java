package org.springframework.beans.definition.registry;

import org.springframework.beans.BeansException;
import org.springframework.beans.definition.BeanDefinition;

// beandefinition注册
public interface BeanDefinitionRegistry {

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    boolean containsBeanDefinition(String beanName);

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    String[] getBeanDefinitionNames(); // 返回定义的所有bean
}
