package com.coderdianxia.spring.context;

import com.coderdianxia.spring.context.ApplicationEvent;

/**
 * @ClassName: ApplicationEventPublisher
 * @Description:TODO
 * @Author:coderDianxia
 * @Date: 2022/5/16 17:23
 */
public interface ApplicationEventPublisher {

    public void publish(ApplicationEvent event);
}
