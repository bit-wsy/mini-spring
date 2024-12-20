package org.springframework.beans.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Inherited
@Documented
public @interface Qualifier {
    String value() default "";
}
// 当应用程序中存在多个相同类型的bean时，
// 直接使用@Autowired进行注入会导致Spring无法确定要注入哪个bean。
// 此时，可以使用@Qualifier注解来指定要注入的bean的名称或ID