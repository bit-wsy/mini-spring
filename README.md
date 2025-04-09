MiniSpring是一个简化版的Spring框架，支持Spring的核心功能：IoC、AOP、资源加载器、应用上下文、事件监听器、类型转换、包扫描、常用注解等。
- **项目内容：**

  - **IOC:** 实现完整的Bean生命周期管理，包含BeanDefinition注册、三级缓存机制（singleton、earlySingletonObject、singletonFactories），解决循环依赖问题。

  - **AOP:** 开发基于JDK与CGLIB动态代理增强的双模式 AOP 框架，支持 Before/After/ Throws 等多维度增强。


  - **配置:** 构建XML配置驱动体系，通过 Dom4j 解析实现<bean>、<property>、<aop:config>等标签的语义化处理，支持占位符替换（@Value）与注解扫描（@Component）。
