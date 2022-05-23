package com.coderdianxia.spring.beans.factory.config;

import com.coderdianxia.spring.beans.factory.BeanException;
import com.coderdianxia.spring.beans.factory.ConfigurableListableBeanFactory;

/**
 * @ClassName: BeanFactoryPostProcessor
 * @Description:TODO
 * @Author: coderDianxia
 * @Date: 2022/5/13 10:23
 */
public interface BeanFactoryPostProcessor {

    /**
     * 在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
     *
     * @param beanFactory
     * @throws BeanException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeanException;
}
