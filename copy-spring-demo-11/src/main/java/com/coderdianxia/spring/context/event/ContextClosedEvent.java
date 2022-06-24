package com.coderdianxia.spring.context.event;

import com.coderdianxia.spring.context.ApplicationEvent;

/**
 * @ClassName: ContextClosedEvent
 * @Description:TODO
 * @Author:coderDianxia
 * @Date: 2022/5/16 17:05
 */
public class ContextClosedEvent extends ApplicationEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ContextClosedEvent(Object source) {
        super(source);
    }

    public ContextClosedEvent getSource() {
        return (ContextClosedEvent)getSource();
    }
}
