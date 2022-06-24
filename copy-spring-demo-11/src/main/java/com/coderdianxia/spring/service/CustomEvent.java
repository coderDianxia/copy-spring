package com.coderdianxia.spring.service;

import com.coderdianxia.spring.context.ApplicationEvent;
import com.coderdianxia.spring.context.event.ApplicationContextEvent;
import lombok.Data;

/**
 * @ClassName: CustomEvent
 * @Description:TODO
 * @Author:coderDianxia
 * @Date: 2022/5/16 17:48
 */
public class CustomEvent extends ApplicationContextEvent {

    private Long id;

    private String msg;
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public CustomEvent(Object source,Long id,String msg) {
        super(source);
        this.id =id;
        this.msg = msg;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
