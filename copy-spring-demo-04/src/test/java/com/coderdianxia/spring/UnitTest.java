package com.coderdianxia.spring;

import com.coderdianxia.spring.beans.PropertyValue;
import com.coderdianxia.spring.beans.PropertyValues;
import com.coderdianxia.spring.beans.factory.config.BeanDefinition;
import com.coderdianxia.spring.beans.factory.config.BeanReference;
import com.coderdianxia.spring.beans.factory.support.DefaultListableBeanFactory;
import com.coderdianxia.spring.service.UserDao;
import com.coderdianxia.spring.service.UserService;
import org.junit.Test;

import java.time.LocalDate;

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

        // UserDao 注册
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        //设置UserService属性
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("id","1"));
        propertyValues.addPropertyValue(new PropertyValue("sex","男"));
        propertyValues.addPropertyValue(new PropertyValue("birth", LocalDate.now()));
        propertyValues.addPropertyValue(new PropertyValue("tel", new String[]{"14782945621","15298672312"}));
        propertyValues.addPropertyValue(new PropertyValue("sex","男"));
        propertyValues.addPropertyValue(new PropertyValue("userDao",new BeanReference("userDao")));
        //注册bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class,propertyValues);
        beanFactory.registerBeanDefinition("userService",beanDefinition);

        //获取bean
        UserService userService1 = (UserService)beanFactory.getBean("userService");
        System.out.println(userService1.toString());
        System.out.println(userService1.queryUserName());

    }
}
