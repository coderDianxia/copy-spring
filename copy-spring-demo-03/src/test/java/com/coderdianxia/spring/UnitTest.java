package com.coderdianxia.spring;

import com.coderdianxia.spring.beans.factory.config.BeanDefinition;
import com.coderdianxia.spring.beans.factory.support.DefaultListableBeanFactory;
import com.coderdianxia.spring.service.UserService;
import org.junit.Test;

/**
 * @ClassName: test
 * @Description:TODO
 * @Author: coderDianxia
 * @Date: 2022/5/10 14:48
 * Create by coderDianxia
 */
public class UnitTest {

    @org.junit.Test
    public void testBeanFactory(){
        //初始化bean工厂
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //注册bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService",beanDefinition);

        //获取bean
        UserService userService1 = (UserService)beanFactory.getBean("userService","dd");
        int i = userService1.hashCode();

    }
}
