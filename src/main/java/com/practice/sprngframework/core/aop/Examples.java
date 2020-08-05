package com.practice.sprngframework.core.aop;

public interface Examples {
    /**
     * 所有 public 方法 -> execution(public * *(..))
     * 所有以 set 开头的方法 -> execution(* set*(..))
     * 所有 AccountService 接口的所有方法 -> execution(* com.xyz.service.AccountService.*(..))
     * 所有 service 包中的方法 -> execution(* com.xyz.service.*.*(...))
     * 所有 service 包，及其子包中的所有方法 -> execution(* com.xyz.service..*.*(..))
     * service 包中的所有连接点(join point) -> within(com.xyz.service.*)
     * service 包，及其子包中的所有连接点(join point) -> within(com.xyz.service..*)
     * 代理实现 AccountService 接口的所有连接点,this 通常以绑定的形式使用 -> this(com.xyz.service.AccountService)
     * 所有实现 AccountService 接口的连接点(join point), target 通常以绑定的形式使用 -> target(com.xyz.service.AccountServie)
     * 所有接收一个参数且在运行时传递的参数类型为 Serializable 的连接点, args 通常以绑定的形式使用 -> args(java.io.Serializable)
     * 所有带有 @Transactional 注解的连接点(join point) -> @target(org.springframework.transaction.annotation.Transactional)
     * 所有生命类型具有 @Tansactional 注解的所有连接点 -> @within(org.springframework.transaction.annotation.Transactional)
     * 所有带有 @Transactional 注解方法的连接点 -> @annotation(org.springframework.transaction.annotation.Transactional)
     * 所有单个参数且传递参数的运行时类型具有 @Classified 注解的拦截点 -> @args(com.xyz.security.Classified)
     * 所有名为 tradeService 的 Spring Bean 上的连接点 -> bean(tradeService)
     * 所有具有与 *Service 通配符表达式匹配的连接点 -> bean(*Service)
     */
}
