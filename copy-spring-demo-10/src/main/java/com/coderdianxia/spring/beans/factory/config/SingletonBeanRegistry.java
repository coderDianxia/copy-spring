package com.coderdianxia.spring.beans.factory.config;

/**
 * @ClassName: SingletonBeanRegistry
 * @Description:获取单例对象的接口
 * @Author: coderDianxia
 * @Date: 2022/5/10 15:14
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

    void registerSingleton(String beanName, Object singletonObject);
}
