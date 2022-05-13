package com.coderdianxia.spring.service;

import cn.hutool.core.util.StrUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: UserDao
 * @Description:TODO
 * @Author: coderDianxia
 * @Date: 2022/5/11 9:50
 */
public class UserDao {

    private static Map<String, String>  userInfo =  new HashMap<>();

    public void initDataMethod(){
        System.out.println("执行UserDao：init-method");
        userInfo.put("1", "张三");
        userInfo.put("2", "李四");
        userInfo.put("3", "王五");
    }

    public void destroyDataMethod(){
        System.out.println("执行UserDao：destroy-method");
        userInfo.clear();
    }

    public String queryUserName(String id){
        if(StrUtil.isNotBlank(id))
            return userInfo.get(id);
        return userInfo.get(2);
    }
}
