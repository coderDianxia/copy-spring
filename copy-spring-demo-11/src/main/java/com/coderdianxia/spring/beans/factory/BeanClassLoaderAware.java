package com.coderdianxia.spring.beans.factory;

/**
 * @ClassName: BeanClassLoaderAware
 * @Description:TODO
 * @Author:coderDianxia
 * @Date: 2022/5/13 16:50
 */
public interface BeanClassLoaderAware extends Aware{

    void setBeanClassLoader(ClassLoader classLoader);
}
