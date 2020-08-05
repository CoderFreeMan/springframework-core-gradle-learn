package com.practice.sprngframework.core.ioc.custom;

import org.springframework.beans.factory.DisposableBean;

/**
 * 生命周期回调 - destruction callbacks(销毁回调)
 * 当包含 DisposableBean 接口的容器被销毁时，实现该接口可使 Bean 获得回调
 * 不建议使用 DisposableBean 定义支持的通用方法，因为它不必要将代码耦合到Spring
 * 推荐使用 @PreDestroy 注解或指定bean定义的方法
 * destroy-method or destroyMethod
 */
public class CustomDestructionCallback implements DisposableBean {
    @Override
    public void destroy() throws Exception {
        // do some destruction work(like releasing pooled connections ...)
    }
}
