package org.springframework.aop.proxy.jdk;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.proxy.AdvisedSupport;
import org.springframework.aop.proxy.AopProxy;
import org.springframework.aop.proxy.ReflectiveMethodInvocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

public class JdkDynamicAopProxy implements AopProxy, InvocationHandler {

    private final AdvisedSupport advised;

    public JdkDynamicAopProxy(AdvisedSupport advised) {
        this.advised = advised;
    }

    @Override
    public Object getProxy() {
        return Proxy.newProxyInstance(getClass().getClassLoader(), advised.getTargetSource().getTargetClass(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        if (advised.getMethodMatcher().matches(method, advised.getTargetSource().getTarget().getClass())) {
//            //代理方法
//            MethodInterceptor methodInterceptor = advised.getMethodInterceptor();
//            return methodInterceptor.invoke(new ReflectiveMethodInvocation(advised.getTargetSource().getTarget(), method, args));
//        }
//        return method.invoke(advised.getTargetSource().getTarget(), args);
        // 获取目标对象
        Object target = advised.getTargetSource().getTarget();
        Class<?> targetClass = target.getClass();
        Object retVal = null;
        // 获取拦截器链
        List<Object> chain = this.advised.getInterceptorsAndDynamicInterceptionAdvice(method, targetClass);
        if (chain == null || chain.isEmpty()) {
            return method.invoke(target, args);
        } else {
            // 将拦截器统一封装成ReflectiveMethodInvocation
            MethodInvocation invocation =
                    new ReflectiveMethodInvocation(proxy, target, method, args, targetClass, chain);
            // Proceed to the joinpoint through the interceptor chain.
            // 执行拦截器链
            retVal = invocation.proceed();
        }
        return retVal;
    }

}
