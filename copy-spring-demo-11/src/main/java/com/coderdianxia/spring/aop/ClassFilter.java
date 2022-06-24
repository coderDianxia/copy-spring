package com.coderdianxia.spring.aop;

/**
 * @ClassName: ClassFilter
 * @Description:切点找到给定的接口和目标类
 * @Author:coderDianxia
 * @Date: 2022/5/24 9:27
 */
public interface ClassFilter {

    public boolean match(Class<?> clazz);
}
