package com.coderdianxia.spring.service;

import com.coderdianxia.spring.beans.factory.*;
import com.coderdianxia.spring.context.ApplicationContext;
import com.coderdianxia.spring.context.ApplicationContextAware;
import lombok.*;

import java.time.LocalDate;

/**
 * @ClassName: UserService
 * @Description:TODO
 * @Author: coderDianxia
 * @Date: 2022/5/10 14:49
 */
@Data
@AllArgsConstructor
@ToString
public class UserService implements InitializingBean, DisposableBean, BeanNameAware, BeanClassLoaderAware, ApplicationContextAware, BeanFactoryAware {

    private String id;

    private String name;

    private String sex;

    private LocalDate birth;

    private String[] tel;

    private UserDao userDao;
    private ClassLoader classLoader;
    private BeanFactory beanFactory;
    private String beanName;
    private ApplicationContext applicationContext;

    public UserService() {
    }

    public UserService(String id){
        this.id=id;
    }

    public void hello(){
        System.out.println("hello=====");
    }

    public String queryUserName(String id){
        return userDao.queryUserNameById(id);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("UserService destory");
    }

    @Override
    public void afterPropertiesSet() throws BeanException {
        System.out.println("UserService afterPropertiesSet");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeanException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeanException {
        this.applicationContext = applicationContext;
    }
}
