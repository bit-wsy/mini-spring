package org.springframework.context.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.aware.Aware;
import org.springframework.context.ApplicationContext;

public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
