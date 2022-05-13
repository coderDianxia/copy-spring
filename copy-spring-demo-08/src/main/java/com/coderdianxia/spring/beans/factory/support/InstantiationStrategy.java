package com.coderdianxia.spring.beans.factory.support;

import com.coderdianxia.spring.beans.factory.BeanException;
import com.coderdianxia.spring.beans.factory.BeanFactory;
import com.coderdianxia.spring.beans.factory.config.BeanDefinition;
import com.sun.istack.internal.Nullable;

import java.lang.reflect.Constructor;

/**
 * @ClassName: InstantiationStrategy
 * @Description: bean实例化策略
 * @Author: coderDianxia
 * @Date: 2022/5/10 16:53
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beaName, Constructor cot, Object[]args) throws BeanException;
}
