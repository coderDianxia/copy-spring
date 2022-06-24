package com.coderdianxia.spring.context.event;

import com.coderdianxia.spring.context.ApplicationEvent;

/**
 * @ClassName: ContextRefreshedEvent
 * @Description:TODO
 * @Author:coderDianxia
 * @Date: 2022/5/16 17:06
 */
public class ContextRefreshedEvent extends ApplicationEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ContextRefreshedEvent(Object source) {
        super(source);
        System.out.println("容器关闭");
    }
}
