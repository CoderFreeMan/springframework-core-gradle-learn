package com.practice.sprngframework.core.ioc.annotationbased;

import com.practice.sprngframework.core.ioc.dao.AccountDAO;
import com.practice.sprngframework.core.ioc.dependencies.di.ServiceA;
import com.practice.sprngframework.core.ioc.dependencies.di.ServiceB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class AutowiredAnnotation {

    private final ServiceA serviceA;
    private ServiceB serviceB;

    /**
     * 应用于字段，甚至可以与构造函数混合使用
     */
    @Autowired
    private AccountDAO accountDAO;

    @Autowired
    private AccountDAO[] accountArray;

    @Autowired(required = false)
    private Set<AccountDAO> accountDAOSet;

    private Map<String, AccountDAO> accountDAOMap;

    @Autowired
    public void setAccountDAOMap(Map<String, AccountDAO> accountDAOMap) {
        this.accountDAOMap = accountDAOMap;
    }

    /**
     * 应用于构造函数, 来实现依赖注入
     * 仅定义一个构造函数时此注解可写可不写
     * 定义多个构造函数且没有主构造函数，则必须至少在一个构造函数上加上此注解
     * @param serviceA
     */
    @Autowired
    public AutowiredAnnotation(ServiceA serviceA) {
        this.serviceA = serviceA;
    }

    /**
     * 应用于 setter 方法，来实现依赖注入
     * @param serviceB
     */
    public void setServiceB(ServiceB serviceB) {
        this.serviceB = serviceB;
    }

    /**
     * 应用于任意名称和多个参数的方法
     * @param serviceA
     * @param serviceB
     */
    public void prepare(ServiceA serviceA, ServiceB serviceB) {
        // do something
    }

    /**
     * 使用 Java8 的 java.util.Optional 来表达特定依赖项是非必须的(required=false)
     * @param accountDAO
     */
    public void setAccountDAO(Optional<AccountDAO> accountDAO) {
        //do something
    }
    // 使用 @Nullable 注解来表示特定依赖项是非必须的(required=false)
    public void setServiceA(@Nullable ServiceA serviceA) {
        // do something
    }

}
