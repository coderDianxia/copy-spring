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

        return doGetBean(beanName,null);
    }

    @Override
    public Object getBean(String beanName, Object... args) throws BeanException {

        return doGetBean(beanName,args);
    }

    protected  Object doGetBean(String beanName,Object... args){
        Object bean = getSingleton(beanName);
        if(bean != null)
            return bean;
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return createBean(beanName,beanDefinition,args);
    }

    protected  abstract BeanDefinition getBeanDefinition(String beanName) throws BeanException;

    protected  abstract Object createBean(String beanName,BeanDefinition beanDefinition,Object[] args) throws BeanException;
}
