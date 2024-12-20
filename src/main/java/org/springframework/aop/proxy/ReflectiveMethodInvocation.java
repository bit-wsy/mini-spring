package org.springframework.aop.proxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.List;

public class ReflectiveMethodInvocation implements MethodInvocation {

    protected final Object target;

    protected final Method method;

    protected final Object[] argument;

    protected final Object proxy;

    protected final Class<?> targetClass;

    protected final List<Object> interceptorsAndDynamicMethodMatchers;

    private int currentInterceptorIndex = -1;

    public ReflectiveMethodInvocation(Object proxy,Object target, Method method, Object[] arguments,Class<?> targetClass,List<Object> chain) {
        this.proxy=proxy;
        this.target = target;
        this.method = method;
        this.argument = arguments;
        this.targetClass=targetClass;
        this.interceptorsAndDynamicMethodMatchers=chain;
    }

    @Override
    public Object proceed() throws Throwable {
        // 初始currentInterceptorIndex为-1，每调用一次proceed就把currentInterceptorIndex+1
        if (this.currentInterceptorIndex == this.interceptorsAndDynamicMethodMatchers.size() - 1) {
            // 当调用次数 = 拦截器个数时
            // 触发当前method方法
            return method.invoke(this.target, this.argument);
        }

        Object interceptorOrInterceptionAdvice =
                this.interceptorsAndDynamicMethodMatchers.get(++this.currentInterceptorIndex);
        // 普通拦截器，直接触发拦截器invoke方法
        return ((MethodInterceptor) interceptorOrInterceptionAdvice).invoke(this);
    }

    @Override
    public Method getMethod() {
        return method;
    }

    @Override
    public Object[] getArguments() {
        return argument;
    }

    @Override
    public Object getThis() {
        return target;
    }

    // AccessibleObject 用于表示Java类的成员（字段、方法和构造函数），并允许在运行时反射地访问它们。
    @Override
    public AccessibleObject getStaticPart() {
        return method;
    }
}
