package com.coderdianxia.spring.beans.factory.support;

import com.coderdianxia.spring.beans.factory.BeanException;
import com.coderdianxia.spring.beans.factory.BeanFactory;
import com.coderdianxia.spring.beans.factory.config.BeanDefinition;

/**
 * @ClassName: AbstractBeanFactory
 * @Author: coderDianxia
 * @Date: 2022/5/10 15:28
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String beanName) throws BeanException {
        Object bean = getSingleton(beanName);
        if(bean != null)
            return bean;
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return createBean(beanName,beanDefinition);
    }

    protected  abstract BeanDefinition getBeanDefinition(String beanName) throws BeanException;

    protected  abstract Object createBean(String beanName,BeanDefinition beanDefinition) throws BeanException;
}
