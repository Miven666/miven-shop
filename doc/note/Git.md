# Git

[官网下载地址](https://git-scm.com/downloads)

## 简史
同生活中的许多伟大事物一样，Git 诞生于一个极富纷争大举创新的年代。

Linux 内核开源项目有着为数众广的参与者。
绝大多数的 Linux 内核维护工作都花在了提交补丁和保存归档的繁琐事务上(1991－2002年间)。
到 2002 年，整个项目组开始启用一个专有的分布式版本控制系统 BitKeeper 来管理和维护代码。

到了 2005 年，开发 BitKeeper 的商业公司同 Linux 内核开源社区的合作关系结束，他们收回了 Linux 内核社区免费使用 BitKeeper 的权力。
这就迫使 Linux 开源社区(特别是 Linux 的缔造者 Linus Torvalds)基于使用 BitKeeper 时的经验教训，开发出自己的版本系统。
他们对新的系统制订了若干目标：
- 速度很快
- 设计简单
- 对非线性开发模式的强力支持(允许成千上万个并行开发的分支)
- 完全分布式
- 有能力高效管理类似 Linux 内核一样的超大规模项目(速度和数据量)

## 安装
- Linux 安装
    - yum安装 `yum install git`
    - 查看版本 `git --version`
    - [安装最新版教程地址](https://www.cnblogs.com/BinBinStory/p/7113956.html)

## 场景
### 忽略文件
```
# gitignore需要忽略子目录中，拥有某后缀的文件，用**代表所有子目录
**/*.iml
```
### 删除远程仓库文件但不删除本地仓库资源

```shell
git rm -r --cached .idea
git add .idea //若.gitignore文件已经忽略，可不执行此语句
git commit -m 'ignore .idea'
git push
```
### 和远程进行比较 

```shell
git diff demo.md
```
### 提交指定文件
```shell
git add xxx
git commit -m "xxx"
```
### 修改密码

```shell
# 输入这个命令后,以后只要在输入一次用户名密码
git config --global credential.helper store
```
### 查看用户名和邮箱地址

```shell
git config user.name
git config user.email
```
### 修改用户名和邮箱地址

```shell
git config --global user.name "mingzhi.xie"
git config --global user.email "xie6032mail@163.com"
```

### 多仓库同步

```shell
git remote set-url --add origin git@gitee.com:/Miven666/spring-learning.git
```

### 误提交补救

```shell
# 必须未推送至远程
# -i 进入编辑模式
# SHA 是误提交之前的那次提交
# squash 表示所在提交合并进前一次提交
git rebase -i [SHA]
```

### 拉取指定用户提交记录并保存到文件
```shell
git log --date=iso --pretty=format:"%h","%an","%ad","%s"  |grep "mingzhi.xie" >> ~/Work/file/demo.csv
```
