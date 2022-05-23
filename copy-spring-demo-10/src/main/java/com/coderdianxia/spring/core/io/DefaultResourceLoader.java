package com.coderdianxia.spring.core.io;

import cn.hutool.core.lang.Assert;

import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static sun.plugin.javascript.navig.JSType.Location;

/**
 * @ClassName: DefaultResourceLoader
 * @Description:TODO
 * @Author: coderDianxia
 * @Date: 2022/5/11 11:09
 */
public class DefaultResourceLoader implements ResourceLoader{

    @Override
    public Resource getResource(String location) {
        Assert.notNull(location, "location 不能为空");
        try {
            if(location.startsWith(CLASS_PATH_PREFIX))
                return new ClassPathResource(location.substring(CLASS_PATH_PREFIX.length()));
            else {
                URL url = new URL(location);
                return new UrlResource(url);
            }
        } catch (MalformedURLException e) {
            return new FileSystemResource(location);
        }

    }
}
