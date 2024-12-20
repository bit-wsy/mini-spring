package org.springframework.beans.factorybean;

public interface FactoryBean<T> {

    T getObject() throws Exception;

    boolean isSingleton();
}
