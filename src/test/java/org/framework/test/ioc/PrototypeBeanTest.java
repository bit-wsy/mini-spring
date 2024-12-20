package org.framework.test.ioc;

import org.framework.test.ioc.bean.Car;
import org.junit.Test;
import org.springframework.context.xml.ClassPathXmlApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class PrototypeBeanTest {
    @Test
    public void testPrototype() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:prototype-bean.xml");

        Car car1 = applicationContext.getBean("car", Car.class);
        Car car2 = applicationContext.getBean("car", Car.class);
        assertThat(car1 != car2).isTrue();
    }
}
