package com.practice.sprngframework.core.ioc.annotationbased;

import com.practice.sprngframework.core.ioc.dependencies.di.ServiceA;
import com.practice.sprngframework.core.ioc.dependencies.di.ServiceB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @TODO
 */
public class QualifierAnnotation {

    @Autowired
    @Qualifier(value = "main")
    private ServiceB serviceB;

    public void prepare(@Qualifier(value = "main") ServiceB serviceB) {
        //do something
    }

    @Autowired
    @CustomAnnotation(value = "Action")
    private ServiceA serviceA;


}
