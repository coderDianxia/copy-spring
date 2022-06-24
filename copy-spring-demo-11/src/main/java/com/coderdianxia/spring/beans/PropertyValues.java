package com.coderdianxia.spring.beans;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: PropertyValues
 * @Description:TODO
 * @Author: coderDianxia
 * @Date: 2022/5/11 9:23
 * Create by coderDianxia
 */
@Data
public class PropertyValues {

    private List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue propertyValue) {
        propertyValueList.add(propertyValue);
    }

    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue propertyValue : propertyValueList) {
            if(propertyName.equals(propertyValue.getName()))
                return propertyValue;
        }
        return null;
    }

    public PropertyValue[] getPropertyValues() {
       return  propertyValueList.toArray(new PropertyValue[propertyValueList.size()]);
    }
}
