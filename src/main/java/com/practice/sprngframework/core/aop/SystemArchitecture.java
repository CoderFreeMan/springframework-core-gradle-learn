package com.practice.sprngframework.core.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SystemArchitecture {

    /**
     * web 包及其子包中的所有方法
     */
    @Pointcut(value = "within(com.practice.sprngframework.core.web..*)")
    public void inWebLayer() {
    }

    /**
     * service 包及其子包中的所有方法
     */
    @Pointcut(value = "within(com.practice.sprngframework.core.service..*)")
    public void inServiceLayer() {
    }

    /**
     * dao 包及其子包中所有方法
     */
    @Pointcut(value = "within(com.practice.sprngframework.core.dao..*)")
    public void inDataAccessLayer() {
    }

    /**
     * *.service.*
     */
    @Pointcut(value = "execution(* com.practice.sprngframework.core..service.*.*(..))")
    public void businessService() {
    }

    /**
     *
     */
    @Pointcut(value = "execution(* com.practice.sprngframework.core.dao.*.*(..))")
    public void dataAccessOperation() {
    }
}
