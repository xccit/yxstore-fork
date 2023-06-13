# 优选商城项目开发

## 项目架构

### 后端服务

SpringBoot+SpringCloud+SpringCloud Alibaba+Nacos+Redis+RabbitMQ+ElasticSearch+MyBatisPlus等

### 后台管理

Vue+ElementUI+vue-element-admin

### 用户端

微信小程序



## 后端模块划分

```text
store-
	  |common 公共组件
	  		|common-util 公共工具类
	  		|service-util 微服务工具类
	  |model 存放实体类等
	  |service 微服务相关
	          | service-acl 用户角色权限管理
	          | service-sys 系统管理
```



## 代码下载与运行

### 分支

```text
yxstore
	   | master 后端
	   | msi-ui 管理端前端
	   | ui 用户端前端
```

### 下载

```shell
管理端前端
git clone -b msi-ui --single-branch https://gitee.com/xccit/yxstore.git
用户端
git clone -b ui --single-branch https://gitee.com/xccit/yxstore.git
后端
git clone -b master --single-branch https://gitee.com/xccit/yxstore.git
```

### 运行

> 后端:配置数据源,启动中间件
>
> 管理端:配置npm,运行npm install 
>
> 用户端:导入小程序源码

