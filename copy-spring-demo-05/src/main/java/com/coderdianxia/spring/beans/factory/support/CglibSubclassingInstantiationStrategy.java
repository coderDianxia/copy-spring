package com.coderdianxia.spring.beans.factory.support;

import com.coderdianxia.spring.beans.factory.BeanException;
import com.coderdianxia.spring.beans.factory.config.BeanDefinition;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

/**
 * @ClassName: CglibSubclassingInstantiationStrategy
 * @Description: cglib实现bean的实例化
 * @Author: coderDianxia
 * @Date: 2022/5/10 16:57
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy {

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beaName, Constructor cot, Object[] args) throws BeanException {

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBean());

        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        if (cot == null)
            return enhancer.create();
        return enhancer.create(cot.getParameterTypes(),args);
    }
}
