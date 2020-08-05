package com.practice.sprngframework.core.ioc.annotationbased;

import com.practice.sprngframework.core.ioc.dependencies.di.ServiceB;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

public class PrimaryAnnotation {
    /**
     * 按类型自动装配可能会导致多个候选对象(返回Bean类型相同)
     * @Primary 注解可给予特定bean优先权
     * 更新粒度的控制请使用 @Qualifier 注解
     * @return
     */
    @Bean
    @Primary
    public ServiceB firstServiceB(){
        return null;
    }

    @Bean
    public ServiceB secondServiceB() {
        return null;
    }

}
