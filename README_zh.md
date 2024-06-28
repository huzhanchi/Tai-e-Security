# 介绍

Tai-e-Security 是基于Tai-e java 静态检测框架之上的一个漏洞检测

# 漏洞从哪些地方引入

![introduce_point.png](images/introduce_point.png)

* 容器引入

在java世界里容器的概念有多样，并且这些容器都是在业界以规范的形式存在，比如 servlet容器，以及它的实现tomcat，ejb 容器以及它的实现Jboss，还有java bean现实标准spring那一套

* component引入

这种组件本身不能构成一个runnable的程序，比如Log4j, fastjson 等，他们的漏洞利用需要被依赖到runnable的程序里

* 业务逻辑引入

这一部分是业务方基于上面的java基础设施编写自己的逻辑代码引入，比如各种controller, service 等

# 污点分析检测

污点分析检测主要的逻辑是基于已有的漏洞知识，收集source和sink

## 面临的挑战

* 我们要从上面提到的漏洞引入点哪里起步

我们需要end to end的检测，比如从容器端起步么？比较切实际和落地的是从我们关心的部分，比如我们要分析业务逻辑部分，就从controller部分开始。如果我们要分析spring 框架本身的漏洞
又是另外一种做法

* 定义entry point 和 source遇到的困难

java里很多是基于声明式，比如各种DSL，spring IOC xml 即是一种DSL，还有各种annotation也是一种DSL，这是一种声明我要什么，具体怎么做的逻辑是在代码另外一端，并且都会涉及到
反射的操作

* 所以最终的困难是什么

最终的困难是分析的时候 如何应对反射，无论IOC还是annotation以及 proxy模式

* 解决方式有哪些

通用层面上我还没想清楚，期待框架比如Tai-e 有一套自己的反射model，并且这块我也没太深入了解

框架使用角度去workaround，这个方向也可以有两个子方向:

1. 基于Tai-e 提供的plugin机制，自定义自己所在的分析领域的特殊处理，增加自己的entry point和source
2. 反射展开，即将反射的魔法语法去掉，将他们展开成简单移动的方式, 这个repo里用到的一些方发就是比如 将所有spring 里的controller 都mock 到一个servlet里

# Todo list

- [x] jsp webshell
- [x] log4j shell
- [x] java-sec-code
- [x] servlet
- [x] spring controller