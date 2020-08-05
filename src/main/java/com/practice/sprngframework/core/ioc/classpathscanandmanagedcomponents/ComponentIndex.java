package com.practice.sprngframework.core.ioc.classpathscanandmanagedcomponents;

/**
 * 尽管类路径扫描非常快，但可以通过在编译时创建静态候选列表来提高大型应用程序的启动性能。
 * 这种模式下，作为组件扫描目标的所有模块都必须使用此机制。
 * maven：
 * <dependencies>
 *     <dependency>
 *         <groupId>org.springframework</groupId>
 *         <artifactId>spring-context-indexer</artifactId>
 *         <version>5.2.7.RELEASE</version>
 *         <optional>true</optional>
 *     </dependency>
 * </dependencies>
 *
 * gradle：
 * dependencies {
 *     annotationProcessor "org.springframework:spring-context-indexer:{spring-version}"
 * }
 *
 * 该过程将在 META-INF/spring.components 包含在 jar 文件中
 */
public class ComponentIndex {
}
