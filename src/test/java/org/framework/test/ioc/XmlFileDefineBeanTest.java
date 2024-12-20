package org.framework.test.ioc;

import org.framework.test.ioc.bean.Car;
import org.framework.test.ioc.bean.Person;
import org.junit.Test;
import org.springframework.beans.factory.DefaultListableBeanFactory;
import org.springframework.beans.definition.reader.XmlBeanDefinitionReader;

import static org.assertj.core.api.Assertions.assertThat;

public class XmlFileDefineBeanTest {
    @Test
    public void testXmlFile() throws Exception {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        beanDefinitionReader.loadBeanDefinitions("classpath:spring.xml");

        Person person = (Person) beanFactory.getBean("person");
        System.out.println(person);
        assertThat(person.getName()).isEqualTo("derek");
        assertThat(person.getCar().getBrand()).isEqualTo("porsche");

        Car car = (Car) beanFactory.getBean("car");
        System.out.println(car);
        assertThat(car.getBrand()).isEqualTo("porsche");
    }
}
