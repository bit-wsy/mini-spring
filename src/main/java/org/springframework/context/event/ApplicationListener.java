package org.springframework.context.event;

import java.util.EventListener;
import java.util.EventObject;

public interface ApplicationListener <E extends EventObject> extends EventListener {

    void onApplicationEvent(E event);
}
