package com.practice.sprngframework.core.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect2 {

    /**
     * 定义一个切入点
     * execution(modifiers-pattern?
     *           ret-type-pattern
     *           declaring-type-pattern?name-pattern(param-pattern)
     *           throws-pattern?)
     */
    @Pointcut("execution(* com.practice.sprngframework.core.aop.IUsers.updateUser())")
    public void pointCut() {
    }

    /**
     * 定义一个切入点
     */
    @Pointcut("execution(* com.practice.sprngframework.core.aop.IUsers.addUser())")
    public void pointCut2() {
    }

    /**
     * 定义一个切入点
     */
    @Pointcut("execution(* com.practice.sprngframework.core.aop.IUsers.deleteUser())")
    public void pointCut3() {
    }

    /**
     * within(com.practice.sprngframework.core.aop.*) -> aop 包下的所有类
     * within(com.practice.sprngframework.core.aop...*) -> aop 包及其所有子包下的所有类
     */
    @Pointcut(value = "within(com.practice.sprngframework.core.aop.*)")
    public void pointCut4() {
    }

    /**
     * 带有 @Transactional 注解的所有类
     */
    @Pointcut(value = "@within(org.springframework.transaction.annotation.Transactional)")
    public void pointCut5() {
    }

    /**
     * 实现了 IUsers 接口的所有类，如果不是接口则限定类本身
     */
    @Pointcut(value = "this(com.practice.sprngframework.core.aop.IUsers)")
    public void pointCut6() {
    }

    @Pointcut(value = "target(com.practice.sprngframework.core.aop.IUsers)")
    public void pointCut7() {
    }

    /**
     * 带有 @Transactional 注解的所有类的所有方法
      */
    @Pointcut(value = "@target(org.springframework.transaction.annotation.Transactional)")
    public void pointCut8() {
    }

    /**
     * 带有 @Transactional 注解的的所有方法
     * @within 和 @target 针对的是类的注解，@annotation 针对的是 方法的注解
     */
    @Pointcut(value = "@annotation(org.springframework.transaction.annotation.Transactional)")
    public void pointCut9() {
    }

    /**
     * 参数为 String 类型的方法
     */
    @Pointcut(value = "args(String)")
    public void pointCut10() {
    }

    /**
     * 参数带有 @Transactional 注解的方法
     */
    @Pointcut(value = "@args(org.springframework.transaction.annotation.Transactional)")
    public void pointCut11() {
    }

    /**
     * 组合切入点表达式，支持：
     * && : 逻辑与
     * || : 逻辑或
     * ! : 逻辑非
     *
     * 最佳实践是从较小的命名组件中构建更复杂的切入点表达式
     */
    @Pointcut(value = "pointCut2() && pointCut3()")
    public void pointCut12() {
    }

    /**
     * 定义一个 before advise
     * 在连接点之前运行
     * advice 方法没有发生异常则进行连接点方法的执行
     * advice 方法发生异常则不会执行连接点方法的执行
     */
    @Before(value = "pointCut()")
    public void beforeAdvice() throws Exception {
        System.out.println("我在连接点方法执行前执行...");
        //throw new Exception("exception");
    }

    /**
     * 定义一个 after returning advice
     * 在连接点正常运行并返回后执行
     * 连接点方法没有发生异常则进行 advice 方法的执行
     * 连接点方法发生异常则不会进行 advice 方法的执行
     */
    @AfterReturning(value = "pointCut()")
    public void afterReturningAdvice() {
        System.out.println("我在连接点方法正常执行并返回后执行");
    }

    /**
     * 定义一个 after advice
     * 在连接点方法执行之后执行(无论连接点是否发生异常)
     */
    @After(value = "pointCut()")
    public void afterFinallyAdvice() {
        System.out.println("我论连接点方法退出的方式如何(正常或异常)都会执行");
    }

    /**
     * 定义一个 after throwing advice
     * 在连接点方法因抛出异常而退出时执行
     */
    @AfterThrowing(value = "pointCut2()")
    public void afterThrowingAdvice() {
        System.out.println("我在连接点方法发生异常时执行");
    }

    /**
     * 定义一个 around advice
     */
    @Around(value = "pointCut3()")
    public void aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("around advice start");
        pjp.proceed();
        System.out.println("around advice end");
        System.out.println("我是 around 的，你们的功能我都可以");
    }

}
