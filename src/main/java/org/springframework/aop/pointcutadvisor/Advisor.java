package org.springframework.aop.pointcutadvisor;

import org.springframework.aop.advice.GenericInterceptor;

public interface Advisor {

    GenericInterceptor getGenericInterceptor();
}
