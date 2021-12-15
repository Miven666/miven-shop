# Maven
## 下载
- [官方网站](http://maven.apache.org)
- Maven是使用java开发，需要安装JDK1.6以上
## 安装
- 第一步：安装JDK1.6及以上 
- 第二步：将maven下载的压缩包进行解压缩
- 第三步：配置maven的环境变量MAVEN_HOME
- 第四步：配置maven的环境变量PATH
- 第五步：测试maven是否安装成功，在系统命令行中执行命令：mvn –v
## 配置
> 在maven中有两个配置文件：用户配置、全局配置（默认） 
- 全局配置 :
    在maven安装目录的conf里面有一个settings.xml文件，这个文件就是maven的全局配置文件。该文件中配置来maven本地仓库的地址默认在系统的用户目录下的m2/repository中，该目录是本地仓库的目录。
## 概念
### 仓库
> 在 Maven 的术语中，仓库是一个位置(place)，例如目录，可以存储所有的工程 jar 文件、library jar 文 件、插件或任何其他的工程指定的文件。严格意义上说，Maven 只有两种类型的仓库: 本地(local)、远程(remote)
- 本地仓库
  Maven 的本地仓库是机器上的一个文件夹。它在你第一次运行任何 maven 命令的时候创建。
  Maven 的本地仓库保存你的工程的所有依赖(library jar、plugin jar 等)。当你运行一次 Maven 构建时，Maven 会自动下载所有依赖的 jar 文件到本地仓库中。它避免了每次构建时都引用存放在远程仓库上的依赖文件。
  Maven 的本地仓库默认被创建在 **${user.home}/.m2/repository** 目录下。要修改默认位置，只要在 settings.xml 文件中定义另一个路径即可，例如：
  ```xml
  <localRepository>/anotherDirectory/.m2/respository</localRepository>
  ```
- 远程仓库
  Maven 的远程仓库可以是任何其他类型的存储库，可通过各种协议，例如 `file：//`和 `http：//` 来访问。
  这些存储库可以是由第三方提供的可供下载的远程仓库，例如Maven 的中央仓库(central repository)：
  ```
  repo.maven.apache.org/maven2
  uk.maven.org/maven2
  ```
- 中央仓库
  Maven 的中央仓库是 Maven 社区维护的，里面包含了大量常用的库，我们可以直接引用，但是前提是我们的项目能够访问外网。
- 私有仓库
  通常都是企业内部创建的一个私有库，用于一些内部jar包的维护与共享。
- 获取流程
  + 本地仓库
  + 私有仓库
  + 中央仓库
```xml
<project>
...
    <profiles>
        <profile>
            <id>central</id>         
            <repositories>
                <repository>
                    <id>Central</id>
                    <name>Central</name>
                    <url>http://repo.maven.apache.org/maven2/</url>
                </repository>
            </repositories>
        </profile>
    </profiles>
    <activeProfiles>
        <activeProfile>central</activeProfile>
    </activeProfiles>
...
</project>
```

### 镜像

`Mirror` 则相当于一个代理，它会拦截去指定的远程 `Repository` 下载构件的请求，然后从自己这里找出构件回送给客户端。配置 `Mirror` 的目的一般是出于网速考虑。

```xml
<settings>
  ...
  <mirrors>
    <mirror>
      <id>maven.net.cn</id>
      <mirrorOf>central</mirrorOf>
      <name>one of the central mirrors in china</name>
      <url>http://maven.net.cn/content/groups/public/</url>
    </mirror>
  </mirrors>
  ...
</settings>
```

### 生命周期
  三个内置的构建生命周期： `default`， `clean` 和 `site`。

- `default` 生命周期
  + 验证`validate`
  + 编译`complile`
  + 测试`test`
  + 打包`package`
  + 检查`verify`
  + 安装`install`
  + 部署`deploy`

### 坐标

- groupId：表示一个团体，可以是公司、组织等
- artifactId：表示团体下的某个项目
- version：表示某个项目的版本号

### 依赖

> Maven 核心特点之一是依赖管理。一旦我们开始处理多模块工程(包含数百个子模块或者子工程)的时候，模块 间的依赖关系就变得非常复杂，管理也变得很困难。针对此种情形，Maven 提供了一种高度控制的方法。

- 依赖传递

- 依赖冲突

- 声明优先

- 短路优先

- 依赖排除

  ```xml
  <exclusions>
      <exclusion>
          <groupId>excluded.groupId</groupId>
          <artifactId>excluded-artifactId</artifactId>
      </exclusion>
  </exclusions>
  ```

### 依赖管理

- 聚合

  ```xml
  <packaging>pom</packaging>
  <modules>
       <module>module-1</module>
       <module>module-2</module>
       <module>module-3</module>
  </modules>
  ```

- 继承

  dependencies 即使在子项目中不写该依赖项，那么子项目仍然会从父项目中继承该依赖项（全部继承）。
  dependencyManagement 里只是声明依赖，并不实现引入，因此子项目需要显示的声明需要用的依赖。如果不在子项目中声明依赖，是不会从父项目中继承下来的；只有在子项目中写了该依赖项，并且没有指定具体版本，才会从父项目中继承该项，并且version和scope都读取自父pom;另外如果子项目中指定了版本号，那么会使用子项目中指定的jar版本。

  + 父pom

  ```xml
  <groupId>com.houyi</groupId>
  <artifactId>maven-parent</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <dependencyManagement>
     <dependencies>
          <dependency>
              <groupId>junit</groupId>
              <artifactId>junit</artifactId>
              <version>${junit.version}</version>
              <scope>test</scope>
        </dependency>
        <dependency>
             <groupId>mysql</groupId>
             <artifactId>mysql-connector-java</artifactId>
             <version>5.1.30</version>
        </dependency>
     </dependencies>
  </dependencyManagement>
  ```

  + 子pom

  ```xml
  <!-- 指定parent，说明是从哪个pom继承 -->
  <parent>
     <groupId>com.houyi</groupId>
     <artifactId>maven-parent</artifactId>
     <version>0.0.1-SNAPSHOT</version>
     <!-- 指定相对路径 -->
     <relativePath>../maven-parent</relativePath>
  </parent>
  
  <!-- 只需要指明groupId + artifactId，就可以到父pom找到了，无需指明版本 -->
  <dependencies>
     <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
     </dependency>
     <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
      </dependency>
  </dependencies>
  ```
### 插件

插件是 Maven 的核心，所有执行的操作都是基于插件来完成的。为了让一个插件中可以实现众多的相类似的功能，Maven 为插件设定了目标，一个插件中有可能有多个目标。其实生命周期中的每个阶段都是由插件的一个具体目标来执行的。例如可以用下面的方式配置一个插件：

```xml
<build>
   <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-source-plugin</artifactId>
            <version>2.2.1</version>
            <!-- 配置执行 -->
            <executions>
                 <execution>
                     <phase>package</phase>
                     <goals>
                        <goal>jar-no-fork</goal>
                     </goals>
                 </execution>
              </executions>
          </plugin>
       </plugins>
</build>
```

配置目标 goal 的目的是：这样在执行 `mvn package` 的时候，就会自动执行 `mvn source:jar-no-fork`了，jar-no-fork这个目标是用来进行源码打包的。

除了可以在build元素中配置插件，当然也可以在parent项目中，用pluginManagement来配置，然后在子项目继承即可使用。

## 命令

> Maven的命令要在pom.xml所在目录中去执行，可在pom.xml所在文件夹中按住shift右键，点击“在此处启动命令窗口” 

### 指令

- 显示版本 `mvn -version`
- 编译 `mvn compile`
- 清除 `mvn clean` 
- 测试 `mvn test` 
- 打包 `mvn package` 
- 安装 `mvn install` 
- 部署 `mvn deploy`
- 生成项目相关信息的网站 `mvn site`
- 生成依赖树 `mvn dependency:tree`
- 生成骨架项目 `mvn archetype:generate`
- 在`tomcat`中运行 `mvn tomcat:run`
- 在`jetty`中运行 `mvn jetty:run`
- 先清空再编译 `mvn clean compile` 
- 先清空再测试 `mvn clean test`
- 先清空再测试 `mvn clean package`
- 先清空再安装 `mvn clean install`

### 参数

- `-D` 传入属性参数

  比如命令： `mvn package -Dmaven.test.skip=true`以 `-D`开头，将 `maven.test.skip` 的值设为 `true` ,就是告诉maven打包的时候跳过单元测试。

  同理， `mvn deploy -Dmaven.test.skip=true` 代表部署项目并跳过单元测试。

- `-P` 使用指定`Profile`配置

  比如项目开发需要有多个环境，一般为开发，测试，预发，正式4个环境，在pom.xml中的配置如下：

  ```xml
  <profiles> 
  	<profile> 
  		<id>dev</id> 
  		<properties> 
  			<env>dev</env> 
  		</properties> 
  		<activation> 
  			<activeByDefault>true</activeByDefault> 
  		</activation> 
  	</profile> 
  	<profile> 
  		<id>qa</id> 
  		<properties> 
  			<env>qa</env> 
  		</properties> 
  	</profile> 
  	<profile> 
  		<id>pre</id> 
  		<properties> 
  			<env>pre</env> 
  		</properties> 
  	</profile> 
  	<profile> 
  		<id>prod</id> 
  		<properties> 
  			<env>prod</env> 
  		</properties> 
  	</profile> 
  </profiles>
  ... 
  <build> 
  	<filters> 
  		<filter>config/${env}.properties </filter> 
  	</filters> 
  	<resources> 
  		<resource> 
  			<directory>src/main/resources </directory> 
  			<filtering>true</filtering> 
  		</resource> 
  	</resources> 
  </build>
  ```

  `profiles`定义了各个环境的变量 `id`， `filters`中定义了变量配置文件的地址，其中地址中的环境变量就是上面 `profile`中定义的值， `resources`中是定义哪些目录下的文件会被配置文件中定义的变量替换。

  通过`maven`命令`mvn package -P dev` 可以实现按不同环境进行打包部署，其中 `dev` 为环境的变量id,代表使用Id为 `dev` 的 `profile`。

- `-e` 显示maven运行出错的信息

- `-o` 离线执行命令,即不去远程仓库更新包

- `-X` 显示maven允许的debug信息

- `-U` 强制去远程更新snapshot的插件或依赖，默认每天只更新一次

### 部署和安装
- 将自己的jar包安装到仓库
```shell
mvn install:install-file -Dfile=/Users/miven/Work/lib/migucore/migucore-0.0.1-SNAPSHOT.jar -DgroupId=com.migu -DartifactId=migucore -Dversion=0.0.1-SNAPSHOT -Dpackaging=jar -DpomFile=pom.xml

mvn install:install-file -Dfile=/Users/miven/Work/lib/ABCacheV2/ABCacheV2-0.0.1-SNAPSHOT.jar -DgroupId=com.migu -DartifactId=ABCacheV2 -Dversion=0.0.1-SNAPSHOT -Dpackaging=jar -DpomFile=pom.xml
```
- 将自己的jar包部署到远程仓库去

```shell
mvn deploy:deploy-file -Dfile=/Users/miven/Work/lib/migucore/migucore-0.0.1-SNAPSHOT.jar -DgroupId=com.migu -DartifactId=migucore -Dversion=0.0.1-SNAPSHOT -Dpackaging=jar -DrepositoryId=nexus -Durl=http://120.204.115.134:8081/repository/maven-snapshots -DpomFile=pom.xml

mvn deploy:deploy-file -Dfile=/Users/miven/Work/lib/ABCache/ABCache-0.0.1-SNAPSHOT.jar -DgroupId=com.migu -DartifactId=ABCache -Dversion=0.0.1-SNAPSHOT -Dpackaging=jar -DrepositoryId=nexus -Durl=http://120.204.115.134:8081/repository/maven-snapshots -DpomFile=pom.xml

mvn deploy:deploy-file -Dfile=/Users/miven/Work/lib/ABCacheV2/ABCacheV2-0.0.1-SNAPSHOT.jar -DgroupId=com.migu -DartifactId=ABCacheV2 -Dversion=0.0.1-SNAPSHOT -Dpackaging=jar -DrepositoryId=nexus -Durl=http://120.204.115.134:8081/repository/maven-snapshots -DpomFile=pom.xml

mvn deploy:deploy-file -Dfile=/Users/miven/Work/lib/sso-filter/sso-filter-0.0.1.jar -DgroupId=com.migu -DartifactId=sso-filter -Dversion=0.0.1 -Dpackaging=jar -DrepositoryId=nexus -Durl=http://120.204.115.134:8081/repository/maven-releases -DpomFile=pom.xml
```


### Spring Boot打jar包，排除lombok等scope=provided的依赖
```xml
<plugins>
     <plugin>
         <groupId>org.springframework.boot</groupId>
         <artifactId>spring-boot-maven-plugin</artifactId>
         <configuration>
             <excludes>
                 <exclude>
                     <groupId>org.projectlombok</groupId>
                     <artifactId>lombok</artifactId>
                 </exclude>
             </excludes>
         </configuration>
     </plugin>
 </plugins> 
```