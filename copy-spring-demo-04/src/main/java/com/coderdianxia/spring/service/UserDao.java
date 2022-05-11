package com.coderdianxia.spring.service;

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

    static {
        userInfo.put("1","张三");
        userInfo.put("2","李四");
        userInfo.put("3","王五");
    }

    public String queryUserName(String id){
        return userInfo.get(id);
    }
}
