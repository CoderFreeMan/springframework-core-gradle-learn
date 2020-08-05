package com.practice.sprngframework.core.ioc.envAbstraction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Bean 定义配置文件
 * Bean 定义配置文件在核心容器中提供以一种不同环境注册不同Bean的机制，这能解决很多问题：
 *      1、开发、QA 或生产 JNDI 环境配置不同的数据源
 *      2、仅在应用程序部署到性能测试环境中时注册监控解除架构
 *      3、为 ClientA 和 ClientB 部署注册 Bean 的自定义实现
 *
 * @Profile 注解可用在类级别也可用在方法级别
 */
@Configuration
public class EnvProfile {

    /**
     * 默认配置文件
     * 在没有指定活跃配置文件是，启用默认情况下启用的配置文件
     * 指定活跃配置文件时，默认配置文件将不做任何处理
     * @return
     */
    @Bean
    @Profile("default")
    public DataSource dataSource5() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.HSQL)
                .addScript("my-schema.sql")
                .addScript("my-test-data.sql")
                .build();
    }

    @Bean
    @Profile(value = "development")
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.HSQL)
                .addScript("my-schema.sql")
                .addScript("my-test-data.sql")
                .build();
    }

    /**
     * @Profile 支持逻辑运算符:
     *                      ! - 逻辑非
     *                      & - 逻辑与
     *                      | - 逻辑或
     * @return
     */
    @Bean
    @Profile(value = "test & en-east")
    public DataSource dataSource3() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("my-schema.sql")
                .addScript("my-test-data.sql")
                .build();
    }

    @Bean
    @Profile(value = "QA")
    public DataSource dataSourceQA() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("my-schema.sql")
                .addScript("my-test-data.sql")
                .build();
    }

    /**
     * @Production 自定义组合注解，可以替代 @Profile("production") 注解
     * @return
     * @throws NamingException
     */
    @Bean(destroyMethod = "")
    @Production
    public DataSource dataSource2() throws NamingException {
        Context ctx = new InitialContext();
        return (DataSource) ctx.lookup("java:comp/evn/jdbc/datasource");
    }

}
