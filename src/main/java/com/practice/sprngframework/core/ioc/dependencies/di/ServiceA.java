package com.practice.sprngframework.core.ioc.dependencies.di;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class ServiceA {

    private ServiceB serviceB;

    private int age;
    private String name;
    private Properties adminEmails;
    private List someList;
    private Map someMap;
    private Set someSet;
    private Map<String, Float> accounts;

    public void setServiceB(ServiceB serviceB) {
        this.serviceB = serviceB;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdminEmails(Properties adminEmails) {
        this.adminEmails = adminEmails;
    }

    public void setSomeList(List someList) {
        this.someList = someList;
    }

    public void setSomeMap(Map someMap) {
        this.someMap = someMap;
    }

    public void setSomeSet(Set someSet) {
        this.someSet = someSet;
    }

    public void setAccounts(Map<String, Float> accounts) {
        this.accounts = accounts;
    }
}
