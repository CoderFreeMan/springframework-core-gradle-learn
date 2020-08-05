package com.practice.sprngframework.core.ioc.annotationbased;

import com.practice.sprngframework.core.ioc.dependencies.di.ServiceA;
import org.springframework.beans.factory.annotation.Required;

/**
 * @Required 注解适用于 bean 属性 setter 方法
 * 显示强制装配 bean ，避免后续使用的时候发生  NPE 异常
 *
 * 从 Spring Framework5.1 开始，正式启用该注解, InitializingBean.afterPropertiesSet()
 */
public class RequiredAnnotation {

    private ServiceA serviceA;

    @Required
    public void setServiceA(ServiceA serviceA) {
        this.serviceA = serviceA;
    }
}
