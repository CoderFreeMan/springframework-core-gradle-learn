package com.practice.sprngframework.core.ioc.service.impl;

import com.practice.sprngframework.core.ioc.dao.AccountDAO;
import com.practice.sprngframework.core.ioc.service.PetStoreService;

public class PetStoreServiceImpl implements PetStoreService {

    private AccountDAO accountDAO;

    public PetStoreServiceImpl() {
    }

    public PetStoreServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public void setAccountDAO(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public void sayHello() {
        System.out.println("hello ~~~");
    }
}
