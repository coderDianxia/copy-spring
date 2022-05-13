package com.coderdianxia.spring.service;

import com.coderdianxia.spring.beans.factory.BeanException;
import com.coderdianxia.spring.beans.factory.DisposableBean;
import com.coderdianxia.spring.beans.factory.InitializingBean;
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
public class UserService implements InitializingBean, DisposableBean {

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

    @Override
    public void destroy() throws Exception {
        System.out.println("UserService destory");
    }

    @Override
    public void afterPropertiesSet() throws BeanException {
        System.out.println("UserService afterPropertiesSet");
    }
}
