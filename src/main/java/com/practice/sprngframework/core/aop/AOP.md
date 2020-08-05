# 使用 Spring 进行面向切面编程 
&emsp;&emsp; 面向切面编程(Aspect-oriented progamming - AOP) 通过提供另一种思考程序结构的方式来补充面向对象编程(OOP).
OOP 中模块化的关键单元是类，而在 AOP 中模块化是切面。切面使关注点(例如事务管理)的模块化跨多个类型和对象(crosscutting)

&emsp;&emsp; AOP 框架是 Spring 重要组件之一。尽管 Spring IoC 容器不依赖于 AOP，
但是 AOP 是对 Spring IoC 的补充，以提供功能强大的中间件解决方案。

&emsp;&emsp; Spring 通过使用 schema-based 或 @AspectJ 注解的形式，提供了编写自定义切面的简单而强大的方法。
这两种方式都提供了完全类型化的 advice，并使用了 AspectJ pointcut 语言，同时仍使用 Spring AOP 进行编排。

AOP 在 Spring 框架中的应用：  
    - 提供声明式企业服务。此类服务中最重要的是声明式事务管理  
    - 让用户实现自定义切面，通过 AOP 补充其对 OOP 的使用


## AOP 概念
首先了解一些 AOP 中重要的概念和术语。这些术语不是特定于 Spring 的。
AOP 中的术语并不是特别直观。但是，如果使用 Spring 自己的术语，将会更加令人困惑。

- Aspect(切面)： 包括多个类的关注点的模块(类)。事务管理是企业 Java 应用程序中切面关注的一个很好的例子
                在 Spring AOP 中，切面使通过使用常规类(schema-based)或@AspectJ注解的类来实现的
                
- Join point(连接点)：在程序执行过程中的一点，例如方法的执行或异常的处理。在 Spring AOP 中，连接点始终代表方法的执行

- Advice(建议-通知)：切面在特定的连接点采取的操作，不同类型的 advice 包括："around"、"before"、"after"，
                    包括 Spring 在内的许多 AOP 框架都将 advice 作为拦截器，并在连接点周围维护一系列拦截器

- Pointcut(切入点)：与连接点匹配的谓词，advice 与 pointcut 表达式关联，并在与该切入点匹配的任何连接点出运行(例如，执行具有特定名称的方法)
                  切入点表达式匹配的连接点的概念是 AOP 的核心，默认情况下，Spring 使用 AspectJ 切入点表达式。
                  
- Introduction()：代表类型声明其他方法或字段，Spring AOP 允许你向任何advised 对象引入新的接口(和相应的实现)，例如
                  可以使用 introduction 使 Bean 实现 IsModified 接口，以简化缓存
                  
- Target object：一个或多个切面advised对象，也称为"advised object"，由于 Spring AOP 是使用运行时代理实现的，因此此对象始终是代理对象

- AOP proxy：由 AOP 框架创建的一个对象，用于实现 aspect contracts(advise method 执行等)，在 Spring 中，AOP proxy是 JDK 动态代理或 CGLIB 代理

- Weaving：将切面与其它应用程序类型或对象链接以创建 advice 的对象，这可以在编译时(例如，使用 AspectJ 编译器)，加载时或在运行时完成
           像其它纯 Java AOP 框架一样，Spring AOP 在运行时执行 weaving
           
Spring AOP包括以下类型的 advice：
- Before advice：在连接点之前运行但无法阻止执行流程前进到连接点的 advice(除非它引发异常)
- After returning advice：在连接点正常完成后要运行的 advice(例如，如果返回一个方法而没有引发异常)
- After throwing advice：如果方法因抛出异常而退出，则执行 advice
- After(finally) advice：无论连接点退出的方式如何(正常或特殊返回)，均执行 advice
- Around advice：围绕连接点的 advice，例如方法调用。这是最给力的 advice。around advice 可以在方法调用之前后之后执行自定义行为
                 它还负责选择是返回连接点还是通过返回其自身的返回值或引发异常来快速处理 advice 的方法执行

around advice 是最通用的 advice。由于 Spring AOP 与 AspectJ 一样，提供了各种 advice 类型，因此我们建议你使用功能最弱的 advice 类型，以实现所需的行为。
例如，如果你只需要使用方法的返回值更新缓存，则最好使用 after returning advice 而不是 around advice，尽管 around advice 可以完成相同的事情。
使用最具体的 advice 类型可提供最简单的编程模型，并减少出错的可能性。例如，你不需要在用于 around advice 的 JoinPoint 上调用 proce() 方法，因此，你不会失败。

所有 advice 参数都是静态类型的，因此你可以使用适当类型(例如，从方法执行返回值的类型)而不是对象数组的 advice 参数

切入点匹配的连接点的概念是 AOP 的关键，它与仅提供拦截功能的旧技术有所不同。切入点使用 advice 的目标独立于面向对象的层次结构。
例如，你可以将提供声明式事务管理的 around advice 应用于跨越多个对象(例如服务层中的所有业务操作)的一组方法。


## Spring AOP 样式选择
- 只需要在 Spring bean 上执行切面操作，选择 Spring AOP
- bean 不在 Spring 容器中管理的对象(通常是域对象)则需要 AspectJ
- 希望 advise 除简单方法执行之外的连接点，则需要 AspectJ
如果选择使用 Spring AOP，则可以选择 @AspectJ或XML样式：  
XML 样式可能是现有 Spring 用户最熟悉的，并且得到了真正的 POJO 的支持。
当使用AOP作为配置企业服务的工具时，XML是一个不错的选择。
使用XML样式，可以清楚地了解系统中存在那些切面。

XML样式的两个缺点：  
- 没有完全将需求和实现封装在一个地方
- 与@AspectJ样式相比，XML样式在表达能力上有更多限制，仅支持"singleton"切面实例化模型，并且无法组合切入点

@AspectJ样式支持更多的实例化模型和更丰富的切入点组合。它具有将切面保持以模块化单元的优势。
还具有Spring AOP和AspectJ都可以理解@AspectJ切面的优点。因此，如果你以后决定需要AspectJ的功能来实现其他要求，则可以轻松地迁移到AspectJ。
总而言之，Spring 团队在自定义切面更喜欢 @AspectJ 样式，而不是简单地配置企业服务。

## AOP 代理和代理机制
Spring AOP 是基于代理的，在编写自己的切面或使用Spring框架提供的任何基于Spring AOP的切面之前，掌握最后一条语句的实际含义的语义非常重要。  

Spring AOP 默认将标准 JDK 动态代理用于 AOP 代理。这使得可以代理任何接口。
Spring AOP也可以使用CGLIB代理。这对于代理类而不是接口是必需的。默认情况下，如果业务对象未实现接口，则使用CGLIB。

