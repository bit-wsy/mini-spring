package org.springframework.aop.pointcutadvisor;

import org.springframework.aop.Pointcut;
import org.springframework.aop.advice.*;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;

public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {

    private AspectJExpressionPointcut pointcut;

    private GenericInterceptor genericInterceptor;

    private String expression;

    public void setExpression(String expression) {
        this.expression = expression;
        pointcut = new AspectJExpressionPointcut(expression);
    }

    @Override
    public Pointcut getPointcut() {
        if (pointcut == null) {
            pointcut = new AspectJExpressionPointcut(expression);
        }
        return pointcut;
    }

    @Override
    public GenericInterceptor getGenericInterceptor() {
        return genericInterceptor;
    }

    public void setGenericInterceptor(GenericInterceptor genericInterceptor) {
        this.genericInterceptor = genericInterceptor;
    }

}
