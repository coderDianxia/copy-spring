package com.coderdianxia.spring.service;

import com.coderdianxia.spring.context.ApplicationListener;

/**
 * @ClassName: CustomApplicationListerner
 * @Description:TODO
 * @Author:coderDianxia
 * @Date: 2022/5/16 17:51
 */
public class CustomApplicationListerner implements ApplicationListener<CustomEvent> {

    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("CustomApplicationListerner:收到监听消息"+event.getMsg());
    }
}
