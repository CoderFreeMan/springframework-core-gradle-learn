package com.practice.sprngframework.core.aop;

import org.springframework.stereotype.Component;

@Component(value = "user")
public class UserImpl implements IUsers {

    @Override
    public void updateUser() {
        System.out.println("我是一个普通方法");
    }

    @Override
    public void addUser() throws Exception {
        System.out.println("我也是一个普通方法");
//        throw new Exception("");
    }

    @Override
    public void deleteUser() {
        System.out.println("我还是一个普通方法");
    }
}
