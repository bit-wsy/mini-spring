package org.framework.test.ioc;

import org.framework.test.ioc.bean.Car;
import org.junit.Test;
import org.springframework.context.xml.ClassPathXmlApplicationContext;

import java.util.concurrent.TimeUnit;

public class LazyInitTest {
    @Test
    public void testLazyInit() throws InterruptedException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:lazy-test.xml");
        System.out.println(System.currentTimeMillis()+":applicationContext-over");
        TimeUnit.SECONDS.sleep(1);
        Car c= (Car) applicationContext.getBean("car");
        c.showTime();
    }
}
