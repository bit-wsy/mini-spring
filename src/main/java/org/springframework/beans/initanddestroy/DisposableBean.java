package org.springframework.beans.initanddestroy;

public interface DisposableBean {
    void destroy() throws Exception;
}
