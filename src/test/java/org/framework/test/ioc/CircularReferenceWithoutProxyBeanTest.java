package org.framework.test.ioc;

import org.framework.test.ioc.bean.A;
import org.framework.test.ioc.bean.B;
import org.junit.Test;
import org.springframework.context.xml.ClassPathXmlApplicationContext;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class CircularReferenceWithoutProxyBeanTest {

    @Test
    public void testCircularRefreence() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:circular-reference-without-proxy-bean.xml");
        A a = applicationContext.getBean("a", A.class);
        B b = applicationContext.getBean("b", B.class);
        assertThat(a.getB() == b).isTrue();
    }
}
