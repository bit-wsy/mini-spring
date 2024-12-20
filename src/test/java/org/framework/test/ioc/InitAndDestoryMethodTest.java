package org.framework.test.ioc;

import org.junit.Test;
import org.springframework.context.xml.ClassPathXmlApplicationContext;

public class InitAndDestoryMethodTest {
    @Test
    public void testInitAndDestroyMethod() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:init-and-destroy-method.xml");
        applicationContext.registerShutdownHook();  //或者手动关闭 applicationContext.close();
    }
}
