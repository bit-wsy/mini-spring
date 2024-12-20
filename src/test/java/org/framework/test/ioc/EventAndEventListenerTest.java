package org.framework.test.ioc;

import org.framework.test.ioc.common.event.CustomEvent;
import org.junit.Test;
import org.springframework.context.xml.ClassPathXmlApplicationContext;

public class EventAndEventListenerTest {

    @Test
    public void testEventListener() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:event-and-event-listener.xml");
        applicationContext.publishEvent(new CustomEvent(applicationContext));

        applicationContext.registerShutdownHook();//或者applicationContext.close()主动关闭容器;
    }

}
