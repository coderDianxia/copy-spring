package com.coderdianxia.spring.beans.factory.support;

import com.coderdianxia.spring.beans.factory.BeanException;
import com.coderdianxia.spring.core.io.DefaultResourceLoader;
import com.coderdianxia.spring.core.io.Resource;
import com.coderdianxia.spring.core.io.ResourceLoader;

/**
 * @ClassName: AbstractBeanDefinitionReader
 * @Description:TODO
 * @Author: coderDianxia
 * @Date: 2022/5/11 11:22
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    private final BeanDefinitionRegistry registry;

    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry, new DefaultResourceLoader());
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
