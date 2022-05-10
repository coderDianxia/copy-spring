package com.coderdianxia.spring.service;

import lombok.Data;

/**
 * @ClassName: UserService
 * @Description:TODO
 * @Author: coderDianxia
 * @Date: 2022/5/10 14:49
 * Create by coderDianxia
 */
@Data
public class UserService {

    private String name;

    private String sex;

    public void hello(){
        System.out.println("hello=====");
    }
}
