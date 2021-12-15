# MySQL
- [官方文档](https://dev.mysql.com/doc/)

## Navicat Premium
- [官网下载](https://www.navicat.com.cn/download/navicat-premium)

## MySQL Shell
- [官网下载](https://dev.mysql.com/downloads/shell/)
- [官方文档](https://dev.mysql.com/doc/mysql-shell/8.0/en/)
## docker 安装
- 拉取官方镜像（我们这里选择5.7，如果不写后面的版本号则会自动拉取最新版
```shell
docker pull mysql:5.7   # 拉取 mysql 5.7
docker pull mysql       # 拉取最新版mysql镜像
```
- 运行容器
```shell
docker run -p 3306:3306 --name mysql \
-v /Users/miven/Software/mysql/conf:/etc/mysql \
-v /Users/miven/Software/mysql/logs:/var/log/mysql \
-v /Users/miven/Software/mysql/data:/var/lib/mysql \
-e MYSQL_ROOT_PASSWORD=root123 \
-d mysql:5.7.29
```
```shell
docker run -d -p 3306:3306 --name mysql --restart always -v /opt/mysql/conf:/etc/mysql -v /opt/mysql/logs:/var/log/mysql -v /opt/mysql/data:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=root123  mysql:5.7.29
```
```shell
docker run -d -p 3306:3306 --name mysql57 --restart always -v C:\opt\mysql\conf:/etc/mysql -v C:\opt\mysql\logs:/var/log/mysql -v C:\opt\mysql\data:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=root123 mysql:5.7.29
```

## SQL
### 删除表数据
- 让主键id 从1开始自增
```
truncate table "表名字"
或
DELETE FROM "表名字";  
ALTER TABLE "表名字" AUTO_INCREMENT=1;
```