package org.framework.test.aop.common;

import org.springframework.aop.advice.AfterAdvice;

import java.lang.reflect.Method;

public class WorldServiceAfterAdvice implements AfterAdvice {

    @Override
    public void after(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("AfterAdvice: do something after the earth explodes");
    }
}