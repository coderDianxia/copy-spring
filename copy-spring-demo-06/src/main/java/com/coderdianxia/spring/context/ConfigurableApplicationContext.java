package com.coderdianxia.spring.context;

import com.coderdianxia.spring.beans.factory.BeanException;
import com.coderdianxia.spring.beans.factory.config.BeanPostProcessor;

import java.beans.Beans;

/**
 * @ClassName: ConfigurableApplicationContext
 * @Description:TODO
 * @Author:coderDianxia
 * @Date: 2022/5/13 10:38
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    public void refresh() throws BeanException; //刷新容器

}
