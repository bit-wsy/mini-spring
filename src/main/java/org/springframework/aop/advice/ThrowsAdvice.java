package org.springframework.aop.advice;

import org.aopalliance.aop.Advice;

import java.lang.reflect.Method;

public interface ThrowsAdvice extends Advice{

    void throwsHandle(Throwable throwable, Method method, Object[] args, Object target);
}
