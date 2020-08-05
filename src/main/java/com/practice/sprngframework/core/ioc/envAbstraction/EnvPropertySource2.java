package com.practice.sprngframework.core.ioc.envAbstraction;

import com.practice.sprngframework.core.ioc.dependencies.di.ServiceB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * @PropertySource 注解将 PropertySource 添加到 Spring 环境中提供了一种便利的声明性机制
 * 属性文件中的占位符 ${} 是根据已经针对环境注册的一组属性源来解析的，例如:
 * @PropertySource("classpath:/${my.placeholder}:default/application.properties")
 * my.placeholder 存在于已注册的属性源之一中，则占位符将解析为相应的值。如果不是，则 default/path 用作默认值，若未指定默认值则抛出 IllegalArgumentException
 *
 */
@Configuration
@PropertySource("classpath:/application.properties")
public class EnvPropertySource2 {

    @Autowired
    private Environment env;

    @Bean
    public ServiceB testBean() {
        ServiceB serviceB = new ServiceB();
        serviceB.setName(env.getProperty("catalog.name"));
        System.out.println(env.getProperty("catalog.name"));
        return serviceB;
    }

}

