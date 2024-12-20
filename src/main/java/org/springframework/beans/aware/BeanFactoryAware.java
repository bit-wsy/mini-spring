package org.springframework.beans.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;

public interface BeanFactoryAware extends Aware{
    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
