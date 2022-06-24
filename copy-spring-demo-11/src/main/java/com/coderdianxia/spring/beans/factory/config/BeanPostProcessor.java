package com.coderdianxia.spring.beans.factory.config;

import com.coderdianxia.spring.beans.factory.BeanException;

/**
 * @ClassName: BeanPostProcessor
 * @Description:用于修改新实例化 Bean 对象的扩展点
 * @Author:coderDianxia
 * @Date: 2022/5/13 10:30
 */
public interface BeanPostProcessor {

    /**
     * 在 Bean 对象执行初始化方法之前，执行此方法
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeanException
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeanException;

    /**
     * 在 Bean 对象执行初始化方法之后，执行此方法
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeanException
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeanException;

}