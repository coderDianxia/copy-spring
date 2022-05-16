package com.coderdianxia.spring.beans.factory;

/**
 * @ClassName: BeanNameAware
 * @Description:TODO
 * @Author:coderDianxia
 * @Date: 2022/5/13 16:51
 */
public interface BeanNameAware extends Aware{

    public void setBeanName(String beanName);
}
