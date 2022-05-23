package com.coderdianxia.spring.context.event;

import com.coderdianxia.spring.beans.factory.BeanFactory;
import com.coderdianxia.spring.beans.factory.ConfigurableListableBeanFactory;
import com.coderdianxia.spring.context.ApplicationEvent;
import com.coderdianxia.spring.context.ApplicationListener;

/**
 * @ClassName: SimpleApplicationEventMulticaster
 * @Description:TODO
 * @Author:coderDianxia
 * @Date: 2022/5/16 17:29
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster {
    public SimpleApplicationEventMulticaster(ConfigurableListableBeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @Override
    public void multicastEvent(ApplicationEvent event) {
        for (final ApplicationListener listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }
}
