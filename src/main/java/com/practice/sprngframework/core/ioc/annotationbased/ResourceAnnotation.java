package com.practice.sprngframework.core.ioc.annotationbased;

import com.practice.sprngframework.core.ioc.dependencies.di.ServiceB;

/**
 * @Resouce 注解按照名称进行自动转配
 * @Autowire 按照类型进行自动装配
 */
public class ResourceAnnotation {

    private ServiceB serviceB;

    public void  setServiceB(ServiceB serviceB) {
        this.serviceB = serviceB;
    }

}
