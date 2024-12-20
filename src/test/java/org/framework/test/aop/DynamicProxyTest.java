package org.framework.test.aop;

import org.framework.test.aop.common.WorldServiceAfterAdvice;
import org.framework.test.aop.common.WorldServiceAfterReturningAdvice;
import org.framework.test.aop.common.WorldServiceBeforeAdvice;
import org.framework.test.aop.common.WorldServiceThrowsAdvice;
import org.framework.test.aop.service.WorldService;
import org.framework.test.aop.service.WorldServiceImpl;
import org.framework.test.aop.service.WorldServiceWithExceptionImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.advice.GenericInterceptor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.pointcutadvisor.AspectJExpressionPointcutAdvisor;
import org.springframework.aop.proxy.AdvisedSupport;
import org.springframework.aop.proxy.ProxyFactory;
import org.springframework.aop.proxy.TargetSource;
import org.springframework.aop.proxy.cglib.CglibAopProxy;
import org.springframework.aop.proxy.jdk.JdkDynamicAopProxy;

public class DynamicProxyTest {

    private AdvisedSupport advisedSupport;

    @Before
    public void setup() {
        WorldService worldService = new WorldServiceImpl();

        advisedSupport = new AdvisedSupport();
        TargetSource targetSource = new TargetSource(worldService);
        GenericInterceptor methodInterceptor = new GenericInterceptor();
        MethodMatcher methodMatcher = new AspectJExpressionPointcut("execution(* org.framework.test.aop.service.WorldService.explode(..))").getMethodMatcher();
        advisedSupport.setTargetSource(targetSource);
        advisedSupport.setMethodInterceptor(methodInterceptor);
        advisedSupport.setMethodMatcher(methodMatcher);
    }

    @Test
    public void testJdkDynamicProxy() throws Exception {
        WorldService proxy = (WorldService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        proxy.explode();
    }

    @Test
    public void testCglibDynamicProxy() throws Exception {
        WorldService proxy = (WorldService) new CglibAopProxy(advisedSupport).getProxy();
        proxy.explode();
    }

    @Test
    public void testProxyFactory() throws Exception {
        // 使用JDK动态代理
        advisedSupport.setProxyTargetClass(false);
        WorldService proxy = (WorldService) new ProxyFactory(advisedSupport).getProxy();
        proxy.explode();

        // 使用CGLIB动态代理
        advisedSupport.setProxyTargetClass(true);
        proxy = (WorldService) new ProxyFactory(advisedSupport).getProxy();
        proxy.explode();
    }

    @Test
    public void testBeforeAdvice() throws Exception {
        //设置BeforeAdvice
        WorldServiceBeforeAdvice beforeAdvice = new WorldServiceBeforeAdvice();
        GenericInterceptor methodInterceptor = new GenericInterceptor();
        methodInterceptor.setBeforeAdvice(beforeAdvice);
        advisedSupport.setMethodInterceptor(methodInterceptor);

        WorldService proxy = (WorldService) new ProxyFactory(advisedSupport).getProxy();
        proxy.explode();
    }

    @Test
    public void testAfterAdvice() throws Exception {
        //设置AfterAdvice
        WorldServiceAfterAdvice afterAdvice = new WorldServiceAfterAdvice();
        GenericInterceptor methodInterceptor = new GenericInterceptor();
        methodInterceptor.setAfterAdvice(afterAdvice);
        advisedSupport.setMethodInterceptor(methodInterceptor);

        WorldService proxy = (WorldService) new ProxyFactory(advisedSupport).getProxy();
        proxy.explode();
    }

    @Test
    public void testAfterReturningAdvice() throws Exception {
        //设置AfterReturningAdvice
        WorldServiceAfterReturningAdvice afterReturningAdvice = new WorldServiceAfterReturningAdvice();
        GenericInterceptor methodInterceptor = new GenericInterceptor();
        methodInterceptor.setAfterReturningAdvice(afterReturningAdvice);
        advisedSupport.setMethodInterceptor(methodInterceptor);

        WorldService proxy = (WorldService) new ProxyFactory(advisedSupport).getProxy();
        proxy.explode();
    }

    @Test
    public void testThrowsAdvice() throws Exception {
        WorldService worldService = new WorldServiceWithExceptionImpl();
        //设置ThrowsAdvice
        WorldServiceAfterReturningAdvice afterReturningAdvice = new WorldServiceAfterReturningAdvice();
        GenericInterceptor methodInterceptor = new GenericInterceptor();
        methodInterceptor.setAfterReturningAdvice(afterReturningAdvice);
        advisedSupport.setMethodInterceptor(methodInterceptor);
        advisedSupport.setTargetSource(new TargetSource(worldService));

        WorldService proxy = (WorldService) new ProxyFactory(advisedSupport).getProxy();
        proxy.explode();
    }


    @Test
    public void testAllAdvice() throws Exception {
        //设置before、after、afterReturning
        GenericInterceptor methodInterceptor = new GenericInterceptor();
        methodInterceptor.setBeforeAdvice(new WorldServiceBeforeAdvice());
        methodInterceptor.setAfterAdvice(new WorldServiceAfterAdvice());
        methodInterceptor.setAfterReturningAdvice(new WorldServiceAfterReturningAdvice());
        advisedSupport.setMethodInterceptor(methodInterceptor);

        WorldService proxy = (WorldService) new ProxyFactory(advisedSupport).getProxy();
        proxy.explode();
    }

    @Test
    public void testAllAdviceWithException() throws Exception {
        WorldService worldService = new WorldServiceWithExceptionImpl();
        //设置before、after、throws
        GenericInterceptor methodInterceptor = new GenericInterceptor();
        methodInterceptor.setBeforeAdvice(new WorldServiceBeforeAdvice());
        methodInterceptor.setAfterAdvice(new WorldServiceAfterAdvice());
        methodInterceptor.setThrowsAdvice(new WorldServiceThrowsAdvice());
        advisedSupport.setMethodInterceptor(methodInterceptor);
        advisedSupport.setTargetSource(new TargetSource(worldService));

        WorldService proxy = (WorldService) new ProxyFactory(advisedSupport).getProxy();
        proxy.explode();
    }

    @Test
    public void testAdvisor() throws Exception {
        WorldService worldService = new WorldServiceImpl();

        //Advisor是Pointcut和Advice的组合
        String expression = "execution(* org.framework.test.aop.service.WorldService.explode(..))";
        AspectJExpressionPointcutAdvisor advisor = new AspectJExpressionPointcutAdvisor();
        advisor.setExpression(expression);
        GenericInterceptor methodInterceptor = new GenericInterceptor();
        methodInterceptor.setBeforeAdvice(new WorldServiceBeforeAdvice());
        advisor.setGenericInterceptor(methodInterceptor);

        ClassFilter classFilter = advisor.getPointcut().getClassFilter();
        if (classFilter.matches(worldService.getClass())) {
            AdvisedSupport advisedSupport = new AdvisedSupport();

            TargetSource targetSource = new TargetSource(worldService);
            advisedSupport.setTargetSource(targetSource);
            advisedSupport.setMethodInterceptor(advisor.getGenericInterceptor());
            advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher());
//			advisedSupport.setProxyTargetClass(true);   //JDK or CGLIB

            WorldService proxy = (WorldService) new ProxyFactory(advisedSupport).getProxy();
            proxy.explode();
        }
    }
}
