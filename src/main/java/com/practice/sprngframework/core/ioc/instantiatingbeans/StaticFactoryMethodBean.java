package com.practice.sprngframework.core.ioc.instantiatingbeans;

/**
 * 静态工厂方法实例化 Bean
 */
public class StaticFactoryMethodBean {
    private static StaticFactoryMethodBean staticFactoryMethodBean = new StaticFactoryMethodBean();

    private StaticFactoryMethodBean() {
    }

    public static StaticFactoryMethodBean createInstance() {
        return staticFactoryMethodBean;
    }
}
