package com.coderdianxia.spring;

import com.coderdianxia.spring.framework.BeanDefinition;
import com.coderdianxia.spring.framework.BeanFactory;
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
    public void test(){
        //初始化bean工厂
        BeanFactory beanFactory = new BeanFactory();

        //注册bean
        UserService userService = new UserService();
        BeanDefinition beanDefinition = new BeanDefinition(userService);

        beanFactory.registerBeanDefinition("userService",beanDefinition);

        //获取bean
        UserService userService1 = (UserService) beanFactory.getBean("userService");
        userService1.hello();
    }
}
