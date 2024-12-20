package org.framework.test.aop.common;

import org.springframework.aop.advice.ThrowsAdvice;

import java.lang.reflect.Method;

public class WorldServiceThrowsAdvice implements ThrowsAdvice {

    @Override
    public void throwsHandle(Throwable throwable, Method method, Object[] args, Object target) {
        System.out.println("ThrowsAdvice: do something when the earth explodes function throw an exception");
    }
}
