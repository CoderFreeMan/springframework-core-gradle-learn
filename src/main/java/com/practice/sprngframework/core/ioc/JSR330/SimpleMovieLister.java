package com.practice.sprngframework.core.ioc.JSR330;

import com.practice.sprngframework.core.ioc.dao.AccountDAO;
import com.practice.sprngframework.core.ioc.dependencies.di.ServiceA;
import com.practice.sprngframework.core.ioc.dependencies.di.ServiceB;
import com.practice.sprngframework.core.ioc.dependencies.di.SetterBasedDI;
import org.springframework.lang.Nullable;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;
import java.util.Optional;

@Named(value = "movieListener")
public class SimpleMovieLister {
    private ServiceB serviceB;

    @Inject
    public void setServiceB(ServiceB serviceB) {
        this.serviceB = serviceB;
    }

    public void listMovies() {
        this.serviceB.getClass();
    }

    private Provider<ServiceA> serviceAProvider;

    @Inject
    public void setServiceAProvider(Provider<ServiceA> serviceAProvider) {
        this.serviceAProvider = serviceAProvider;
    }

    public void listMovies2() {
        this.serviceAProvider.get().getClass();
    }

    private SetterBasedDI setterBasedDI;

    public void setSetterBasedDI(@Named("main") SetterBasedDI setterBasedDI) {
        this.setterBasedDI = setterBasedDI;
    }

    private AccountDAO accountDAO;

    public void setAccountDAO(Optional<AccountDAO> accountDAO) {
        // do something
    }

    private String name;

    public void setName(@Nullable String name) {
        this.name = name;
    }
}
