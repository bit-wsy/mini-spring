package org.springframework.context.event;

public interface ApplicationEventPublisher {

    // 发布事件
    void publishEvent(ApplicationEvent event);

}
