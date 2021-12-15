# Log4j

## log4j.properties

```properties
###set log levels###
log4j.rootLogger=info, stdout
###output to console###
log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.Target=System.out
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss.SSS}%5p --- [%15.15t] %-40.40c{2}: %m%n
```

