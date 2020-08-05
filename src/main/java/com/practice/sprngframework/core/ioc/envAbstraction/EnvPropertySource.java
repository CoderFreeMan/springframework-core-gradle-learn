package com.practice.sprngframework.core.ioc.envAbstraction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.env.Environment;

/**
 * PropertySource abstract
 *
 */
public class EnvPropertySource {


    /**
     * spring Environment 抽象提供了对属性源可配置层次结构的搜索操作
     * Environment 对象在一组 PropertySource 对象上执行搜索
     * PropertySource 是对任何键值对源的简单抽象
     * Spring 的 StandardEnvironment 配置了两个 PropertySource 对象
     * 一个代表 JVM 系统属性的集合(System.getPropertis())
     * 另一个代表系统环境变量的集合(System.getenv())
     * 如果在运行时存在 my-property 系统属性或 my-property 环境变量，则返回 true
     *
     * 执行的搜索是分层的。默认情况下，系统属性优先于环境变量。
     * 如果 my-property 在调用时在两个地方同时设置了 env.getProperty("my-property") 属性，则系统属性值将最终返回。
     * 注意，属性值并不会合并，而是被前面的条目完全覆盖。
     * 对于常见的 StandardServletEnvironment，完整的层次结构如下，优先级递减：
     *      1、ServletConfig 参数(如果使用，例如在 DispatchServlet context 中)
     *      2、ServletContext 参数(web.xml context 上下文参数条目)
     *      3、JNDI 环境变量(java:comp/env/ entries)
     *      4、JVM 系统属性(-D命令行参数)
     *      5、JVM 系统环境(操作系统环境变量)
     * 整个机制是可配置的，可提供自定义的 PropertySource 实例并添加到 PropertySources 中
     */
    public void propertySearch(){
        ApplicationContext ctx = new GenericApplicationContext();
        Environment env = ctx.getEnvironment();
        boolean containsProperty = env.containsProperty("my-property");
        System.out.println("Does my environment contain the 'my-property'" + containsProperty);
    }

}
