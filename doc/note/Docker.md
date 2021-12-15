# Docker

[docker文档](https://docs.docker.com/)

## 安装Docker CE

- [yum安装](https://docs.docker.com/install/linux/docker-ce/centos/#install-using-the-repository)
- [rpm安装](https://docs.docker.com/install/linux/docker-ce/centos/#install-from-a-package)
- [脚本安装](https://docs.docker.com/install/linux/docker-ce/centos/#install-using-the-convenience-script)

## 启动关闭
- 启动 `systemctl start docker`
- 守护进程重启 `sudo systemctl daemon-reload`
- 重启 ` systemctl restart docker`
- 重启 `sudo service docker restart`
- 关闭`systemctl stop docker`
- 关闭 `service docker stop`

## 镜像加速器

- 配置镜像地址

   在 `/etc/docker/daemon.json` 中写入如下内容（如果文件不存在请新建该文件） 

  ```json
  {
    "registry-mirrors": [
      "https://fwn4ll0a.mirror.aliyuncs.com",
      "https://dockerhub.azk8s.cn",
      "https://hub-mirror.c.163.com"
    ]
  }
  ```

  

## 开放远程端口

- 编辑配置

  ```shell
  vim /usr/lib/systemd/system/docker.service
  # 在ExecStart=/usr/bin/dockerd-current 后面加上
  -H tcp://0.0.0.0:2375 -H unix://var/run/docker.sock
  ```

- 重启服务

  ```shell
  systemctl daemon-reload
  systemctl restart docker
  ```

- 查看网络端口，确认守护进程被监听

  ```shell
  # 若未安装，先安装下 yum install net-tools
  netstat -tulp
  ```

- 防火墙设置

  ```shell
  # 开放 2375 端口
  firewall-cmd --zone=public --add-port=2375/tcp --permanent
  # 重启防火墙
  firewall-cmd --reload
  ```

## 容器

- 进入容器 `docker exec -it 容器ID /bin/bash `
- 更新容器不重启 `docker update --restart=no 容器`
- 更新容器重启 `docker update --restart=always 容器`

## 桥接网络（bridge）

> 创建容器的时候指定ip

- 创建

  ```shell
  docker network create --driver bridge --subnet=172.18.0.0/16 --gateway=172.18.0.1 zookeeper
  ```

- 查看所有网络

  ```shell
  docker network ls
  ```

- 查看指定网络

  ```shell
  docker network inspect zookeeper
  ```

  

## 安装 docker-compose

- [官网安装文档](https://docs.docker.com/compose/install/)

