package com.coderdianxia.spring.service;

import com.coderdianxia.spring.beans.PropertyValue;
import com.coderdianxia.spring.beans.PropertyValues;
import com.coderdianxia.spring.beans.factory.BeanException;
import com.coderdianxia.spring.beans.factory.ConfigurableListableBeanFactory;
import com.coderdianxia.spring.beans.factory.config.BeanDefinition;
import com.coderdianxia.spring.beans.factory.config.BeanFactoryPostProcessor;

/**
 * @ClassName: CustomFactoryPostProcessor
 * @Description:TODO
 * @Author:coderDianxia
 * @Date: 2022/5/13 11:55
 */
public class CustomFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeanException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("sex", "变更为女性"));
    }
}
