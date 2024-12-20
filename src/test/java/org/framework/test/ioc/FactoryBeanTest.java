package org.framework.test.ioc;

import org.framework.test.ioc.bean.Car;
import org.junit.Test;
import org.springframework.context.xml.ClassPathXmlApplicationContext;
import static org.assertj.core.api.Assertions.assertThat;

public class FactoryBeanTest {
    @Test
    public void testFactoryBean() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:factory-bean.xml");

        Car car = applicationContext.getBean("car", Car.class);
        assertThat(car.getBrand()).isEqualTo("porsche");
    }
}

