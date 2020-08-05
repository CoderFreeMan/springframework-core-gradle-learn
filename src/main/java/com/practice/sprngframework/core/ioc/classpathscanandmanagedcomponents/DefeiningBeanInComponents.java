package com.practice.sprngframework.core.ioc.classpathscanandmanagedcomponents;

import com.practice.sprngframework.core.ioc.dependencies.di.ServiceB;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DefeiningBeanInComponents {

    @Bean
    @Qualifier(value = "public")
    public ServiceB publicInstance() {
        return new ServiceB();
    }

    public void doWord() {

    }
}
