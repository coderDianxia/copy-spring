package com.coderdianxia.spring.context.support;

import com.coderdianxia.spring.beans.factory.BeanException;
import com.coderdianxia.spring.beans.factory.config.BeanPostProcessor;
import com.coderdianxia.spring.context.ApplicationContext;
import com.coderdianxia.spring.context.ApplicationContextAware;

/**
 * @ClassName: ApplicationContextAwareProcessor
 * @Description:TODO
 * @Author:coderDianxia
 * @Date: 2022/5/13 16:54
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeanException {
        if(bean instanceof ApplicationContextAware)
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeanException {
        return bean;
    }
}
