package com.coderdianxia.spring.beans.factory;

/**
 * @ClassName: BeanFactory
 * @Description:TODO
 * @Author: coderDianxia
 * @Date: 2022/5/10 15:12
 */
public interface BeanFactory {
    Object getBean(String beanName) throws BeanException;

    Object getBean(String name, Object... args) throws BeanException;
}
