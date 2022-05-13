package com.coderdianxia.spring.beans.factory;

/**
 * @ClassName: DisposableBean
 * @Description:TODO
 * @Author:coderDianxia
 * @Date: 2022/5/13 15:19
 */
public interface DisposableBean {

    public void destroy() throws Exception;
}
