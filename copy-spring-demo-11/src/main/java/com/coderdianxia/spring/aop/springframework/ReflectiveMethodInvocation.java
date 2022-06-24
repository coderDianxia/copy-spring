package com.coderdianxia.spring.aop.springframework;

import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

/**
 * @ClassName: ReflectiveMethodInvocation
 * @Description:TODO
 * @Author:coderDianxia
 * @Date: 2022/5/24 9:19
 */
public class ReflectiveMethodInvocation implements MethodInvocation {

    protected Method method;

    protected Object[] args;

    protected Object targetObject;

    public ReflectiveMethodInvocation(Object targetObject, Method method, Object[] args) {
        this.targetObject = targetObject;
        this.method = method;
        this.args = args;
    }
    @Override
    public Method getMethod() {
        return method;
    }

    @Override
    public Object[] getArguments() {
        return args;
    }

    @Override
    public Object proceed() throws Throwable {
        return method.invoke(targetObject, args);
    }

    @Override
    public Object getThis() {
        return targetObject;
    }

    @Override
    public AccessibleObject getStaticPart() {
        return method;
    }
}
