package com.coderdianxia.spring.beans.factory.support;

import com.coderdianxia.spring.beans.factory.BeanException;
import com.coderdianxia.spring.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @ClassName: AbstractAutowireCapableBeanFactory
 * @Description:TODO
 * @Author: coderDianxia
 * @Date: 2022/5/10 15:35
 */
public abstract  class AbstractAutowireCapableBeanFactory extends  AbstractBeanFactory{

    private InstantiationStrategy instantiationStrategy =new CglibSubclassingInstantiationStrategy();
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition,Object[] args) throws BeanException {

        Object bean = instantiationBean(beanName,beanDefinition,args);

        addSingletonObject(beanName,bean);
        return bean;
    }

    private Object instantiationBean(String beanName, BeanDefinition beanDefinition,Object[] args) {

        Class aClass = beanDefinition.getBean();

        Constructor cot = null;

        Constructor[] declaredConstructors = aClass.getDeclaredConstructors();
        for (Constructor constructor: declaredConstructors) {
            if(args != null && constructor.getParameterTypes().length==args.length){
                cot = constructor;
                break;
            }
        }
        return instantiationStrategy.instantiate(beanDefinition,beanName,cot,args);
    }
}
