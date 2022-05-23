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
import com.coderdianxia.spring.service.*;
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


    @Test
    public void testListener() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.publish(new CustomEvent(applicationContext,12l,"哈哈哈"));

        applicationContext.registerShutdownHook();
    }
}
