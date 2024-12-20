package org.framework.test.ioc;

import org.framework.test.ioc.service.HelloService;
import org.junit.Test;
import org.springframework.context.xml.ClassPathXmlApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class AwareInterfaceTest {
    @Test
    public void test() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-aware.xml");
        HelloService helloService = applicationContext.getBean("helloService", HelloService.class);
        assertThat(helloService.getApplicationContext()).isNotNull();
        assertThat(helloService.getBeanFactory()).isNotNull();
    }
}
