package com.coderdianxia.spring.beans.factory.support;

import com.coderdianxia.spring.beans.factory.BeanException;
import com.coderdianxia.spring.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @ClassName: SimpleInstantiationStrategy
 * @Description: 基于jdk的实例化
 * @Author: coderDianxia
 * @Date: 2022/5/10 17:03
 * Create by coderDianxia
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beaName, Constructor cot, Object[] args) throws BeanException {
        Class aClass = beanDefinition.getBean();
        try{
            if(cot == null)
                return aClass.getDeclaredConstructor().newInstance();
            else
                return aClass.getDeclaredConstructor(cot.getParameterTypes()).newInstance(args);
        }
        catch (InvocationTargetException|InstantiationException|IllegalAccessException|NoSuchMethodException e){
            throw new BeanException("实例化对象失败"+aClass.getName(),e);
        }
    }
}
