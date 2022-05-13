package com.coderdianxia.spring.beans.factory.config;

import com.coderdianxia.spring.beans.factory.HierarchicalBeanFactory;

/**
 * @ClassName: ConfigurableBeanFactory
 * @Description:TODO
 * @Author:coderDianxia
 * @Date: 2022/5/13 11:41
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

}

