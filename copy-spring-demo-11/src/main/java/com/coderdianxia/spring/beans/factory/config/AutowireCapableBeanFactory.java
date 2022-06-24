package com.coderdianxia.spring.beans.factory.config;

import com.coderdianxia.spring.beans.factory.BeanException;
import com.coderdianxia.spring.beans.factory.BeanFactory;

/**
 * @ClassName: AutowireCapableBeanFactory
 * @Description:TODO
 * @Author:coderDianxia
 * @Date: 2022/5/13 11:52
 */
public interface AutowireCapableBeanFactory extends BeanFactory {

    /**
     * 执行 BeanPostProcessors 接口实现类的 postProcessBeforeInitialization 方法
     *
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeanException
     */
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeanException;

    /**
     * 执行 BeanPostProcessors 接口实现类的 postProcessorsAfterInitialization 方法
     *
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeanException
     */
    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeanException;
}
