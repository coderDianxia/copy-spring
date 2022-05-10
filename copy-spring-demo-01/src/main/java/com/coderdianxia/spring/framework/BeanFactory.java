package com.coderdianxia.spring.framework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName: BeanFactory
 * @Description: Bean工厂
 * @Author: coderDianxia
 * @Date: 2022/5/10 14:44
 * Create by coderDianxia
 */
public class BeanFactory {

    private Map<String,BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    public Object getBean(String beanName){
        return beanDefinitionMap.get(beanName).getBean();
    }

    public void registerBeanDefinition(String beanName,BeanDefinition beanDefinition){
        beanDefinitionMap.put(beanName,beanDefinition);
    }
}
