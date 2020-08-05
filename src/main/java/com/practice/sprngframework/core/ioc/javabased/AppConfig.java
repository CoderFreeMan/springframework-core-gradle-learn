package com.practice.sprngframework.core.ioc.javabased;

import com.practice.sprngframework.core.ioc.dependencies.di.ServiceB;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 在新的 Java-configuration 核心工件中支持 @Configuration 类 和 @Bean 方法
 * @Bean 注解像 xml <bean/> 注解一样可以配置并初始化到由 Spring IoC 容器进行管理的新对象
 * @Bean 可以用于任何带有 @Component 注解类中的方法上，但是，尝尝与 @Configuration 一起使用
 * 用 @Configuration 注解的类，主要目的是作为 Bean 定义的来源
 * @Configuration 允许通过调用 @Bean 同一类中的其它方法来定义Bean之间的依赖关系
 */
@Configuration
public class AppConfig {

    @Bean
    public ServiceB serviceB() {
        return new ServiceB();
    }
}
