package com.practice.sprngframework.core;

import com.practice.sprngframework.core.ioc.dao.AccountDAO;
import com.practice.sprngframework.core.ioc.dependencies.di.ConstructorBasedDI;
import com.practice.sprngframework.core.ioc.instantiatingbeans.ConstructorBean;
import com.practice.sprngframework.core.ioc.instantiatingbeans.InstanceFactoryMethodBean;
import com.practice.sprngframework.core.ioc.instantiatingbeans.StaticFactoryMethodBean;
import com.practice.sprngframework.core.ioc.service.PetStoreService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/services.xml",
                "classpath:/dao.xml",
                "classpath:/instantiatingBean.xml",
                "classpath:/dependencies.xml");
        PetStoreService petStoreService = context.getBean("petStoreService", PetStoreService.class);
        petStoreService.sayHello();
        context.getType("petStoreService");

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        accountDAO.accountDAO();

        ConstructorBean constructorBean = context.getBean("constructorBean", ConstructorBean.class);

        StaticFactoryMethodBean staticFactoryMethodBean = context.getBean("staticFactoryMethodBean", StaticFactoryMethodBean.class);

        InstanceFactoryMethodBean instanceFactoryMethodBean = context.getBean("instanceFactoryMethodBean", InstanceFactoryMethodBean.class);
        instanceFactoryMethodBean.instanceFactoryMethodBean();

        String instanceFactoryMethodBean1 = context.getType("instanceFactoryMethodBean").getName();
        System.out.println(instanceFactoryMethodBean1);

        ConstructorBasedDI constructorBaseDI = context.getBean("constructorBaseDI", ConstructorBasedDI.class);
        ConstructorBasedDI constructorBaseDIType = context.getBean("constructorBaseDIType", ConstructorBasedDI.class);
        ConstructorBasedDI constructorBaseDIIndex = context.getBean("constructorBaseDIIndex", ConstructorBasedDI.class);
        ConstructorBasedDI constructorBaseDIName = context.getBean("constructorBaseDIName", ConstructorBasedDI.class);
        System.out.println(constructorBaseDI.getCode());
        System.out.println(constructorBaseDIType.getCode());
        System.out.println(constructorBaseDIIndex.getCode());
        System.out.println(constructorBaseDIName.getCode());

    }
}
