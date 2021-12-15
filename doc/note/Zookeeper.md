# ZooKeeper

Zookeeper是Apacahe Hadoop的子项目，是一个树型的目录服务，支持变更推送，适合作为Dubbo服务的注册中心，工业强度较高，可用于生产环境，并推荐使用。

1. 可以作为集群的管理工具使用。
2. 可以集中管理配置文件。

注册中心负责服务地址的注册与查找，相当于目录服务，服务提供者和消费者只在启动时与注册中心交互，注册中心不转发请求，压力较小。

[官方下载地址](http://zookeeper.apache.org/releases.html#download)

### Zookeeper的安装
- 安装环境：
    - Linux：CentOS
    - JDK:1.7以上版本

    Zookeeper是Java开发的可以运行在windows、linux环境。需要先安装JDK。
    安装步骤：

- 第一步：安装jdk

- 第二步：把zookeeper的压缩包上传到linux系统。

- 第三步：解压缩压缩包 `tar -zxvf zookeeper-3.4.6.tar.gz`

- 第四步：进入zookeeper-3.4.6目录，创建data文件夹。

- 第五步：把zoo_sample.cfg改名为zoo.cfg `[root@localhost conf]# mv zoo_sample.cfg zoo.cfg`

- 第六步：修改data属性：dataDir=/root/zookeeper-3.4.6/data

- 第七步：启动zookeeper `[root@localhost bin]# ./zkServer.sh start`
    - 关闭：`[root@localhost bin]# ./zkServer.sh stop`
    - 查看状态：`[root@localhost bin]# ./zkServer.sh status`

- 注意：需要关闭服务器防火墙

    `systemctl stop firewalld.service #停止firewall`

    `systemctl disable firewalld.service #禁止firewall开机启动`

### 日志输出到指定文件夹

- 修改log4j.properties

  ```shell
  # 修改控制台输出为 滚动策略
  zookeeper.root.logger=INFO,ROLLINGFILE
  # 按日滚动
  log4j.appender.ROLLINGFILE=org.apache.log4j.DailyRollingFileAppender
  # 取消满10MB才滚动的策略
  #log4j.appender.ROLLINGFILE.MaxFileSize=10MB
  ```

- 修改zkEnv.sh

  ```shell
  then
      ZOO_LOG_DIR="/var/log/zookeeper"
  fi
  then
      ZOO_LOG4J_PROP="INFO,ROLLINGFILE"
  fi
  ```

- 修改zkServer.sh

  ```shell
  # 消除zookeeper.out
  _ZOO_DAEMON_OUT="$ZOO_LOG_DIR/zookeeper.log"
  ```

### docker 安装

#### 单机

- 获取官方镜像 `docker pull zookeeper:3.6.0`

- 运行容器 

  ```shell
  docker run -d -p 2181:2181 -p 2888:2888 -p 3888:3888 \
  -v /Users/miven/Software/zookeeper/volumes/data:/data \
  -v /Users/miven/Software/zookeeper/volumes/datalog:/datalog \
  -v /Users/miven/Software/zookeeper/volumes/logs:/logs \
  --name zookeeper zookeeper:3.6.0
  ```
  
- 进入容器检查是否启动成功

  ```shell
  docker exec -it zookeeper:3.6.0 bash
  ./bin/zkCli.sh
  ```

#### 集群

##### 创建桥接网络

```shell
docker network create --driver bridge --subnet=172.18.0.0/16 --gateway=172.18.0.1 zookeeper
```

##### 手动方式

- 运行容器

  ```shell
  docker run -d -p 21811:2181 \
  -v /Users/miven/Software/zookeeper-cluster/node1/volumes/data:/data \
  -v /Users/miven/Software/zookeeper-cluster/node1/volumes/datalog:/datalog \
  -v /Users/miven/Software/zookeeper-cluster/node1/volumes/logs:/logs \
  -e ZOO_MY_ID=1 \
  -e "ZOO_SERVERS=server.1=172.18.0.2:2888:3888;2181 server.2=172.18.0.3:2888:3888;2181 server.3=172.18.0.4:2888:3888;2181" \
  --network zookeeper --ip 172.18.0.2 \
  --privileged \
  --name zookeeper_node1 zookeeper:3.6.0
   
   docker run -d -p 21812:2181 \
  -v /Users/miven/Software/zookeeper-cluster/node2/volumes/data:/data \
  -v /Users/miven/Software/zookeeper-cluster/node2/volumes/datalog:/datalog \
  -v /Users/miven/Software/zookeeper-cluster/node2/volumes/logs:/logs \
  -e ZOO_MY_ID=2 \
  -e "ZOO_SERVERS=server.1=172.18.0.2:2888:3888;2181 server.2=172.18.0.3:2888:3888;2181 server.3=172.18.0.4:2888:3888;2181" \
  --network zookeeper --ip 172.18.0.3 \
  --privileged \
  --name zookeeper_node2 zookeeper:3.6.0
   
   docker run -d -p 22813:2181 \
  -v /Users/miven/Software/zookeeper-cluster/node3/volumes/data:/data \
  -v /Users/miven/Software/zookeeper-cluster/node3/volumes/datalog:/datalog \
  -v /Users/miven/Software/zookeeper-cluster/node3/volumes/logs:/logs \
  -e ZOO_MY_ID=3 \
  -e "ZOO_SERVERS=server.1=172.18.0.2:2888:3888;2181 server.2=172.18.0.3:2888:3888;2181 server.3=172.18.0.4:2888:3888;2181" \
  --network zookeeper --ip 172.18.0.4 \
  --privileged \
--name zookeeper_node3 zookeeper:3.6.0
  
  ```
  
- compose安装

  ```yaml
  version: '3.6'
  
  services:
    node4:
      image: zookeeper:3.6.0
      privileged: true
      hostname: zoo4
      ports:
        - 21814:2181
      volumes:
        - /Users/miven/Software/zookeeper-cluster/node4/data:/data
        - /Users/miven/Software/zookeeper-cluster/node4/datalog:/datalog
        - /Users/miven/Software/zookeeper-cluster/node4/logs:/logs
      environment:
        ZOO_MY_ID: 4
        ZOO_SERVERS: server.4=0.0.0.0:2888:3888;2181 server.5=zoo5:2888:3888;2181 server.6=zoo6:2888:3888;2181
      networks:
        default:
          ipv4_address: 172.18.0.5
  
    node5:
      image: zookeeper:3.6.0
      privileged: true
      hostname: zoo5
      ports:
        - 21815:2181
      volumes:
        - /Users/miven/Software/zookeeper-cluster/node5/data:/data
        - /Users/miven/Software/zookeeper-cluster/node5/datalog:/datalog
        - /Users/miven/Software/zookeeper-cluster/node5/logs:/logs
      environment:
        ZOO_MY_ID: 5
        ZOO_SERVERS: server.4=zoo4:2888:3888;2181 server.5=0.0.0.0:2888:3888;2181 server.6=zoo6:2888:3888;2181
      networks:
        default:
          ipv4_address: 172.18.0.6
  
    node6:
      image: zookeeper:3.6.0
      privileged: true
      hostname: zoo6
      ports:
        - 21816:2181
      volumes:
        - /Users/miven/Software/zookeeper-cluster/node6/data:/data
        - /Users/miven/Software/zookeeper-cluster/node6/datalog:/datalog
        - /Users/miven/Software/zookeeper-cluster/nod6/logs:/logs
      environment:
        ZOO_MY_ID: 6
        ZOO_SERVERS: server.4=zoo4:2888:3888;2181 server.5=zoo5:2888:3888;2181 server.6=0.0.0.0:2888:3888;2181
      networks:
        default:
          ipv4_address: 172.18.0.7
  
  networks: # 自定义网络
    default:
      external:
        name: zookeeper
  ```

  
