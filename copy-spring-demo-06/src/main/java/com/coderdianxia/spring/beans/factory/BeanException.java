package com.coderdianxia.spring.beans.factory;

/**
 * @ClassName: BeanException
 * @Description:定义Bean异常
 * @Author: coderDianxia
 * @Date: 2022/5/10 15:25
 */
public class BeanException extends RuntimeException {

    public BeanException(String msg) {
        super(msg);
    }

    public BeanException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
