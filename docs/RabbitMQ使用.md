# RabbitMQ使用

## docker安装

> 关于docker安装与启动自行查阅官方文档,或者在docs/docker笔记中查阅
>
> https://docs.docker.com/engine/install/centos/
>
> 以CentOS为例

## docker拉取镜像

```shell
#拉取镜像
docker pull rabbitmq:3.8-management
#创建容器启动
docker run -d --restart=always -p 5672:5672 -p 15672:15672 --name rabbitmq rabbitmq:3.8-management
```

## 测试

在浏览器输入**http://虚拟机IP:15672**进行访问

![image-20230617122018912](RabbitMQ%E4%BD%BF%E7%94%A8.assets/image-20230617122018912.png)

> 默认登录用户名/密码: guest/guest

## SpringBoot整合RabbitMQ

### 导入依赖

> 本工程依赖在rabbit-utils内

```xml
<dependencies>
    <!--rabbitmq消息队列-->
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-bus-amqp</artifactId>
    </dependency>
</dependencies>
```

### 配置

> 在包含接口的模块中添加RabbitMQ配置，商品上下架接口在service-product模块

```yaml
spring:
  #RabbitMQ配置
  rabbitmq:
    host: 10.2.87.200
    port: 5672
    username: guest
    password: guest
    publisher-confirm-type: CORRELATED  #发布确认模式，消息是否被成功发送到交换机
    publisher-returns: true
    listener:
      simple:
        prefetch: 1
        concurrency: 3
        acknowledge-mode: manual   #消费端手动确认
```

> 注意，RabbitMQ配置在Spring中，注意缩进

### 其他参考源码

