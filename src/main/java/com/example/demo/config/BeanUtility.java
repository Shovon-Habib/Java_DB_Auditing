
package com.example.demo.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class BeanUtility implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public static Object getBean(String beanId) {
        return applicationContext.getBean(beanId);
    }

    @Override
    public void setApplicationContext(ApplicationContext ac) throws BeansException {
        this.applicationContext = ac;
    }

}
