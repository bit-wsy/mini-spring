package org.springframework.beans.initanddestroy;

public interface InitializingBean {

    void afterPropertiesSet() throws Exception;
}
