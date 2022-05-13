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


    public void initMethod(){
        userInfo.put("1","张三");
        userInfo.put("2","李四");
        userInfo.put("3","王五");
    }

    public void destroyMethod() {
        System.out.println("UserDao.destroyMethod======== ");
    }

    public String queryUserName(String id){
        if(StrUtil.isNotBlank(id))
            return userInfo.get(id);
        return userInfo.get(2);
    }
}
