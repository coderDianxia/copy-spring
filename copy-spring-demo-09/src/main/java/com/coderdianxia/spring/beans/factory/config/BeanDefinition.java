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

    String SCOPE_SINGLETON = ConfigurableBeanFactory.SCOPE_SINGLETON;

    String SCOPE_PROTOTYPE = ConfigurableBeanFactory.SCOPE_PROTOTYPE;

    private Class bean;

    private PropertyValues propertyValues;

    private String initMethodName;

    private String destroyMethodName;

    private boolean singleton = true;

    private boolean prototype = false;

    private String scope = SCOPE_SINGLETON;

    public BeanDefinition(Class bean) {
        this.bean = bean;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class bean, PropertyValues property) {
        this.bean = bean;
        this.propertyValues = property != null ? property : new PropertyValues();
    }

    public void setScope(String scope) {
        this.scope = scope;
        this.singleton = SCOPE_SINGLETON.equals(scope);
        this.prototype = SCOPE_PROTOTYPE.equals(scope);
    }
}
