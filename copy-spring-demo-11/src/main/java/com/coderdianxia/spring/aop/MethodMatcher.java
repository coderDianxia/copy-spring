package com.coderdianxia.spring.aop;

import java.lang.reflect.Method;

/**
 * @ClassName: MethodMatcher
 * @Description:找到表达式范围内匹配下的目标类和方法
 * @Author:coderDianxia
 * @Date: 2022/5/24 9:28
 */
public interface MethodMatcher {

    boolean matches(Method method, Class<?> targetClass);
}
