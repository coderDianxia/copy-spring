package com.coderdianxia.spring.beans.factory.support;

import cn.hutool.core.util.StrUtil;
import com.coderdianxia.spring.beans.factory.BeanException;
import com.coderdianxia.spring.beans.factory.DisposableBean;
import com.coderdianxia.spring.beans.factory.config.BeanDefinition;

import java.lang.reflect.Method;

/**
 * @ClassName: DisposableBeanAdapter
 * @Description:TODO
 * @Author:coderDianxia
 * @Date: 2022/5/13 15:25
 */
public class DisposableBeanAdapter implements DisposableBean {

    private final Object bean;
    private final String beanName;
    private String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }

    @Override
    public void destroy() throws Exception {
        // 1. 实现接口 DisposableBean
        if (bean instanceof DisposableBean) {
            ((DisposableBean) bean).destroy();
        }

        // 2. 配置信息 destroy-method {判断是为了避免二次执行销毁}
        if (StrUtil.isNotEmpty(destroyMethodName) && !(bean instanceof DisposableBean && "destroy".equals(this.destroyMethodName))) {
            Method destroyMethod = bean.getClass().getMethod(destroyMethodName);
            if (null == destroyMethod) {
                throw new BeanException("Couldn't find a destroy method named '" + destroyMethodName + "' on bean with name '" + beanName + "'");
            }
            destroyMethod.invoke(bean);
        }
    }
}
