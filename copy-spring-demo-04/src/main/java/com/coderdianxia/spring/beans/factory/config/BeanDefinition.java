package com.coderdianxia.spring.beans.factory.config;

import com.coderdianxia.spring.beans.PropertyValues;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: BeanDefinition
 * @Description:bean定义
 * @Author: coderDianxia
 * @Date: 2022/5/10 15:09
 */
@Data
public class BeanDefinition {

    private Class bean;

    private PropertyValues propertyValues;

    public BeanDefinition(Class bean) {
        this.bean = bean;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class bean, PropertyValues property) {
        this.bean = bean;
        this.propertyValues = property != null ? property : new PropertyValues();
    }
}
