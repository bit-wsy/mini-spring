package org.framework.test.aop;

import org.framework.test.ioc.service.HelloService;
import org.junit.Test;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;

import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

public class PointcutExpressionTest {

    @Test
    public void testPointcutExpression() throws Exception {
        // 返回类型*，类名org.framework.test.ioc.service.HelloService，.*方法名，(..)参数类型
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut("execution(* org.framework.test.ioc.service.HelloService.*(..))");
        Class<HelloService> clazz = HelloService.class;
        Method method = clazz.getDeclaredMethod("sayHello");

        assertThat(pointcut.matches(clazz)).isTrue();
        assertThat(pointcut.matches(method, clazz)).isTrue();
    }
}
