package org.framework.test.aop.common;

import org.springframework.aop.advice.AfterReturningAdvice;

import java.lang.reflect.Method;

public class WorldServiceAfterReturningAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("AfterReturningAdvice: do something after the earth explodes return");
    }
}
