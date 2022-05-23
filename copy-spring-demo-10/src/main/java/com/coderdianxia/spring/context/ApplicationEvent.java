package com.coderdianxia.spring.context;

import java.util.EventObject;

/**
 * @ClassName: ApplicationEvent
 * @Description:TODO
 * @Author:coderDianxia
 * @Date: 2022/5/16 17:03
 */
public abstract class ApplicationEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationEvent(Object source) {
        super(source);
    }
}
