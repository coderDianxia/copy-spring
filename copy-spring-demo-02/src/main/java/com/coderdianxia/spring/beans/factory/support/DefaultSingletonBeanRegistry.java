package com.coderdianxia.spring.beans.factory.support;

import com.coderdianxia.spring.beans.factory.config.BeanDefinition;
import com.coderdianxia.spring.beans.factory.config.SingletonBeanRegistry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName: DefaultSingletonBeanRegistry
 * @Description:TODO
 * @Author: coderDianxia
 * @Date: 2022/5/10 15:16
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String, Object> singletonObjects = new ConcurrentHashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    protected void addSingletonObject(String beanName,Object bean)  {
        singletonObjects.put(beanName,bean);
    }
}
