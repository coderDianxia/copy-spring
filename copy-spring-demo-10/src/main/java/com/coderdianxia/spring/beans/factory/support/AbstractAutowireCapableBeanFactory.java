package com.coderdianxia.spring.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.coderdianxia.spring.beans.PropertyValue;
import com.coderdianxia.spring.beans.PropertyValues;
import com.coderdianxia.spring.beans.factory.*;
import com.coderdianxia.spring.beans.factory.config.AutowireCapableBeanFactory;
import com.coderdianxia.spring.beans.factory.config.BeanDefinition;
import com.coderdianxia.spring.beans.factory.config.BeanPostProcessor;
import com.coderdianxia.spring.beans.factory.config.BeanReference;
import com.coderdianxia.spring.util.ClassUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName: AbstractAutowireCapableBeanFactory
 * @Description:TODO
 * @Author: coderDianxia
 * @Date: 2022/5/10 15:35
 */
public abstract  class AbstractAutowireCapableBeanFactory extends  AbstractBeanFactory implements AutowireCapableBeanFactory {

    private InstantiationStrategy instantiationStrategy =new CglibSubclassingInstantiationStrategy();

    private ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition,Object[] args) throws BeanException {

        Object bean = instantiationBean(beanName,beanDefinition,args);
        //填充bean属性
        applyPropertyValues(beanName,beanDefinition,bean);

        // 执行 Bean 的初始化方法和 BeanPostProcessor 的前置和后置处理方法
        bean = initializeBean(beanName, bean, beanDefinition);

        // 注册实现了 DisposableBean 接口的 Bean 对象
        registerDisposableBeanIfNecessary(beanName, bean, beanDefinition);

        if(beanDefinition.isSingleton())
            addSingletonObject(beanName,bean);
        return bean;
    }

    private void registerDisposableBeanIfNecessary(String beanName, Object bean, BeanDefinition beanDefinition) {
        // 非 Singleton 类型的 Bean 不执行销毁方法
        if (!beanDefinition.isSingleton()) return;

        if(bean instanceof DisposableBean || StrUtil.isNotBlank(beanDefinition.getDestroyMethodName()))
            registerDisposableBean(beanName,new DisposableBeanAdapter(bean,beanName,beanDefinition));
    }

    private void applyPropertyValues(String beanName, BeanDefinition beanDefinition, Object bean) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue: propertyValues.getPropertyValues()) {
                //获取name
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();

                if(value instanceof BeanReference)
                {
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                BeanUtil.setFieldValue(bean,name,value);
            }
        }catch (Exception e){
            throw new BeanException("错误设置属性值"+beanName);
        }

    }

    private Object instantiationBean(String beanName, BeanDefinition beanDefinition,Object[] args) {

        Class aClass = beanDefinition.getBean();

        Constructor cot = null;

        Constructor[] declaredConstructors = aClass.getDeclaredConstructors();
        for (Constructor constructor: declaredConstructors) {
            if(args != null && constructor.getParameterTypes().length==args.length){
                cot = constructor;
                break;
            }
        }
        return instantiationStrategy.instantiate(beanDefinition,beanName,cot,args);
    }

    private Object initializeBean(String beanName, Object bean, BeanDefinition beanDefinition) {

        if (bean instanceof Aware) {
            if (bean instanceof BeanFactoryAware) {
                ((BeanFactoryAware) bean).setBeanFactory(this);
            }
            if (bean instanceof BeanClassLoaderAware){
                ((BeanClassLoaderAware) bean).setBeanClassLoader(getBeanClassLoader());
            }
            if (bean instanceof BeanNameAware) {
                ((BeanNameAware) bean).setBeanName(beanName);
            }
        }

        // 1. 执行 BeanPostProcessor Before 处理
        Object wrappedBean = applyBeanPostProcessorsBeforeInitialization(bean, beanName);

        // 待完成内容：invokeInitMethods(beanName, wrappedBean, beanDefinition);
        // 执行 Bean 对象的初始化方法
        try {
            invokeInitMethods(beanName, wrappedBean, beanDefinition);
        } catch (Exception e) {
            throw new BeanException("Invocation of init method of bean[" + beanName + "] failed", e);
        }

        // 2. 执行 BeanPostProcessor After 处理
        wrappedBean = applyBeanPostProcessorsAfterInitialization(bean, beanName);
        return wrappedBean;
    }

    private void invokeInitMethods(String beanName, Object wrappedBean, BeanDefinition beanDefinition) throws Exception {
        // 1. 实现接口 InitializingBean
        if (wrappedBean instanceof InitializingBean) {
            ((InitializingBean) wrappedBean).afterPropertiesSet();
        }

        // 2. 配置信息 init-method {判断是为了避免二次执行销毁}
        String initMethodName = beanDefinition.getInitMethodName();
        if (StrUtil.isNotEmpty(initMethodName)) {
            Method initMethod = beanDefinition.getBean().getMethod(initMethodName);
            if (null == initMethod) {
                throw new BeanException("Could not find an init method named '" + initMethodName + "' on bean with name '" + beanName + "'");
            }
            initMethod.invoke(wrappedBean);
        }
    }

    @Override
    public Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeanException {
        Object result = existingBean;
        for (BeanPostProcessor processor : getBeanPostProcessors()) {
            Object current = processor.postProcessBeforeInitialization(result, beanName);
            if (null == current) return result;
            result = current;
        }
        return result;
    }

    @Override
    public Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeanException {
        Object result = existingBean;
        for (BeanPostProcessor processor : getBeanPostProcessors()) {
            Object current = processor.postProcessAfterInitialization(result, beanName);
            if (null == current) return result;
            result = current;
        }
        return result;
    }

    public ClassLoader getBeanClassLoader() {
        return this.beanClassLoader;
    }
}
