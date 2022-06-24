package com.coderdianxia.spring.core.io;

import cn.hutool.core.util.ClassUtil;
import com.coderdianxia.spring.util.ClassUtils;

import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @ClassName: ClassPathResource
 * @Description:TODO
 * @Author: coderDianxia
 * @Date: 2022/5/11 10:48
 */
public class ClassPathResource implements Resource {

    private String path;

    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, (ClassLoader)null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        this.path = path;
        this.classLoader = classLoader != null?classLoader: ClassUtils.getDefaultClassLoader();
    }

    @Override
    public InputStream getInputStream() throws Exception {
        InputStream in = classLoader.getResourceAsStream(path);
        if (in == null) {
            throw new FileNotFoundException(
                    this.path + " 文件路径不存在");
        }
        return in;
    }
}
