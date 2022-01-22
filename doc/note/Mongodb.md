# Mongodb
## MongoDB Shell
- [mongodb-shell文档地址](https://docs.mongodb.com/mongodb-shell/)
> MongoDB Shell是MongoDB自带的交互式Javascript shell,用来对MongoDB进行操作和管理的交互式环境。也可以根据文档下载单独的 mongosh

```shell script
cd /usr/local/mongodb/bin
./mongo
```
- 看已有数据库 `show dbs`
- 切换数据库 `use test`
- 查看已有集合 `show collections` 或 `show tables`
- 查看集合 
  + 默认查询所有 `db.name.find()`
  + 根据指定`key`值 db.name.fin({"key":"value"})
  + 美化查询 `db.name.find({"key":"value"}).pretty()`
- 创建集合 `db.createCollection(name, options)`
- 插入集合 `db.collection_name.insert(document)`
- 删除集合 `db.collection_name.drop(）`
- 删除集合所有内容 `db.collection_name.remove({})`
- 删除集合指定条件内容 `db.collection_name.remove(<query>,options)`
- 查看指定列 
  + 查看 id 和 title 列 `db.collection_name.find({}, {id:1,title:1})`
  + 查看 student 里的 name 列 `db.collection_name.find("student.name":"张三")`
  + 查看所有列除了 `content` `db.collection.find({}, {content:0})`

### 导出数据

```shell
#!/bin/bash

if [ ! $1 ]; then
        echo " Example of use: $0 database_name [dir_to_store]"
        exit 1
fi
db=$1
out_dir=$2
if [ ! $out_dir ]; then
        out_dir="./"
else
        mkdir -p $out_dir
fi

tmp_file="fadlfhsdofheinwvw.js"
echo "print('_ ' + db.getCollectionNames())" > $tmp_file
cols=`/usr/local/mongodb/bin/mongo $db $tmp_file | grep '_' | awk '{print $2}' | tr ',' ' '`
for c in $cols
do
    /usr/local/mongodb/bin/mongoexport -d $db -c $c -o "$out_dir/exp_${db}_${c}.json"
done
tar -czvf ${db}.tar.gz exp_* && rm -rf exp_*
rm $tmp_file
```



- 用上述脚本导出指定库	
- 上传至 ftp `put feeder.tar.gz`
- 远程连接 `mongodb/bin/mongo 10.125.145.104:55944/marketingdb -u m_marketing -p ELkVRIh1KoTQzFkCfM90`



## docker 安装
### 副本集安装
- https://www.cnblogs.com/sanduzxcvbnm/p/13937264.html

### 集群安装
 - 拉取镜像 `docker pull mongo`

 - 配置 IP 映射

   ```shell
   export node1=192.168.138.129
   export node2=192.168.138.130
   export node3=192.168.138.128
   ```

-  创建密钥文件，一台创建，然后另外两台复制过去（注意复制后权限）

  ```shell
  mkdir -p /root/mongo/keyfile
  cd /root/mongo/keyfile
  openssl rand -base64 741 > mongodb-keyfile
  chmod 600 mongodb-keyfile
  chown 999 mongodb-keyfile
  ```

- 启动容器

  ```shell
  docker run --name mongo \
  -v /root/mongo/data:/data/db \
  -v /root/mongo/keyfile:/opt/keyfile \
  --hostname="node1.miven.com" \
  -p 27017:27017 \
  -d mongo:latest
  ```
  
  ```shell
  docker run -d -p 27017:27017 --name mongo422 --restart always -v C:\opt\mongo\data\db:/data/db mongo:4.2.2
  ```

- 进入容器

  ```shell
  docker exec -it mongo /bin/bash
  ```

- 进入`mongo`交互界面，切换至`admin`，创建新用户

  ```shell
   mongo
   use admin
   db.createUser({user: "userAdmin",pwd: "userAdmin123",roles: [{role:"userAdminAnyDatabase", db: "admin"}]});
   db.createUser({user: "admin",pwd: "admin123",roles: [{role:"root", db: "admin"}]});
   exit
  ```

- 停止并删除容器

  ```shell
  docker stop mongo
  docker rm mongo
  ```

- 使用密钥，启动第一台主节点

  ```shell
  docker run --name mongo \
  -v /root/mongo/data:/data/db \
  -v /root/mongo/keyfile:/opt/keyfile \
  --hostname="node1.miven.com" \
  --add-host node1.miven.com:${node1} \
  --add-host node2.miven.com:${node2} \
  --add-host node3.miven.com:${node3} \
  -p 27017:27017 -d mongo:latest \
  --keyFile /opt/keyfile/mongodb-keyfile \
  --replSet "rs0"
  ```

- 进入容器，认证登录，开启副本集， 验证 副本集配置

  ```shell
  docker exec -it mongo /bin/bash
  mongo
  use admin
  db.auth("admin","admin123")
  rs.initiate()
  rs.conf()
  ```

- 在其它节点上启动`mongo`

  ```shell
  docker run --name mongo \
  -v /root/mongo/data:/data/db \
  -v /root/mongo/keyfile:/opt/keyfile \
  --hostname="node2.miven.com" \
  --add-host node1.miven.com:${node1} \
  --add-host node2.miven.com:${node2} \
  --add-host node3.miven.com:${node3} \
  -p 27017:27017 -d mongo:latest \
  --keyFile /opt/keyfile/mongodb-keyfile \
  --replSet "rs0"
  
  docker run --name mongo \
  -v /root/mongo/data:/data/db \
  -v /root/mongo/keyfile:/opt/keyfile \
  --hostname="node3.miven.com" \
  --add-host node1.miven.com:${node1} \
  --add-host node2.miven.com:${node2} \
  --add-host node3.miven.com:${node3} \
  -p 27017:27017 -d mongo:latest \
  --keyFile /opt/keyfile/mongodb-keyfile \
  --replSet "rs0"
  ```

- 将新建的节点添加到主节点副本集上，并验证

  ```shell
  rs.add("node2.miven.com")
  rs.add("node3.miven.com")
  rs.status()
  ```

  

