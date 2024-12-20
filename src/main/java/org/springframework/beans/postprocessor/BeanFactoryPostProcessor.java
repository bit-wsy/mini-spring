package org.springframework.beans.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ConfigurableListableBeanFactory;

public interface BeanFactoryPostProcessor {

    // BD加载后，bean实例化之前提供的处理，提供給實現類的接口
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
