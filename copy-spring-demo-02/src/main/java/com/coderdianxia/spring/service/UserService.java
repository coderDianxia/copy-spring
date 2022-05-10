package com.coderdianxia.spring.service;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @ClassName: UserService
 * @Description:TODO
 * @Author: coderDianxia
 * @Date: 2022/5/10 14:49
 */
@Data
@EqualsAndHashCode
public class UserService {

    private String name;

    private String sex;

    public void hello(){
        System.out.println("hello=====");
    }
}
