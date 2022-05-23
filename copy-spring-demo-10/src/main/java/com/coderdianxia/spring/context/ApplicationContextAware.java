package com.coderdianxia.spring.context;

import com.coderdianxia.spring.beans.factory.Aware;
import com.coderdianxia.spring.beans.factory.BeanException;

/**
 * @ClassName: ApplicationContextAware
 * @Description:TODO
 * @Author:coderDianxia
 * @Date: 2022/5/13 16:51
 */
public interface ApplicationContextAware extends Aware{
    void setApplicationContext(ApplicationContext applicationContext) throws BeanException;
}
