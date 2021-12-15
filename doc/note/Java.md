# Java

## 安装JDK

- `vim /etc/profile`
- ```shell
  export JAVA_HOME=/software/jdk1.8.0_181
  export JRE_HOME=$JAVA_HOME/jre
  export PATH=$PATH:$JAVA_HOME/bin
  export CLASSPATH=.:$JAVA_HOME/lib
  ```

- `source /etc/profile`
- `java -version`