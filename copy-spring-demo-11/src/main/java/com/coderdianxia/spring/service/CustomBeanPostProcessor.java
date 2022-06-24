package com.coderdianxia.spring.service;

import com.coderdianxia.spring.beans.factory.BeanException;
import com.coderdianxia.spring.beans.factory.config.BeanPostProcessor;

/**
 * @ClassName: CustomBeanPostProcessor
 * @Description:TODO
 * @Author:coderDianxia
 * @Date: 2022/5/13 11:57
 */
public class CustomBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeanException {
        if ("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            userService.setName("改变为:xiao");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeanException {
        return bean;
    }
}
