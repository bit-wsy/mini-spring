package org.springframework.context.annotion;

import java.lang.annotation.*;

// 类，接口和方法
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Scope {

    String value() default "singleton";
}
