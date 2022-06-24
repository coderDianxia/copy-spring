package com.coderdianxia.spring.aop;



/**
 * @ClassName: Pointcut
 * @Description:TODO
 * @Author:coderDianxia
 * @Date: 2022/5/24 9:26
 */
public interface Pointcut {

    /**
     * Return the ClassFilter for this pointcut.
     * @return the ClassFilter (never <code>null</code>)
     */
    ClassFilter getClassFilter();

    /**
     * Return the MethodMatcher for this pointcut.
     * @return the MethodMatcher (never <code>null</code>)
     */
    MethodMatcher getMethodMatcher();
}
