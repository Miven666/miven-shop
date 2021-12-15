# Linux
## Linux 命令
- 查看环境变量： `env`
- 查看系统语言： `echo $LANG`
- 查看系统安装的语言包： `locale`
- 查看系统时间和时区：`date` 或 `date -R`
- 安装中文语言包: `yum groupinstall chinese-support`
- 临时更换语言: `LANG="en_US.UTF-8"`   中文为（`"zh_CN.UTF-8"`）
- 修改系统默认的语言: `vi /etc/sysconfig/i18n`
- 在启动java程序时加参数`-Duser.timezone=GMT+8`
- 查看防火墙状态：`firewall-cmd --state`
- 查看已经开放的端口：`firewall-cmd --list-ports`
- 开放80端口：`firewall-cmd --zone=public --add-port=80/tcp --permanent`
    - `--zone` #作用域
    - `--add-port=80/tcp`  #添加端口，格式为：端口/通讯协议
    - `--permanent`   #永久生效，没有此参数重启后失效
- 重启防火墙：`firewall-cmd --reload`
- 关闭防火墙： 
    - `service firewalld stop`
    - `systemctl stop firewalld.service`
- 禁止防火墙开机启动：`systemctl disable firewalld.service`
- 查看PID：
    - `ps -ef | grep java`
    - -v`:表示忽略grep本身: `ps -ef | grep java | grep -v grep`
    - grep进程的条目显示处理命令优先于正则表达式: `ps -ef | grep [j]ava`
- 查看端口号：`netstat -lptn (老婆太牛)`
- awk把文件逐行的读入，以空格为默认分隔符将每行切片，切开的部分再进行各种分析处理
- 查看nginx路径: `ps aux | grep nginx`
- 查看nginx配置文件路径: `/usr/sbin/nginx -t`
- 让/etc/profile文件修改后立即生效  `source /etc/profile` 或 `. /etc/profile`
- 修改密码：`passwd user`

### which(命令)
- 查找命令路径 `which git`
- 查找命令对应的真实路径(可能是软连接) `ls -al /usr/bin/git`

### whereis(文件或命令)
- 查找文件或者命令的所在目录 `whereis mysql`

### find(文件或文件夹)
- 查找根目录查找包含“java”字符文件或文件夹 `find / -name java`
- 查找在当前目录下，深度为一，以.jpg结尾文件，并将其转化 `find . -maxdepth 1 -name *.jpg -print -exec convert ` 
- 查找以 '.rpm' 结尾的文件并定义其权限 `find / -name *.rpm -exec chmod 755 '{}' \`
- 查找以 '.rpm' 结尾的文件，忽略光驱、捷盘等可移动设备 `find / -xdev -name \*.rpm`
- 查找系统中所有使用了SUID控制的文件 `ind / -perm -u+s`
- 查找属于用户 'user1' 的文件和目录 `find / -user user1` 
- 查找并复制所有以 '.txt' 结尾的文件到另一个目录 `find /home/user1 -name '*.txt' | xargs cp -av --target-directory=/home/backup/ --parents`  
- 查找在过去100天内未被使用过的执行文件 `find /usr/bin -type f -atime +100`
- 搜索在10天内被创建或者修改过的文件 `find /usr/bin -type f -mtime -10`
- 查找所有以 '.log' 结尾的文件并做成一个bzip包 `find /var/log -name '*.log' | tar cv --files-from=- | bzip2 > log.tar.bz2`

### yum(软件包)
- 查找软件包 `yum list docker`
- 查找已安装的软件包 `yum list installed`
- 所有已安裝的软件包信息 `yum info installed`

### rpm(软件包)
- 查找软件包  `rpm -q python`
- 查询某个包所有的安装文件 `rpm -ql python`
- 查找已安装的软件包 `rpm -qa`
- 查找软件包，根据命令 `rpm -qf java`
- 删除某个包 `rpm -e python`
- 安装 `rpm -i example.rpm`
- 安装并显示文件信息 `rpm -iv example.rpm`
- 安装并显示文件信息和进度 `rpm -ivh example.rpm `

### tar
- 解压到当前目录 `tar -zxvf test.tar.gz`
- 解压到指定目录 `tar -zxvf test.tar.gz ../`
- 压缩指定文件在当前目录 `tar -czvf test.tar.gz test`

### vim(vi)
- 在命令模式下，输入`/ 字符`  从头查找， 输入`？ 字符` 从尾查找
- 按下回车，可以看到vim把光标移动到该字符处
- 再按n（小写）查看下一个匹配
- 按N(大写）查看上一个匹配
- 取消高亮 `noh`、`set-noh`、`nohlsearch`、`set nohlsearch`

### less
- 在`:`直接输入百分比，跳转至指定百分比，如`:80%`
- 设置缓冲区的大小`less -b 10M`
- 当文件显示结束后，自动离开 `less -e file`
- 强迫打开特殊文件，例如外围设备代号、目录和二进制文件 `-f`
- 只标志最后搜索的关键词 `-g`
- 忽略搜索时的大小写 `-i`
- 显示类似more命令的百分比`-m`
- 显示每行的行号`-N`
- 将less 输出的内容在指定文件中保存起来`-o <文件名>`
- 不使用警告音`-Q`
- 显示连续空行为一行`-s`
- 行过长时间将超出部分舍弃`-S`
- 将"tab"键显示为规定的数字空格`-x <数字>`
- 向下搜索"字符串"的功能`/字符串`
- 向上搜索"字符串"的功能`?字符串`
- 重复前一个搜索（与 / 或 ? 有关）`n`
- 反向重复前一个搜索（与 / 或 ? 有关）`N`
- 向上翻一页`b`
- 向后翻半页`d`
- 显示帮助界面`h`
- 退出less 命令`Q`
- 向前滚动半页`u`
- 向前滚动一行`y`
- 滚动一页`空格键`
- 滚动一行`回车键`
- 向下翻动一页`[pagedown]`
- 向上翻动一页`[pageup]`

### cat
- 从最后一百行查找ABC`cat xxx.log | tail -n 100 | grep ABC`
- 从头一百行查找DE`cat xxx.log | head -n 100 | grep DE`
### free
- 查看内存使用情况 `free`
- 查看内存使用情况，M为单位 `free -h`

### top
- 查看资源管理器 `top`
- 切换显示单位：资源界面按`e`
- 查看资源并显示完整命令行：`top -c`或资源界面按`c`
- 查看指定用户 `top -u root`
- 查看指定进程 `top -p xxx`
- 按照cpu使用率进行排序显示`top -o  +%CPU`
- 按照内存使用率进行排序显示`top -o  +%MEM`

## Linux 文件
### Linux根目录`/`下各个系统文件夹的含义和用途
- `/boot` 该目录默认下存放的是Linux的启动文件和内核。
- `/initrd` 它的英文含义是boot loader initialized RAM disk,就是由boot loader初始化的内存盘。在linux内核启动前，boot loader会将存储介质(一般是硬盘)中的initrd文件加载到内存，内核启动时会在访问真正的根文件系统前先访问该内存中的initrd文件系统。
- `/bin` 该目录中存放Linux的常用命令。
- `/sbin` 该目录用来存放系统管理员使用的管理程序。
- `/var` 该目录存放那些经常被修改的文件，包括各种日志、数据文件。
- `/etc` 该目录存放系统管理时要用到的各种配置文件和子目录，例如网络配置文件、文件系统、X系统配置文件、设备配置信息、设置用户信息等。
- `/dev` 该目录包含了Linux系统中使用的所有外部设备，它实际上是访问这些外部设备的端口，访问这些外部设备与访问一个文件或一个目录没有区别。
- `/mnt` 临时将别的文件系统挂在该目录下。
- `/root` 如果你是以超级用户的身份登录的，这个就是超级用户的主目录。
- `/home` 如果建立一个名为“xx”的用户，那么在/home目录下就有一个对应的“/home/xx”路径，用来存放该用户的主目录。
- `/usr` 用户的应用程序和文件几乎都存放在该目录下。
- `/lib` 该目录用来存放系统动态链接共享库，几乎所有的应用程序都会用到该目录下的共享库。
- `/opt` 第三方软件在安装时默认会找这个目录,所以你没有安装此类软件时它是空的,但如果你一旦把它删除了,以后在安装此类软件时就有可能碰到麻烦。
- `/tmp` 用来存放不同程序执行时产生的临时文件，该目录会被系统自动清理干净。
- `/proc` 可以在该目录下获取系统信息，这些信息是在内存中由系统自己产生的，该目录的内容不在硬盘上而在内存里。
- `/misc` 可以让多用户堆积和临时转移自己的文件。
- `/lost＋found` 该目录在大多数情况下都是空的。但当突然停电、或者非正常关机后，有些文件就临时存放在这里。

### Linux文件颜色的含义：
- 蓝色为文件夹
- 绿色是可执行文件，可执行的程序
- 浅蓝色是链接文件
- 红框文件是加了SUID位，任意限权
- 红色为压缩文件或者包文件
- 褐色为设备文件
- 白色为一般性文件，如文本文件，配置文件，源码文件等

### 权限

> 横线代表空许可。r代表只读，w代表写，x代表可执行。注意这里共有10个位置。
第一个字符指定了文件类型。在通常意义上，一个目录也是一个文件。
如果第一个字符是横线，表示是一个非目录的文件。如果是d，表示是一个目录。
```
– rw- r–- r–-
普通文件 文件主 组用户 其他用户
```
> 将rwx看成二进制数，如果有则用1表示，没有则有0表示，那么rwx则可以表示成为：111

## 脚本
- run.sh
```shell script
#!/bin/bash
SpringBoot='ap-mgmt.jar'
function start()
{
    count=`ps -ef |grep java|grep $SpringBoot|grep -v grep|wc -l`
    if [ $count != 0 ];
    then
        echo "$SpringBoot is running..."
    else
        echo "Starting $SpringBoot "
        cd /home/migu/ap-mgmt
		Suffix=`date +%Y%m%d_%H%M`
	        cp $SpringBoot bak/$SpringBoot-$Suffix
		mv -f new/$SpringBoot ./
		nohup java -jar -Dmode=test $SpringBoot >> /dev/null 2>&1 &
    fi
}
function stop()
{
    echo "Stopping $SpringBoot"
    boot_id=`ps -ef |grep java|grep $SpringBoot|grep -v grep|awk '{print $2}'`
    count=`ps -ef |grep java|grep $SpringBoot|grep -v grep|wc -l`

    if [ $count != 0 ];then
        kill $boot_id
        count=`ps -ef |grep java|grep $SpringBoot|grep -v grep|wc -l`

        boot_id=`ps -ef |grep java|grep $SpringBoot|grep -v grep|awk '{print $2}'`
        kill -9 $boot_id
		echo "$SpringBoot $boot_id is killed"
    fi
	echo "$SpringBoot is stopped"
}
function restart()
{
    stop
    sleep 10
    start
}
restart
```
```shell script
#!/bin/bash
name='operationx_report'
version=$1
suffix='.jar'
app=$name-$version$suffix
dir=/home/version/operation_report/package
function start()
{
    count=`ps -ef | grep java | grep $name | grep -v grep | wc -l`
    if [ $count != 0 ];
    then
        echo "$app is running..."
    else
        echo "Starting $app "
        cd $dir
        nohup java -jar -Dmode=test $app >> /dev/null 2>&1 &
    fi
}
function stop()
{
    echo "Stopping $name"
    boot_id=`ps -ef |grep java|grep $name|grep -v grep|awk '{print $2}'`
    count=`ps -ef |grep java|grep $name|grep -v grep|wc -l`
    if [ $count != 0  ];
    then
        kill $boot_id
        count=`ps -ef |grep java|grep $name|grep -v grep|wc -l`
        boot_id=`ps -ef |grep java|grep $name|grep -v grep|awk '{print $2}'`
        kill -9 $boot_id
        echo "$name $boot_id is killed"
    fi
        echo "$name is stopped"
}
function run()
{
    stop
    sleep 10
    start
}
run
```
- start.sh
```shell script
#!/bin/bash
# 在shell中，每个进程都和三个系统文件相关联：标准输入stdin，标准输出stdout和标准错误stderr，三个系统文件的# 文件描述符分别为0，1和2。所以这里2>&1的意思就是将标准错误也输出到标准输出当中。
nohup java -jar usertask-0.5-SNAPSHOT.jar spring.profiles.active=test >./usertask.log 2>&1 &
```
- stop.sh
```shell script
#!/bin/bash
PID=$(ps -ef | grep usertask-0.5-SNAPSHOT.jar | grep -v grep | awk '{ print $2 }')
if [ -z "$PID" ]
then
    echo Application is already stopped
else
    echo kill $PID
    kill $PID
fi
```

### Rabbitmq启动命令
```shell script
docker stop rabbitmq3.7.7;
docker rm rabbitmq3.7.7;
docker run -d --name rabbitmq3.7.7 -p 5672:5672 -p 15672:15672 -v /var/log/rabbitmq:/var/log/rabbitmq -e RABBITMQ_DEFAULT_USER=admin -e RABBITMQ_DEFAULT_PASS=admin docker.io/rabbitmq:3.7.7-management
```

### springboot启动命令

```shell script
pid=`ps aux|grep handOfGod |grep -v grep |grep java |awk '{print $2}'`;
if [ "$pid" -gt 0 ]; then kill -9 $pid;fi
rm -rf   /usr/local/jar/handOfGod/handOfGod.jar
cp /opt/warfiles/target/handOfGod.jar  /usr/local/jar/handOfGod/
nohup java -jar /usr/local/jar/handOfGod/handOfGod.jar --spring.profile.active=test > handOfGod.log 2>&1 &
```

## 安装软件
- `yum install lrzsz`
- `yum -y install net-tools`