package com.coderdianxia.spring.aop;

import lombok.Data;
import org.aopalliance.intercept.MethodInterceptor;

/**
 * @ClassName: AdvisedSupport
 * @Description:TODO
 * @Author:coderDianxia
 * @Date: 2022/5/24 9:42
 */
@Data
public class AdvisedSupport {

    // 被代理的目标对象
    private TargetSource targetSource;
    // 方法拦截器
    private MethodInterceptor methodInterceptor;
    // 方法匹配器(检查目标方法是否符合通知条件)
    private MethodMatcher methodMatcher;
}
