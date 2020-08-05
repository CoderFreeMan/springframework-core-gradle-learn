package com.practice.sprngframework.core.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppTest {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        UserImpl user = ctx.getBean("user", UserImpl.class);
        user.updateUser();
        user.addUser();
        user.deleteUser();
    }
}
