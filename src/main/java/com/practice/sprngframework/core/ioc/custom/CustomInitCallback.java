package com.practice.sprngframework.core.ioc.custom;

import org.springframework.beans.factory.InitializingBean;

/**
 * 生命周期回调 - Initialzation callbacks(初始化回调)
 */
public class CustomInitCallback implements InitializingBean {
    /**
     * 容器在bean上设置了所有必须的属性后，该接口使bean可以执行初始化工作
     * InitializingBean 接口的方法
     * 不建议使用该接口，因为它不必要将代码耦合到spring
     * 建议使用 @PostConstruct注解或指定 POJO 初始化方法, init-method or initMethod
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        // do something ...
    }
}
