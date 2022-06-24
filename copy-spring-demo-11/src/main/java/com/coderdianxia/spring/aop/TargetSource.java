package com.coderdianxia.spring.aop;

/**
 * @ClassName: TargetSource
 * @Description:TODO
 * @Author:coderDianxia
 * @Date: 2022/5/24 9:42
 */
public class TargetSource {

    private final Object target;

    public TargetSource(Object target) {
        this.target = target;
    }

    public Class<?>[] getTargetClass(){
        return this.target.getClass().getInterfaces();
    }
    
    public Object getTarget(){
        return this.target;
    }
}
