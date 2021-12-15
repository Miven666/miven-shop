# Spring

## IOC 容器

### 自定义一个 bean

#### 生命周期回调

 - 初始化回调

   ```less
   实现 InitializingBean 接口（不推荐，与 Spring 耦合）
   在 XML <bean> 或在 @Bean 中指定 init-method 方法
   利用 JSR-250 规范中 @PostConstruct 标注初始化回调方法（推荐）
   ```

- 销毁之前

  ```less
  实现 Disposable 接口（不推荐，与 Spring 耦合）
  在 XML <bean> 或在 @Bean 中指定 destory-method 方法
  利用 JSR-250 规范中 @PreDestory 标注销毁之前方法（推荐）
  ```

- 默认的初始化和销毁方法

  ```less
  在 XML <beans> 中指定 default-init-method 或 default-destory-method 来全局统一设置
  当 <bean> 或 @Bean 明确 init-method 或 destory-method 是可以覆盖默认配置
  细节：IOC 容器在实例化 bean 并处理好依赖之后，就会立即开始 初始化回调，这意味着 AOP 代理(带有拦截器链）还没作用于原始 bean 。因此，将拦截器和初始化方法搅和在一起可能达不到预期效果，甚至引发一些莫名其妙的错误。
  ```

  

