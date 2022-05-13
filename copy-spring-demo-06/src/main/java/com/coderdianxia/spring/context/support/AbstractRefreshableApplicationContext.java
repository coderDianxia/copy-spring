package com.coderdianxia.spring.context.support;

import com.coderdianxia.spring.beans.factory.BeanException;
import com.coderdianxia.spring.beans.factory.ConfigurableListableBeanFactory;
import com.coderdianxia.spring.beans.factory.support.DefaultListableBeanFactory;

import java.util.Map;

/**
 * @ClassName: AbstractRefreshableApplicationContext
 * @Description:TODO
 * @Author:coderDianxia
 * @Date: 2022/5/13 11:07
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext{

    private DefaultListableBeanFactory beanFactory;


    @Override
    protected void refreshBeanFactory() throws BeanException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}
