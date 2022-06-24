package com.coderdianxia.spring;

import cn.hutool.core.io.IoUtil;
import com.coderdianxia.spring.aop.AdvisedSupport;
import com.coderdianxia.spring.aop.TargetSource;
import com.coderdianxia.spring.aop.apectj.AspectJExpressionPointcut;
import com.coderdianxia.spring.aop.springframework.Cglib2AopProxy;
import com.coderdianxia.spring.aop.springframework.JdkDynamicAopProxy;
import com.coderdianxia.spring.aop.springframework.ReflectiveMethodInvocation;
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
import net.sf.cglib.proxy.MethodProxy;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
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
    public void testProxy() {
        Object userService = new UserService();

        IUserService o = (IUserService)Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), userService.getClass().getInterfaces(), new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if(method.getName().equals("hello")) {
                    MethodInterceptor methodInterceptor = new MethodInterceptor() {
                        @Override
                        public Object invoke(MethodInvocation methodInvocation) throws Throwable {
                            long start = System.currentTimeMillis();
                            try {
                                return methodInvocation.proceed();
                            } finally {
                                System.out.println("监控 - Begin By AOP");
                                System.out.println("方法名称：" + methodInvocation.getMethod().getName());
                                System.out.println("方法耗时：" + (System.currentTimeMillis() - start) + "ms");
                                System.out.println("监控 - End\r\n");
                            }
                        }
                    };

                    return methodInterceptor.invoke(new ReflectiveMethodInvocation(userService,method,args));

                }
                return method.invoke(userService,args);
            }
        });


        String hello = o.hello();
        System.out.println(hello);
    }

    @Test
    public void testAop() throws NoSuchMethodException {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut("execution(* com.coderdianxia.spring.service.UserService.*(..))");
        Class<UserService> clazz = UserService.class;
        Method method = clazz.getDeclaredMethod("hello");

        System.out.println(pointcut.match(clazz));
        System.out.println(pointcut.matches(method, clazz));
    }

    @Test
    public void  testDynamic(){
        UserService target = new UserService();

        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setTargetSource(new TargetSource(target));
        advisedSupport.setMethodInterceptor(new UserServiceMethodInterceptor());
        advisedSupport.setMethodMatcher(new AspectJExpressionPointcut("execution(* com.coderdianxia.spring.service.UserService.*(..))"));

        // 代理对象(JdkDynamicAopProxy)
        IUserService proxy_jdk = (IUserService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        // 测试调用
        System.out.println("测试结果：" + proxy_jdk.hello());

        // 代理对象(Cglib2AopProxy)
        IUserService proxy_cglib = (IUserService) new Cglib2AopProxy(advisedSupport).getProxy();
        // 测试调用
        System.out.println("测试结果：" + proxy_cglib.getUsernameById("张三"));
    }

}
