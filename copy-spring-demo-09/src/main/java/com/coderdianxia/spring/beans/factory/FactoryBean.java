package com.coderdianxia.spring.beans.factory;

/**
 * @ClassName: FactoryBean
 * @Description:TODO
 * @Author:coderDianxia
 * @Date: 2022/5/16 9:14
 */
public interface FactoryBean<T> {

    T getObject() throws Exception;

    Class<?> getObjectType();

    boolean isSingleton();
}
