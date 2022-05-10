package com.coderdianxia.spring.beans.factory.config;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ClassName: BeanDefinition
 * @Description:bean定义
 * @Author: coderDianxia
 * @Date: 2022/5/10 15:09
 */
@Data
@AllArgsConstructor
public class BeanDefinition {

    private Class bean;
}
