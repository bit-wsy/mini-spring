package org.springframework.aop;

import java.lang.reflect.Method;

// 限定Joinpoint（连接点）的匹配范围，判断某个方法是否匹配，方法是否应该被增强（Advice）。
public interface MethodMatcher {

    boolean matches(Method method, Class<?> targetClass);
}
