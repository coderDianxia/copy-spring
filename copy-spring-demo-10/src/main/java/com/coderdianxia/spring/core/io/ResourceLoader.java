package com.coderdianxia.spring.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName: ResourceLoader
 * @Description:TODO
 * @Author: coderDianxia
 * @Date: 2022/5/11 11:07
 * Create by coderDianxia
 */
public interface ResourceLoader {

    public static  String CLASS_PATH_PREFIX = "classpath:";

    public Resource getResource(String location);
}
