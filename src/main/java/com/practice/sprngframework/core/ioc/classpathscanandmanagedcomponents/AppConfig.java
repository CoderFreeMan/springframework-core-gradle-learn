package com.practice.sprngframework.core.ioc.classpathscanandmanagedcomponents;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Repository;

/**
 * 自动扫描并注册 bean
 * includeFilters 指定扫描并注册的过滤器，支持 正则表达式
 * excludeFilters 指定扫描并排除注册的过滤器，支持 正则表达式
 * xml 中也可使用
 */
@Configurable
//@ComponentScan(basePackages = "com.practice.sprngframework.core.ioc.classpathscanandmanagedcomponents",
//                includeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern=".*stub.*Repository"),
//                excludeFilters = @ComponentScan.Filter(Repository.class))
public class AppConfig {
}
