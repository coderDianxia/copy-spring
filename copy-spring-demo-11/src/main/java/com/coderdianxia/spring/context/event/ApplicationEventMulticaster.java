package com.coderdianxia.spring.context.event;

import com.coderdianxia.spring.context.ApplicationEvent;
import com.coderdianxia.spring.context.ApplicationListener;

/**
 * @ClassName: ApplicationEventMulticaster
 * @Description:TODO
 * @Author:coderDianxia
 * @Date: 2022/5/16 17:07
 */
public interface ApplicationEventMulticaster {

    /**
     * Add a listener to be notified of all events.
     * @param listener the listener to add
     */
    void addApplicationListener(ApplicationListener<?> listener);

    /**
     * Remove a listener from the notification list.
     * @param listener the listener to remove
     */
    void removeApplicationListener(ApplicationListener<?> listener);

    /**
     * Multicast the given application event to appropriate listeners.
     * @param event the event to multicast
     */
    void multicastEvent(ApplicationEvent event);
}
