package com.practice.sprngframework.core.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * @author yangdejun
 * @date 2020/08/05
 **/
@Component
@Aspect
public class Introductions {

//    @DeclareParents(value = "com.practice.sprngframework.core.aop", defaultImpl = DefaultUsageTracked.class)
//    public static  UsageTracked mixin;
//
//    @Before(value = "com.practice.sprngframework.core.aop.MyAspect2.pointCut()" && this(mixin))
//    public void recordUsage(UsageTracked usageTracked) {
//
//    }


    interface UsageTracke {

    }

    class DefaultUsageTracked implements UsageTracke {

    }

    class UsageTracked implements UsageTracke {

    }
}
