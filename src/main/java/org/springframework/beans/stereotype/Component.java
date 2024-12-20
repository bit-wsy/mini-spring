package org.springframework.beans.stereotype;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
// 该注解可以应用于类、接口
@Retention(RetentionPolicy.RUNTIME)
// 该注解将在编译时被记录在类文件中，并且在运行时可以通过反射机制读取
@Documented
public @interface Component {
    String value() default "";
}
