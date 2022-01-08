# Windows

### 双显示显示双任务栏
- 下载[Dual Monitor Taskbar ](http://www.dijiu.com/soft/114481.htm#fileurl)
- 设置功能
> 比如显示Windows按键、可以 镜像-两个任务栏控制同一个页面，也可以设置单独控制自己显示屏页面。

### CMD 命令
```shell
# 查看系统版本
winver
# 清屏
CLS
# 打开新窗口
start
# 打开系统属性（可配置系统环境变量）
sysdm.cpl
```
- [设置别名(alias)](https://www.pianshen.com/article/902432495/)

### 快捷键
- 打开地址栏 `ctl+F4`
- 最小化当前窗口 `Alt+Esc` `Alt+空格+n`
- 文件重命名 `F2`

### 项目结构输出成文件树
- 只有文件夹 `tree >> D:/tree.txt`
- 文件夹和文件 `tree /f >> D:/tree.txt`

### 端口与进程
- 查看所有端口 `netstat -ano`
- 查看指定端口PID `netstat -ano|findstr "8080"`
- 查看是哪个进程或者程序占用PID `tasklist | findstr "2027"`
- 结束进程 `taskkill /f /t /im javaw.exe`