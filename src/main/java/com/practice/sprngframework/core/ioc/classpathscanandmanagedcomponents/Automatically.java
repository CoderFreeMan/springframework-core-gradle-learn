package com.practice.sprngframework.core.ioc.classpathscanandmanagedcomponents;

import com.practice.sprngframework.core.ioc.dependencies.di.ServiceB;
import org.springframework.stereotype.Service;

/**
 * 自动检测类并注册 Bean
 * 要自动检测这些类并注册Bean，需要添加 @ComponentScan 到 @Configuration 类中
 * @AppConfig basePackages 属性指定父包，可用逗号分隔指定多个父包
 * xml 中使用 <context:component-scan base-package=""/> 隐式启用 <context:annotation-config></context:annotation-config>
 */
@Service
public class Automatically {

    private ServiceB serviceB;

    public Automatically(ServiceB serviceB) {
        this.serviceB = serviceB;
    }
}
