package com.coderdianxia.spring.beans.factory;

import com.coderdianxia.spring.beans.factory.config.AutowireCapableBeanFactory;
import com.coderdianxia.spring.beans.factory.config.BeanDefinition;
import com.coderdianxia.spring.beans.factory.config.BeanPostProcessor;
import com.coderdianxia.spring.beans.factory.config.ConfigurableBeanFactory;

/**
 * @ClassName: ConfigurableListableBeanFactory
 * @Description:TODO
 * @Author:coderDianxia
 * @Date: 2022/5/13 10:28
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeanException;

    void preInstantiateSingletons() throws BeanException;

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

}
