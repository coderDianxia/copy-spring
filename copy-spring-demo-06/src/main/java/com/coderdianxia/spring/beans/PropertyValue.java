package com.coderdianxia.spring.beans;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ClassName: PropertyValue
 * @Description:属性值
 * @Author: coderDianxia
 * @Date: 2022/5/11 9:23
 * Create by coderDianxia
 */
@Data
@AllArgsConstructor
public class PropertyValue {

    private String name;

    private Object value;
}
