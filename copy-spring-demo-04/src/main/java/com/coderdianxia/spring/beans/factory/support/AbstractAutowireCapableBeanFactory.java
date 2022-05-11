package com.coderdianxia.spring.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.coderdianxia.spring.beans.PropertyValue;
import com.coderdianxia.spring.beans.PropertyValues;
import com.coderdianxia.spring.beans.factory.BeanException;
import com.coderdianxia.spring.beans.factory.config.BeanDefinition;
import com.coderdianxia.spring.beans.factory.config.BeanReference;

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
        //填充bean属性
        applyPropertyValues(beanName,beanDefinition,bean);
        addSingletonObject(beanName,bean);
        return bean;
    }

    private void applyPropertyValues(String beanName, BeanDefinition beanDefinition, Object bean) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue: propertyValues.getPropertyValues()) {
                //获取name
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();

                if(value instanceof BeanReference)
                {
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                BeanUtil.setFieldValue(bean,name,value);
            }
        }catch (Exception e){
            throw new BeanException("错误设置属性值"+beanName);
        }

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
