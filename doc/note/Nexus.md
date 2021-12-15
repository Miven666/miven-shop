# nexus

### docker 搭建 nexus  管理 maven 私服，以及上传jar包

#### 安装 nexus

```shell
#搜索镜像
 $ docker search nexus;

 #拉取nexus镜像,选stars多的
 $ docker pull sonatype/nexus; 
 
 #运行pull的nexus
-id 创建守护式容器
--privileged=true 授予root权限（挂载多级目录必须为true，否则容器访问宿主机权限不足）
--name=名字 给你的容器起个名字
-p 宿主机端口：容器端口映射
-v 宿主机目录：容器目录 目录挂载

docker run -d -p 8081:8081 --name nexus -v /root/nexus-data:/var/nexus-data --restart=always sonatype/nexus3

 #docker常用命令
 $ docker ps                    #查看运行实例 
 $ docker ps -a             #查看全部实例
 $ docker inspect 容器id         #查询容器信息
 $ docker stop/start 容器id      #停止/开始容器id
 $ docker rm 容器id              #删除容器id
 $ docker exec -it 容器id bash  #进去容器内部 Exit退出
 $ docker stop nexus            #停止nexus
 $ docker start nexus           #启动nexus 启动时间大约1分钟
 $ docker cp 容器ID/容器name:容器目录 当前宿主机的文件      #文件从容器复制到宿主机
 $ docker cp 当前宿主机的文件 容器ID或者容器name:容器目录     #宿主机文件到容器

#访问
http://ip:8081/nexus

#默认密码
admin/admin123
# 新版本有所改变，查看
cat /nexus-data/admin.password
```

#### 配置本地Maven的settings.xml

```xml
<servers>
    <!--ID名字随意，需要和下面pom.xml一样，账号密码和nexus创建user一样，admin管理员-->
	<server>
	    <id>docker-nexus-release</id>
	    <username>admin</username>
	    <password>admin123</password>
    </server>
    <server>
        <id>docker-nexus-snapshot</id>
        <username>admin</username>
        <password>admin123</password>
    </server>
</servers>

<mirrors>
    <!-- 私服地址 -->
    <mirror>
        <id>deploy-release</id>
        <mirrorOf>central</mirrorOf>
        <name>deploy central</name>
        <url>http://192.168.138.129:8081/repository/maven-public/</url>
    </mirror>
</mirrors>
```

#### 配置pom.xml测试打包上传jar包

```xml
<distributionManagement>
    <!-- id要和settings.xml中server的一致 -->
    <repository>
        <id>docker-nexus-snapshot</id>
        <url>http://192.168.138.129:8081/nexus/content/repositories/snapshots/</url>
    </repository>
    <snapshotRepository>
        <id>docker-nexus-snapshot</id>
        <url>http://192.168.138.129:8081/nexus/content/repositories/snapshots/</url>
    </snapshotRepository>
</distributionManagement>

<profiles>
    <profile>
        <id>deploy-release</id>
        <distributionManagement>
            <repository>
                <id>docker-nexus-release</id>
                <url>http://192.168.138.129:8081/nexus/content/repositories/releases/</url>
            </repository>
        </distributionManagement>
    </profile>
</profiles>

<build>
    <plugins>
        <!--发布代码Jar插件-->
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-deploy-plugin</artifactId>
            <version>2.8.2</version>
        </plugin>
        <!--发布源码插件-->
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-source-plugin</artifactId>
            <version>3.1.0</version>
            <executions>
                <execution>
                    <phase>package</phase>
                    <goals>
                        <goal>jar</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```

