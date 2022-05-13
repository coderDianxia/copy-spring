package com.coderdianxia.spring.context.support;

import com.coderdianxia.spring.beans.factory.BeanException;

import java.util.Map;

/**
 * @ClassName: ClassPathXmlApplicationContext
 * @Description:TODO
 * @Author:coderDianxia
 * @Date: 2022/5/13 11:21
 */
public class ClassPathXmlApplicationContext  extends AbstractXmlApplicationContext{
    
    private String[] configLocations;

    public ClassPathXmlApplicationContext() {
    }

    /**
     * 从 XML 中加载 BeanDefinition，并刷新上下文
     *
     * @param configLocations
     * @throws BeanException
     */
    public ClassPathXmlApplicationContext(String configLocations) throws BeanException {
        this(new String[]{configLocations});
    }

    /**
     * 从 XML 中加载 BeanDefinition，并刷新上下文
     * @param configLocations
     * @throws BeanException
     */
    public ClassPathXmlApplicationContext(String[] configLocations) throws BeanException {
        this.configLocations = configLocations;
        refresh();
    }

    @Override
    protected String[] getConfigLocations() {
        return configLocations;
    }

    @Override
    public Object getBean(String beanName) throws BeanException {
        return getBeanFactory().getBean(beanName);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeanException {
        return getBeanFactory().getBean(name,args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeanException {
        return getBeanFactory().getBean(name,requiredType);
    }
}
