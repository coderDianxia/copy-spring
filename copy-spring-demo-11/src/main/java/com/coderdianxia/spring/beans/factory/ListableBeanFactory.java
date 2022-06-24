package com.coderdianxia.spring.beans.factory;

import java.util.Map;

/**
 * @ClassName: ListableBeanFactory
 * @Description:TODO
 * @Author:coderDianxia
 * @Date: 2022/5/13 10:31
 */
public interface ListableBeanFactory extends BeanFactory{
    /**
     * 按照类型返回 Bean 实例
     * @param type
     * @param <T>
     * @return
     * @throws BeanException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeanException;

    /**
     * Return the names of all beans defined in this registry.
     *
     * 返回注册表中所有的Bean名称
     */
    String[] getBeanDefinitionNames();
}
