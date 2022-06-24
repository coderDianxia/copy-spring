package com.coderdianxia.spring.context.event;

import com.coderdianxia.spring.context.ApplicationContext;
import com.coderdianxia.spring.context.ApplicationEvent;

/**
 * @ClassName: ApplicationContextEvent
 * @Description:TODO
 * @Author:coderDianxia
 * @Date: 2022/5/16 17:04
 */
public class ApplicationContextEvent extends ApplicationEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationContextEvent(Object source) {
        super(source);
    }

    /**
     * Get the <code>ApplicationContext</code> that the event was raised for.
     */
    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }
}
