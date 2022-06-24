package com.coderdianxia.spring.beans.factory.support;

import com.coderdianxia.spring.beans.factory.BeanException;
import com.coderdianxia.spring.beans.factory.BeanFactory;
import com.coderdianxia.spring.beans.factory.FactoryBean;
import com.coderdianxia.spring.beans.factory.config.BeanDefinition;
import com.coderdianxia.spring.beans.factory.config.BeanPostProcessor;
import com.coderdianxia.spring.beans.factory.config.ConfigurableBeanFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: AbstractBeanFactory
 * @Author: coderDianxia
 * @Date: 2022/5/10 15:28
 */
public abstract class AbstractBeanFactory extends FactoryBeanRegistrySupport  implements ConfigurableBeanFactory {

    /** BeanPostProcessors to apply in createBean */
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();

    @Override
    public Object getBean(String beanName) throws BeanException {

        return doGetBean(beanName,null);
    }

    @Override
    public Object getBean(String beanName, Object... args) throws BeanException {

        return doGetBean(beanName,args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeanException {
        return (T) getBean(name);
    }

    protected <T> T  doGetBean(String beanName, Object... args){
        Object singleton = getSingleton(beanName);
        if(singleton != null)
            return (T)getObjectForBeanInstance(singleton,beanName);
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        Object bean = createBean(beanName, beanDefinition, args);
        return (T)getObjectForBeanInstance(bean,beanName);
    }

    /**
     * Return the list of BeanPostProcessors that will get applied
     * to beans created with this factory.
     */
    public List<BeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
    }

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor){
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    private Object getObjectForBeanInstance(Object beanInstance, String beanName) {
        if (!(beanInstance instanceof FactoryBean)) {
            return beanInstance;
        }

        Object object = getCachedObjectForFactoryBean(beanName);

        if (object == null) {
            FactoryBean<?> factoryBean = (FactoryBean<?>) beanInstance;
            object = getObjectFromFactoryBean(factoryBean, beanName);
        }

        return object;
    }

    protected  abstract BeanDefinition getBeanDefinition(String beanName) throws BeanException;

    protected  abstract Object createBean(String beanName,BeanDefinition beanDefinition,Object[] args) throws BeanException;
}
