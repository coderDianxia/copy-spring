package com.coderdianxia.spring.service;

import com.coderdianxia.spring.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: UserDaoFactoryBean
 * @Description:TODO
 * @Author:coderDianxia
 * @Date: 2022/5/16 9:29
 */
public class UserDaoFactoryBean implements FactoryBean<UserDao> {


    @Override
    public UserDao getObject() throws Exception {
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Map<String, String> hashMap = new HashMap<>();
                hashMap.put("1", "张三");
                hashMap.put("2", "李四");
                hashMap.put("3", "王五");

                return "你被代理了 " + method.getName() + "：" + hashMap.get(args[0].toString());
            }
        };
        return (UserDao)Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{UserDao.class}, handler);
    }

    @Override
    public Class<?> getObjectType() {
        return UserDao.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
