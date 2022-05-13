package com.coderdianxia.spring.beans.factory.support;

import com.coderdianxia.spring.beans.factory.config.BeanDefinition;

/**
 * @ClassName: BeanDefinitionRegistry
 * @Description:TODO
 * @Author: coderDianxia
 * @Date: 2022/5/10 15:49
 */
public interface BeanDefinitionRegistry {

    /**
     * 注册BeanDefinition
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    boolean containsBeanDefinition(String beanName);
}
