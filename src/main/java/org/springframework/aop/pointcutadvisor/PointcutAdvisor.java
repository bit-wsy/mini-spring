package org.springframework.aop.pointcutadvisor;

import org.springframework.aop.Pointcut;

public interface PointcutAdvisor extends Advisor {

    Pointcut getPointcut();
}
