package com.practice.sprngframework.core.ioc.envAbstraction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 激活不同的 Bean 配置:
 *      1、ApplicationContext 指定激活的文件
 *      2、spring.profiles.active 属性声明性地激活配置文件，例如: -Dspring.profiles.active="development"
 *      3、系统环境变量、JVM 系统属性、servletcontext web.xml 参数、JNDI等
 */
public class AcitveProfile {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setActiveProfiles("development");
        ctx.register(EnvProfile.class);
        ctx.refresh();
    }
}
