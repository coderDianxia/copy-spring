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
public interface UserDao {

    String queryUserNameById(String id);
}
