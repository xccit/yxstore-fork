# Nacos使用

## 下载安装

[Releases · alibaba/nacos (github.com)](https://github.com/alibaba/nacos/releases)

## 官方文档

[Authorization (nacos.io)](https://nacos.io/zh-cn/docs/v2/guide/user/auth.html)

## 配置密钥

在nacos/conf/application.properties中(大概156行)配置

```pro
nacos.core.auth.plugin.nacos.token.secret.key=SecretKey012345678901234567890123456789012345678901234567890123456789
```

注意:此处的密钥为官网默认值,实际使用中可以使用JWT等工具自主生成,使用BASE64编码,详情参考官网文档

## 启动Nacos

> 进入nacos/bin/  启动cmd

```shell
startup.cmd -m standalone
```

![image-20230616112905431](Nacos%E4%BD%BF%E7%94%A8.assets/image-20230616112905431.png)

## 测试

http://localhost:8848/nacos

> username: nacos
>
> password: nacos

## 提示鉴权未开启

![image-20230616120118538](Nacos%E4%BD%BF%E7%94%A8.assets/image-20230616120118538.png)

配置文件中配置此处,将默认的false换成true(大概138行)

```pro
nacos.core.auth.enabled=true
```

开启鉴权后启动时会提示有两个配置需要配:

![image-20230616113855399](Nacos%E4%BD%BF%E7%94%A8.assets/image-20230616113855399.png)

官网文档如下:

| nacos.core.auth.server.identity.key   | serverIdentity(2.2.1后无默认值) | 1.4.1 ~ latest | 用于替换useragent白名单的身份识别key，**使用默认值有安全风险** |
| ------------------------------------- | ------------------------------- | -------------- | ------------------------------------------------------------ |
| nacos.core.auth.server.identity.value | security(2.2.1后无默认值)       | 1.4.1 ~ latest | 用于替换useragent白名单的身份识别value，**使用默认值有安全风险** |

我的配置:

nacos.core.auth.server.identity.key=nacos

nacos.core.auth.server.identity.value=nacos

## 开启鉴权后测试

![image-20230616113956853](Nacos%E4%BD%BF%E7%94%A8.assets/image-20230616113956853.png)

默认启动到登录页

使用nacos/nacos登录

![image-20230616114032721](Nacos%E4%BD%BF%E7%94%A8.assets/image-20230616114032721.png)

## SpringBoot整合Nacos

### 导入依赖

> 优选商城项目中,依赖放在store-service中
>
> SpringCloud和SpringCloud Alibaba放在父工程pom中,锁定版本

```xml
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
</dependency>
```

### 服务模块配置nacos

application.yml

```yml
spring:
  application:
    name: service-product
  profiles:
    active: dev
  # SpringCloud
  cloud:
    nacos:
      discovery:
        server-addr: localhost:8848
```

> 以上配置,在现存的acl,sys,product模块中都有

### 服务注册

#### 启动类上加注解

```java
/**
 * @author CH_ywx
 * @date 2023-06-10
 * @description 权限管理模块启动类
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ServiceAclApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceAclApplication.class,args);
        System.out.println("权限管理模块启动成功...");
    }
}
```

> @EnableDiscoveryClient

注意:所有微服务模块启动类都会加

### 查看注册的服务

> 注意,开启鉴权后,启动会报错,建议先不开启鉴权,循序渐进

![image-20230616120408335](Nacos%E4%BD%BF%E7%94%A8.assets/image-20230616120408335.png)

> 查看模块启动日志

![image-20230616120444646](Nacos%E4%BD%BF%E7%94%A8.assets/image-20230616120444646.png)

> 查看nacos控制台