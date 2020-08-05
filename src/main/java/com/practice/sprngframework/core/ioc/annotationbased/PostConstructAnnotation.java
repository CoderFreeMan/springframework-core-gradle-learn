package com.practice.sprngframework.core.ioc.annotationbased;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @PostConstruct 和 @PreDestroy
 * CommonAnnotationBeanPostProcessor 承认了 @Resource、PostConstruct、PreDestroy
 * 为初始回调和销毁回调机制提供了一种替代方法
 */
public class PostConstructAnnotation {

    @PostConstruct
    public void populateCache() {
        // populates the movie cache upon initialization...
    }

    @PreDestroy
    public void clearCache() {
        // clears the movie cache upon destruction...
    }
}
