package com.coderdianxia.spring;

import cn.hutool.core.io.IoUtil;
import com.coderdianxia.spring.beans.PropertyValue;
import com.coderdianxia.spring.beans.PropertyValues;
import com.coderdianxia.spring.beans.factory.config.BeanDefinition;
import com.coderdianxia.spring.beans.factory.config.BeanReference;
import com.coderdianxia.spring.beans.factory.support.DefaultListableBeanFactory;
import com.coderdianxia.spring.beans.factory.xml.XmlBeanDefinitionReader;
import com.coderdianxia.spring.core.io.DefaultResourceLoader;
import com.coderdianxia.spring.core.io.Resource;
import com.coderdianxia.spring.core.io.ResourceLoader;
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

    private ResourceLoader resourceLoader;

    @Before
    public void initResourceLoader(){
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void testClassPath() throws Exception {
        Resource resource = resourceLoader.getResource("classpath:application.yml");
        InputStream inputStream = resource.getInputStream();
        String s = IoUtil.readUtf8(inputStream);
        System.out.println(s);
    }

    @Test
    public void testFile() throws Exception {
        Resource resource = resourceLoader.getResource("src/main/resources/application.yml");
        InputStream inputStream = resource.getInputStream();
        String s = IoUtil.readUtf8(inputStream);
        System.out.println(s);
    }

    @Test
    public void testUrl() throws Exception {
        Resource resource = resourceLoader.getResource("https://github.com/fuzhengwei/small-spring/important.properties");
        InputStream inputStream = resource.getInputStream();
        String s = IoUtil.readUtf8(inputStream);
        System.out.println(s);
    }

    @Test
    public void test_xml() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 读取配置文件&注册Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        // 3. 获取Bean对象调用方法
        UserService userService = (UserService)beanFactory.getBean("userService");
        userService.hello();
    }


}
