package com.practice.sprngframework.core.ioc.instantiatingbeans;

/**
 * 实例工厂方法实例化 Bean
 */

public class DefaultServiceLocator {

    private static InstanceFactoryMethodBean instanceFactoryMethodBean = new InstanceFactoryMethodBean();

    public InstanceFactoryMethodBean createInstanceFactoryMethodBean() {
        return instanceFactoryMethodBean;
    }

}

