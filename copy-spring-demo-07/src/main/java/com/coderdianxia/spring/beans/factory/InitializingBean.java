package com.coderdianxia.spring.beans.factory;

/**
 * @ClassName: InitializingBean
 * @Description:TODO
 * @Author:coderDianxia
 * @Date: 2022/5/13 15:18
 */
public interface InitializingBean {

    /**
     * 在bean实例化填充属性后调用
     * @throws BeanException
     */
    public void afterPropertiesSet() throws BeanException;
}
