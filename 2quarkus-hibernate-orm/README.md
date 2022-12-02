### quarkus.hibernate-orm.database.generation：有六个取值，如下表
```
取值	含义
none	啥也不做
create	第一次启动会建表，之后启动不会再改动
drop-and-create	每一次启动应用的时候都删表(数据也没了)，然后建表，再执行import.sql导入数据
drop	启动应用的时候删表，不删库
update	保留数据，升级表结构
validate	检查表结构与entity是否匹配
```

### 指定配置文件启动
-ea -Dquarkus.profile=test

### hibernate-reactive-panache
https://quarkus.io/guides/hibernate-reactive-panache

## 问题
## 0.非阻塞数据库配置
quarkus.datasource.reactive.url=vertx-reactive:mysql://localhost:3307/dewen_quarkus
## 1.阻塞jdbc和非阻塞不要同时使用
出现了：Booting an Hibernate Reactive serviceregistry on a non-reactive RecordedState!
## 2.事务
添加 @ReactiveTransactional 注解