package com.coderdianxia.spring.service;

import lombok.*;

import java.time.LocalDate;

/**
 * @ClassName: UserService
 * @Description:TODO
 * @Author: coderDianxia
 * @Date: 2022/5/10 14:49
 */
@Data
@EqualsAndHashCode
@AllArgsConstructor
public class UserService {

    private String id;

    private String name;

    private String sex;

    private LocalDate birth;

    private String[] tel;

    private UserDao userDao;

    public UserService() {
    }

    public UserService(String id){
        this.id=id;
    }

    public void hello(){
        System.out.println("hello=====");
    }

    public String queryUserName(){
        return userDao.queryUserName(id);
    }

}
