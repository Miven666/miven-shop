# Mybatis

[中文官方文档地址](http://www.mybatis.org/mybatis-3/zh/index.html)	[github地址](https://github.com/mybatis)

## 未整合前
### SqlSessionFactoryBuilder
> 在不同条件下，使用建造者模式来统一创建SqlSessionFactory
- 调用XMLConfigBuilder构建Configuration对象，然后将该Configuration对象作为参数构建一个SqlSessionFactory对象。
### XMLConfigBuilder
> 读取所有的MybatisMapConfig.xml和所有的*Mapper.xml文件，构建Mybatis运行的核心对象Configuration对象
- 调用XMLMapperBuilder用于读取*Mapper文件

### XMLMapperBuilder
- 使用XMLStatementBuilder来读取和build所有的SQL语句

### SqlSessionFactory
- Mybatis都是以SqlSessionFactory的实例为中心的
- SqlSessionFactoryBuilder通过XML配置或Configuration 的实例
- 应用运行期间最好就一个SqlSessionFactory（单例模式或者静态单例模式）
- 为不同的线程创建各自的SqlSession

### SqlSession
- 线程不安全
- 确保完成响应后，关闭它

### 延迟加载
| 设置参数               | 描述                                                         | 有效值                 | 默认值                         |
| ---------------------- | ------------------------------------------------------------ | ---------------------- | ------------------------------ |
| lazyLoadingEnabled     | 延迟加载的全局开关。当开启时，所有关联对象都会延迟加载。 特定关联关系中可通过设置fetchType属性来覆盖该项的开关状态。 | true、false            | false                          |
| aggressiveLazyLoading  | 当开启时，任何方法的调用都会加载该对象的所有属性。否则，每个属性会按需加载（参考lazyLoadTriggerMethods). | true、false            | false (true in ≤3.4.1)         |
| lazyLoadTriggerMethods | 指定哪个对象的方法触发一次延迟加载。                         | 用逗号分隔的方法列表。 | equals,clone,hashCode,toString |
- 配置
  ```xml
  <configuration>
      <settings>
          <!-- 开启延迟加载 -->
          <setting name="lazyLoadingEnabled" value="true" />
          <setting name="aggressiveLazyLoading" value="false" />
          <setting name="lazyLoadTriggerMethods" value="equals,clone,hashCode,toString" />
        </settings>
  </configuration>
  ```
- Mapper 配置
  ```xml
  <mapper namespace="org.apache.ibatis.submitted.lazy_properties.Mapper">
    <resultMap type="org.apache.ibatis.submitted.lazy_properties.User"
      id="user">
      <id property="id" column="id" />
      <result property="name" column="name" />
    </resultMap>
    <!-- 结果对象 -->
    <resultMap type="org.apache.ibatis.submitted.lazy_properties.User" id="userWithLazyProperties" extends="user">
      <!-- 延迟加载对象lazy1 -->
      <association property="lazy1" column="id" select="getLazy1" fetchType="lazy" />
      <!-- 延迟加载对象lazy2 -->
      <association property="lazy2" column="id" select="getLazy2" fetchType="lazy" />
      <!-- 延迟加载集合lazy3 --> 
      <collection property="lazy3" column="id" select="getLazy3" fetchType="lazy" />
    </resultMap>
    <!-- 执行的查询 -->
    <select id="getUser" resultMap="userWithLazyProperties">
      select * from users where id = #{id}
    </select>
  </mapper>
  ```
- User 实体对象
  ```java
  public class User implements Cloneable {
    private Integer id;
    private String name;
    private User lazy1;
    private User lazy2;
    private List<User> lazy3;
    public int setterCounter;
    
    省略...
   }
  ```
- 执行解析：
  1. 调用getUser查询数据，从查询结果集解析数据到User对象，当数据解析到lazy1，lazy2，lazy3判断需要执行关联查询
  2. lazyLoadingEnabled=true，将创建lazy1，lazy2，lazy3对应的Proxy延迟执行对象lazyLoader，并保存
  3. 当逻辑触发lazyLoadTriggerMethods 对应的方法（equals,clone,hashCode,toString）则执行延迟加载
  4. 如果aggressiveLazyLoading=true，只要触发到对象任何的方法，就会立即加载所有属性的加载

## SpringBoot整合
### mybatis-spring
- SqlSessionFactoryBean实现了Spring的InitializingBean
- 初始化了SqlSessionFactoryBuilder，通过buildSqlSessionFactory()方法构造了SqlSessionFactory
- SqlSessionTemplate实现了SqlSession

### mybatis-spring-boot-autoconfigure
- MybatisAutoConfiguration实现了Spring的InitializingBean
- 在利用@Bean依赖注入SqlSessionFactory时，调用SqlSessionFactoryBean获取了SqlSessionFactory
- 利用@Bean依赖注入了SqlSessionTemplate

### mybatis-generator-maven-plugin
- mybatis相关代码生成插件
- 在pom.xml的plugins节点中添加
  ```xml
  <plugin>
      <groupId>org.mybatis.generator</groupId>
      <artifactId>mybatis-generator-maven-plugin</artifactId>
      <version>1.3.7</version>
      <configuration>
          <configurationFile>
             ${basedir}/src/main/resources/generator/generatorConfig.xml
      	</configurationFile>
          <overwrite>true</overwrite>
          <verbose>true</verbose>
      </configuration>
      <dependencies>
          <dependency>
              <groupId>mysql</groupId>
              <artifactId>mysql-connector-java</artifactId>
              <version>5.1.46</version>
          </dependency>
      </dependencies>
  </plugin>
  ```
- 配置[generatorConfig.xml](https://github.com/Miven666/SpringBoot-learing/blob/generator/springboo-mybatis/src/main/resources/generator/generatorConfig.xml)
