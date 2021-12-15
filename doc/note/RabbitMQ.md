# RabbitMQ

## 安装

### Docker 安装

- [官方镜像](https://registry.hub.docker.com/_/rabbitmq/?tab=description)

- 拉取镜像(已经启用 web 管理界面插件)

  ```shell
  docker pull rabbitmq:management
  ```
  
- 启动镜像，运行容器

  ```shell
  docker run --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:management
  --rm 自动删除已经存在的容器
  ```

## 访问

- 访问界面地址 `host:15672` 
- 默认账号密码  `guest/guest` 
- 自定义账号密码 `login-dev/123456`

