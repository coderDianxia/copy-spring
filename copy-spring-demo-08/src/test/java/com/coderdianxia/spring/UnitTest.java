package com.coderdianxia.spring;

import cn.hutool.core.io.IoUtil;
import com.coderdianxia.spring.beans.PropertyValue;
import com.coderdianxia.spring.beans.PropertyValues;
import com.coderdianxia.spring.beans.factory.config.BeanDefinition;
import com.coderdianxia.spring.beans.factory.config.BeanReference;
import com.coderdianxia.spring.beans.factory.support.DefaultListableBeanFactory;
import com.coderdianxia.spring.beans.factory.xml.XmlBeanDefinitionReader;
import com.coderdianxia.spring.context.support.ClassPathXmlApplicationContext;
import com.coderdianxia.spring.core.io.DefaultResourceLoader;
import com.coderdianxia.spring.core.io.Resource;
import com.coderdianxia.spring.core.io.ResourceLoader;
import com.coderdianxia.spring.service.CustomBeanPostProcessor;
import com.coderdianxia.spring.service.CustomFactoryPostProcessor;
import com.coderdianxia.spring.service.UserDao;
import com.coderdianxia.spring.service.UserService;
import com.coderdianxia.spring.util.ClassUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;

/**
 * @ClassName: test
 * @Description:TODO
 * @Author: coderDianxia
 * @Date: 2022/5/10 14:48
 * Create by coderDianxia
 */
public class UnitTest {


    /**
     * 使用上下文 ，完成容器的创建，bean定义加载，注册，beanfactory定义修改，bean实例化后的修改
     */
    @Test
    public void test_xml() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();
        // 2. 获取Bean对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.queryUserName();
        System.out.println("测试结果：" + userService);
    }
}
