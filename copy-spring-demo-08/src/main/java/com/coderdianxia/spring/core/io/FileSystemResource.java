package com.coderdianxia.spring.core.io;

import lombok.Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @ClassName: FileSystemResource
 * @Description:TODO
 * @Author: coderDianxia
 * @Date: 2022/5/11 10:59
 */
@Data
public class FileSystemResource implements Resource {

    private String path;
    private File file;

    public FileSystemResource(String path) {
        this.path=path;
        this.file = new File(path);

    }
    public FileSystemResource(File file) {
        this.file = file;
        this.path = file.getPath();
    }

    @Override
    public InputStream getInputStream() throws Exception {
        return new FileInputStream(file);
    }

    public String Path() {
        return  this.path;
    }
}
