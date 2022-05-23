package com.coderdianxia.spring.core.io;

import java.io.InputStream;

/**
 * @ClassName: Resource
 * @Description:TODO
 * @Author: coderDianxia
 * @Date: 2022/5/11 10:47
 * Create by coderDianxia
 */
public interface Resource {

    public InputStream getInputStream() throws Exception;
}
