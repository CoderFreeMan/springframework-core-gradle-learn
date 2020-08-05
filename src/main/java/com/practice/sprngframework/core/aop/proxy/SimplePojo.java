package com.practice.sprngframework.core.aop.proxy;

import org.springframework.aop.aspectj.AspectJMethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

/**
 * @author yangdejun
 * @date 2020/08/05
 **/
public class SimplePojo implements Pojo {
    @Override
    public void foo() {
        System.out.println("invoke method");
    }

    public static void main(String[] args) {
        Pojo pojo = new SimplePojo();
        pojo.foo();// this is a direct method call on the 'pojo' reference

        ProxyFactory factory = new ProxyFactory(new SimplePojo());
        factory.addInterface(Pojo.class);
        factory.addAdvice(null);
        Pojo pojo1 = (Pojo) factory.getProxy();
        pojo1.foo();
    }
}
