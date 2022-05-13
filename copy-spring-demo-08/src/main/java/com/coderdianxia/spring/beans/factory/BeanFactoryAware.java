package com.coderdianxia.spring.beans.factory;

/**
 * @ClassName: BeanFactoryAware
 * @Description:TODO
 * @Author:coderDianxia
 * @Date: 2022/5/13 16:49
 */
public interface BeanFactoryAware extends Aware{

    void setBeanFactory(BeanFactory beanFactory) throws BeanException;
}
