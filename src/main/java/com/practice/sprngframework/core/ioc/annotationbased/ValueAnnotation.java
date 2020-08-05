package com.practice.sprngframework.core.ioc.annotationbased;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.stereotype.Component;

/**
 * @Value 通常用于注入外部属性
 * spring 提供了一个默认的宽松内嵌值解析器，如果无法解析，则将属性名称(丽日{catalog.name})作为值注入
 * 如果要严格控制不存在的值，则应声明一个 PropertySourcesPlaceholderConfigurer bean
 * spring boot 默认配置一个 PropertySourcesPlaceholderConfigurer bean，它将从 application.properties 和 application.yml 文件中获取属性
 * spring 提供的内置转换器支持自动处理简单的类型转换，例如 Integer -> int。多个逗号分隔的值可以自动转换为 String 数组
 */
@Component
public class ValueAnnotation {
    private final String catalog;
    private int line;

    /**
     * @Value 可与SpEL 表达式配合使用
     * @param catalog
     */
    public ValueAnnotation(@Value(value = "${systemProperties['catalog.name'] + 'aa'}") String catalog) {
        this.catalog = catalog;
    }

    /**
     * 可提供默认值
     * @param catalog
     * @param line
     */
    public ValueAnnotation(String catalog, @Value(value = "${catalog.line:defaultCatalog}") int line) {
        this.catalog = catalog;
        this.line = line;
    }
}

@Configuration
@PropertySource("classpath:application.properties")
class AppConfig {

}

/**
 * PropertySourcesPlaceholderConfigurer 必须是 static
 * 如果${}无法解析任何占位符，则使用此配置可确保spring初始化失败
 * 还可使用 setPlaceholderPrefix、setPlaceholderSuffix、setValueSeparator
 */
@Configuration
class AppConfig2 {
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}

/**
 * spring BeanPostProcessor 使用 ConversionService 处理 String 值转换 @Value 为目标类型的过程
 * 可通过以下方式提供自己的转换支持
 */
@Configuration
class AppConfig3 {
    @Bean
    public ConversionService conversionService() {
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
//        conversionService.addConverter(new MyCustomConverter());
        return conversionService;
    }
}