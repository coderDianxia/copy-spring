package com.coderdianxia.spring.context;

import java.util.EventListener;

/**
 * @ClassName: ApplicationListener
 * @Description:TODO
 * @Author:coderDianxia
 * @Date: 2022/5/16 17:10
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {

    public void onApplicationEvent(E event);
}
