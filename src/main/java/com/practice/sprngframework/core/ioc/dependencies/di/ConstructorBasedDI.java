package com.practice.sprngframework.core.ioc.dependencies.di;

/**
 * 基于构造函数的依赖注入
 */
public class ConstructorBasedDI {

    private ServiceA serviceA;

    private ServiceB serviceB;

    private int code;

    private String desc;

    private int age;

    public void setAge(int age) {
        this.age = age;
    }

    public ConstructorBasedDI() {
    }

    public ConstructorBasedDI(ServiceA serviceA) {
        this.serviceA = serviceA;
    }

    public ConstructorBasedDI(ServiceA serviceA, ServiceB serviceB) {
        this.serviceA = serviceA;
        this.serviceB = serviceB;
    }

    //@ConstructorProperties({"code", "desc"})
    public ConstructorBasedDI(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public ServiceA getServiceA() {
        return serviceA;
    }

    public void setServiceA(ServiceA serviceA) {
        this.serviceA = serviceA;
    }

    public ServiceB getServiceB() {
        return serviceB;
    }

    public void setServiceB(ServiceB serviceB) {
        this.serviceB = serviceB;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
