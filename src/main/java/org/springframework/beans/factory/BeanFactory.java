package org.springframework.beans.factory;

import org.springframework.beans.BeansException;

public interface BeanFactory {
    // 获取bean 不存在时抛出异常
    Object getBean(String name) throws BeansException;

    <T> T getBean(String name, Class<T> requiredType) throws BeansException;

    <T> T getBean(Class<T> requiredType) throws BeansException;

    boolean containsBean(String name);
}
