package com.practice.sprngframework.core.ioc.custom;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * ApplicationAware 和 BeanNameAware 接口
 * 当 ApplicationContext 创建了一个实现 ApplicationContextAware 接口的对象实例时，就为该实例提供了 ApplicationContext 引用
 */
public class ImplApplicationContextAware implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}
