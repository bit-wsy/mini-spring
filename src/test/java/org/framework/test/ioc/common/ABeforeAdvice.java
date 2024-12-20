package org.framework.test.ioc.common;

import org.springframework.aop.advice.BeforeAdvice;

import java.lang.reflect.Method;

public class ABeforeAdvice implements BeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {

    }
}